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
    public String oblasti(Model model)
    {
        List<Oblast> oblasti = oblastService.findAll();
        model.addAttribute("oblasti", oblasti);
        return "izborOblastiUcenik";
    }

    @PostMapping(value = "/izborOblastiUcenik/post")
    public String oblastiPost(@RequestParam List<Oblast> oblasti, Model model, Authentication authentication)
    {
        Korisnik korisnik = korisnikRepository.findByMail(authentication.getName());

        Set<Oblast> oblastSet = new HashSet<Oblast>();
        for (Oblast oblast:oblasti)
        {
            oblastSet.add(oblast);
        }
        korisnik.setOblastiZaUcenje(oblastSet);
        korisnikRepository.save(korisnik);

        return "redirect:/izborOblastiUcenik";
    }

    @RequestMapping(value = "/izborOblastiPredavac", method = RequestMethod.GET)
    public String oblastiPredavac(Model model)
    {
        List<Oblast> oblasti = oblastService.findAll();
        model.addAttribute("oblasti", oblasti);
        return "izborOblastiPredavac";
    }

    @PostMapping(value = "/izborOblastiPredavac/post")
    public String oblastiPostPredavac(@RequestParam List<Oblast> oblasti, Model model, Authentication authentication)
    {
        Korisnik korisnik = korisnikRepository.findByMail(authentication.getName());

        Set<Oblast> oblastSet = new HashSet<Oblast>();
        for (Oblast oblast:oblasti)
        {
            oblastSet.add(oblast);
        }
        korisnik.setOblastiZaPredavanje(oblastSet);
        korisnikRepository.save(korisnik);

        return "redirect:/izborOblastiPredavac";
    }
}

