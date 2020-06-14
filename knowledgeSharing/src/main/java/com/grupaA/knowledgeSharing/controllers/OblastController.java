package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.model.Oblast;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import com.grupaA.knowledgeSharing.services.OblastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class OblastController
{
    @Autowired
    private OblastService oblastService;

    @Autowired
    private KorisnikRepository korisnikRepository;


    @RequestMapping(value = "/izborOblastiUcenik", method = RequestMethod.GET)
    public String oblasti(Model model, Authentication authentication)
    {
        Korisnik k = korisnikRepository.findByMail(authentication.getName());
        Set<Oblast> predaje= new HashSet<Oblast>(k.getOblastiZaPredavanje());
        Set<Oblast> oblasti = oblastService.findAllSet();

        oblasti.removeAll(predaje);

        Set<Oblast> uci= new HashSet<Oblast>(k.getOblastiZaUcenje());

        oblasti.removeAll(uci);


        model.addAttribute("oblasti", oblasti);
        return "izborOblastiUcenik";
    }

    @PostMapping(value = "/izborOblastiUcenik/post")
    public String oblastiPost(@RequestParam List<Oblast> oblasti, Model model, Authentication authentication)
    {
        Korisnik korisnik = korisnikRepository.findByMail(authentication.getName());

        korisnik.getOblastiZaUcenje().addAll(oblasti);

        korisnikRepository.save(korisnik);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/izborOblastiPredavac", method = RequestMethod.GET)
    public String oblastiPredavac(Model model, Authentication authentication)
    {
        Korisnik k = korisnikRepository.findByMail(authentication.getName());
        Set<Oblast> uci= new HashSet<Oblast>(k.getOblastiZaUcenje());
        Set<Oblast> oblasti = oblastService.findAllSet();

        oblasti.removeAll(uci);

        Set<Oblast> predaje= new HashSet<Oblast>(k.getOblastiZaPredavanje());

        oblasti.removeAll(predaje);
        model.addAttribute("oblasti", oblasti);
        return "izborOblastiPredavac";
    }

    @PostMapping(value = "/izborOblastiPredavac/post")
    public String oblastiPostPredavac(@RequestParam List<Oblast> oblasti, Model model, Authentication authentication)
    {
        Korisnik korisnik = korisnikRepository.findByMail(authentication.getName());

        korisnik.getOblastiZaPredavanje().addAll(oblasti);

        korisnikRepository.save(korisnik);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/brisanjeOblastiUcenik")
    public String brisanjeOblastiUcenik(Model model, Authentication authentication)
    {
        Korisnik k = korisnikRepository.findByMail(authentication.getName());
        Set<Oblast> oblasti=k.getOblastiZaUcenje();

        model.addAttribute("oblasti", oblasti);
        return "brisanjeOblastiUcenik";
    }

    @RequestMapping(value = "/brisanjeOblastiUcenik/post", method = RequestMethod.POST)
    public String brisanjeOblastiUcenikPost(@RequestParam Set<Oblast> oblasti, Model model, Authentication authentication)
    {
        Korisnik k = korisnikRepository.findByMail(authentication.getName());

        Set<Oblast> uci = k.getOblastiZaUcenje();
        for (Oblast o: oblasti) {
            uci.remove(o);
        }

        k.setOblastiZaUcenje(uci);
        korisnikRepository.save(k);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/brisanjeOblastiPredavac")
    public String brisanjeOblastiPredavac(Model model, Authentication authentication)
    {
        Korisnik k = korisnikRepository.findByMail(authentication.getName());
        Set<Oblast> oblasti=k.getOblastiZaPredavanje();

        model.addAttribute("oblasti", oblasti);
        return "brisanjeOblastiPredavac";
    }

    @RequestMapping(value = "/brisanjeOblastiPredavac/post", method = RequestMethod.POST)
    public String brisanjeOblastiPredavacPost(@RequestParam Set<Oblast> oblasti, Model model, Authentication authentication)
    {
        Korisnik k = korisnikRepository.findByMail(authentication.getName());

        Set<Oblast> predaje = k.getOblastiZaPredavanje();
        for (Oblast o: oblasti) {
            predaje.remove(o);
        }

        k.setOblastiZaPredavanje(predaje);
        korisnikRepository.save(k);

        return "redirect:/profile";
    }

}

