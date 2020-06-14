package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Jezik;
import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.model.Oblast;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @RequestMapping(value = "/profile")
    public String pregledProfila(Authentication authentication, Model model)
    {
        Korisnik korisnik = korisnikRepository.findByMail(authentication.getName());
        Set<Jezik> jezici =korisnik.getPoznatiJezici();
        Set<Oblast> uci = korisnik.getOblastiZaUcenje();
        Set<Oblast> predaje = korisnik.getOblastiZaPredavanje();

        model.addAttribute("korisnik",korisnik);
        model.addAttribute("jezici",jezici);
        model.addAttribute("uci",uci);
        model.addAttribute("predaje",predaje);

        return "korisnikProfil";
    }


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
