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
    public String updateStudent(@PathVariable("korisnik_id") Long korisnik_id, @Valid Korisnik korisnik,  Model model)
    {
        korisnik.setKorisnikId(korisnik_id);
        korisnikRepository.save(korisnik);
        model.addAttribute("korisnici", korisnikRepository.findAll());
        return "update";
    }
    @GetMapping("delete/{korisnik_id}")
    public String deleteStudent(@PathVariable("korisnik_id") long korisnik_id, Model model)
    {
        Korisnik korisnik = korisnikRepository.findById(korisnik_id)
                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika:" + korisnik_id));
        korisnikRepository.delete(korisnik);
        model.addAttribute("korisnik", korisnikRepository.findAll());
        return "admin";
    }
}
