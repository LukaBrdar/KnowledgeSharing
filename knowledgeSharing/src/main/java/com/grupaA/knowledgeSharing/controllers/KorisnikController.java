package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Jezik;
import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.services.JezikService;
import com.grupaA.knowledgeSharing.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Set;

@Controller
public class KorisnikController
{
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private JezikService jezikService;

    private Korisnik korisnik;
    @RequestMapping("/admin/korisnici")
    public String spisakKorisnika(Model model)
    {
        List<Korisnik> korisnik = this.korisnikService.findAll();
        model.addAttribute("korisnik", korisnik);
        return "admin";
    }
    @PostMapping("/jezici")
    public String spisakJezika(@RequestBody Set<Jezik> jezici, @RequestParam String mojIzbor, Model model)
    {
        //model.addAttribute(jezikService.);
        return "jezici";
    }
}
