package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Jezik;
import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.model.Oblast;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import com.grupaA.knowledgeSharing.services.JezikService;
import com.grupaA.knowledgeSharing.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class KorisnikController
{
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private JezikService jezikService;

    private Korisnik korisnik;
    @RequestMapping("/admin/korisnici")
    public String spisakKorisnika(Model model)
    {
        List<Korisnik> korisnik = this.korisnikService.findAll();
        model.addAttribute("korisnik", korisnik);
        return "admin";
    }
    @PostMapping("/jezici")
    public String spisakJezika(@RequestBody Set<Jezik> jezici, @RequestParam String mojIzbor, Model model)
    {
        //model.addAttribute(jezikService.);
        return "jezici";
    }

    @RequestMapping("/pronajdiPartnera")
    public String pronalazenjePartnera(Model model, Authentication authentication)
    {
        List<Korisnik> korisnici = korisnikRepository.findAll();
        Korisnik korisnik = korisnikRepository.findByMail(authentication.getName());
        int brPredavanje=0, brPredavanjeMax=0;
        int brUcenje=0, brUcenjeMax=0;
        int ukupno=0 , ukupnoMax=0;

        Korisnik bestMatch=null;


        for (Korisnik k: korisnici) {
            if (k.getKorisnikId() != korisnik.getKorisnikId()) {
                Set<Jezik> j = new HashSet<Jezik>(korisnik.getPoznatiJezici());
                j.retainAll(k.getPoznatiJezici());

                if (j.size() > 0) {
                    //provera po tome sta current user moze da predaje
                    Set<Oblast> o = new HashSet<Oblast>(korisnik.getOblastiZaPredavanje());
                    o.retainAll(k.getOblastiZaUcenje());
                    brPredavanje = o.size();

                    //provera po tome sta current user hoce da uci
                    o = new HashSet<Oblast>(korisnik.getOblastiZaUcenje());
                    o.retainAll(k.getOblastiZaPredavanje());
                    brUcenje = o.size();

                    ukupno= brPredavanje + brUcenje;
                    ukupnoMax = brPredavanjeMax + brUcenjeMax;
                    if (ukupno>=ukupnoMax) {
                        brPredavanjeMax = brPredavanje;
                        brUcenjeMax = brUcenje;
                        bestMatch = k;
                    }
                }
            }
        }

        model.addAttribute("bestMatch", bestMatch);

        return "pronalazakPartnera";
    }
}
