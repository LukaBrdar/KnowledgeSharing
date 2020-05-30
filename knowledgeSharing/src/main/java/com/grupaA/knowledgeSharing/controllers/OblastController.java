package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Oblast;
import com.grupaA.knowledgeSharing.services.OblastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OblastController
{
    @Autowired
    private OblastService oblastService;

    @GetMapping("/oblasti")
    List<Oblast>all()
    {
        return this.oblastService.findAll();
    }
}
