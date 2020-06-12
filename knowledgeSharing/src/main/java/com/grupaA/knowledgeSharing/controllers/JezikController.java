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


    @RequestMapping(value = "/jezici", method = RequestMethod.GET)
    public String jezici(Model model)
    {
        List<Jezik> jezici = jezikService.findAll();
        model.addAttribute("jezici", jezici);
        return "jezici";
    }

    @PostMapping(value = "/jezici/post")
    public String jeziciPost(@RequestParam List<Jezik> jezici, Model model, Authentication authentication)
    {
        Korisnik korisnik= korisnikRepository.findByMail(authentication.getName());


        Set<Jezik> jezikSet = new HashSet<Jezik>();
        for (Jezik jezik:jezici) {
            jezikSet.add(jezik);
        }
        korisnik.setPoznatiJezici(jezikSet);
        korisnikRepository.save(korisnik);

        return "redirect:/jezici";
    }
}
