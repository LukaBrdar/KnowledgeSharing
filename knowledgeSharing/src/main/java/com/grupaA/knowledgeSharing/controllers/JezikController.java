package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Jezik;
import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.services.JezikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class JezikController
{
    @Autowired
    private JezikService jezikService;

    /*@GetMapping("/jezici")
    List<Jezik> all()
    {
        return this.jezikService.findAll();
    }*/

    @RequestMapping(value = "/jezici", method = RequestMethod.GET)
    public String jezici(Model model)
    {
        List<Jezik> jezici = jezikService.findAll();
        model.addAttribute("jezici", jezici);
        return "jezici";
    }
}
