package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/korisnici")
public class KorisnikController
{
    @Autowired
    private KorisnikService korisnikService;



    @RequestMapping()
    public String index(Model model)
    {
        List<Korisnik> korisnici = this.korisnikService.findAll();
        model.addAttribute("korisnici", korisnici);
        return "index";
    }


}
