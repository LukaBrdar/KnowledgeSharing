package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Podoblast;
import com.grupaA.knowledgeSharing.services.PodoblastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PodoblastController
{
    @Autowired
    private PodoblastService podoblastService;

    @GetMapping("/podoblast")
    List<Podoblast> all()
    {
        return this.podoblastService.findAll();
    }
}
