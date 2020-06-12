package com.grupaA.knowledgeSharing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class OdlukaController
{

    @RequestMapping(value = "/decision", method = RequestMethod.GET)
    public String izbor()
    {
        return "decision";
    }
    @RequestMapping(value = "/decision/izborOblastiPredavac", method = RequestMethod.GET)
    public String predajem()
    {
        return "izborOblastiPredavac";
    }
    @RequestMapping(value = "/decision/izborOblastiUcenik", method = RequestMethod.GET)
    public String ucim()
    {
        return "izborOblastiUcenik";
    }

}
