package com.grupaA.knowledgeSharing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{
    @RequestMapping("/pocetna")
    public String index(Model model)
    {
        return "pocetna";
    }
}
