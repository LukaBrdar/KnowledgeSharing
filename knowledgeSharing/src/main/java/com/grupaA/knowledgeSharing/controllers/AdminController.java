package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/korisnici")
public class AdminController
{
    private KorisnikRepository korisnikRepository;

    @Autowired
    public AdminController(KorisnikRepository korisnikRepository)
    {
        this.korisnikRepository = korisnikRepository;
    }

    @GetMapping("update/{korisnik_id}")
    public String showUpdateForm(@PathVariable("korisnik_id") Long korisnik_id, Model model)
    {
        Korisnik korisnik = korisnikRepository.findById(korisnik_id)
                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika:" + korisnik_id));
        model.addAttribute("korisnik", korisnik);
        return "update";
    }

    @PostMapping("update/{korisnik_id}")
    public String updateStudent(@PathVariable("korisnik_id") Long korisnik_id, @Valid Korisnik korisnik, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            korisnik.setKorisnikId(korisnik_id);
            return "update";
        }
        korisnik.setKorisnikId(korisnik_id);
        korisnikRepository.save(korisnik);
        model.addAttribute("korisnici", korisnikRepository.findAll());
        return "update";
    }
}
