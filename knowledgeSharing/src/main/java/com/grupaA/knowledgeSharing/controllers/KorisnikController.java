package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class KorisnikController
{
    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping("/korisnici")
    public String spisakKorisnika(Model model)
    {
        List<Korisnik> korisnik = this.korisnikService.findAll();
        model.addAttribute("korisnik", korisnik);
        return "admin";
    }

}
