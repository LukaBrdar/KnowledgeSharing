package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class KorisnickiProfil
{
    private KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnickiProfil(KorisnikRepository korisnikRepository)
    {
        this.korisnikRepository = korisnikRepository;
    }

    Authentication authentication;

    @GetMapping("/profile/update")
    public String showUpdateForm(Authentication authentication, Model model)
    {
        String staGod = authentication.getName();
        Korisnik korisnik = korisnikRepository.findByEmail(staGod);
        model.addAttribute("korisnik", korisnik);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateKorisnik(@Valid Korisnik korisnik, Model model, Authentication authentication)
    {
        korisnik.setEmail(authentication.getName());
        korisnikRepository.save(korisnik);
        model.addAttribute("korisnici", korisnikRepository.findAll());
        return "profile";
    }
    @PostMapping("/profile/delete")
    public String deleteKorisnik(@Valid Korisnik korisnik, Authentication authentication, Model model)
    {
        String staGod = authentication.getName();
        korisnik = korisnikRepository.findByEmail(staGod);
        korisnikRepository.delete(korisnik);
        return "redirect:/logout" ;
    }

}
