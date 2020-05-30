package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class KorisnikController
{
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/korisnici")
    List<Korisnik> all()
    {
        return this.korisnikService.findAll();
    }
}
