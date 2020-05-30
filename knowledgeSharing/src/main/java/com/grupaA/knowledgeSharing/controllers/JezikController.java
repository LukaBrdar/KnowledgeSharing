package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Jezik;
import com.grupaA.knowledgeSharing.services.JezikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JezikController
{
    @Autowired
    private JezikService jezikService;

    @GetMapping("/jezici")
    List<Jezik> all()
    {
        return this.jezikService.findAll();
    }
}
