package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Jezik;
import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import com.grupaA.knowledgeSharing.services.JezikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class JezikController
{
    @Autowired
    private JezikService jezikService;

    @Autowired
    private KorisnikRepository korisnikRepository;


    @RequestMapping(value = "/jezici/dodaj", method = RequestMethod.GET)
    public String jezici(Model model, Authentication authentication)
    {
        Korisnik k = korisnikRepository.findByMail(authentication.getName());
        Set<Jezik> j = new HashSet<Jezik>(k.getPoznatiJezici());
        Set<Jezik> jezici = jezikService.findAllSet();
        jezici.removeAll(j);

        model.addAttribute("jezici", jezici);
        return "jezici";
    }

    @PostMapping(value = "/jezici/dodaj/post")
    public String jeziciPost(@RequestParam Set<Jezik> jezici, Model model, Authentication authentication)
    {
        Korisnik korisnik= korisnikRepository.findByMail(authentication.getName());

            Set<Jezik> jezikSet = new HashSet<Jezik>();
            for (Jezik jezik:jezici)
            {
                jezikSet.add(jezik);
            }
            korisnik.setPoznatiJezici(jezikSet);
            korisnikRepository.save(korisnik);
            return "redirect:/profile";
    }

    @RequestMapping(value = "/brisanjeJezika", method = RequestMethod.GET)
    public String brisanjeJezika(Model model, Authentication authentication)
    {
        Korisnik k = korisnikRepository.findByMail(authentication.getName());
        Set<Jezik> j = new HashSet<Jezik>(k.getPoznatiJezici());

        model.addAttribute("jezici", j);
        return "brisanjeJezika";
    }
    @RequestMapping(value = "/brisanjeJezika/post", method = RequestMethod.POST)
    public String brisnjeJezikaPost(@RequestParam Set<Jezik> jezici, Model model, Authentication authentication)
    {
        Korisnik korisnik= korisnikRepository.findByMail(authentication.getName());
        Set<Jezik> jezikSet = new HashSet<Jezik>(korisnik.getPoznatiJezici());
        for (Jezik jezik:jezici)
        {
            jezikSet.remove(jezik);
        }
        korisnik.setPoznatiJezici(jezikSet);
        korisnikRepository.save(korisnik);
        return "redirect:/profile";
    }
}
