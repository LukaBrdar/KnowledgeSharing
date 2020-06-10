package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Oblast;
import com.grupaA.knowledgeSharing.model.Podoblast;
import com.grupaA.knowledgeSharing.services.PodoblastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/oblastipretraga")
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
