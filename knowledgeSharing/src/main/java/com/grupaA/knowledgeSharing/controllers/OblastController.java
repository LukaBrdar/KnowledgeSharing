package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Oblast;
import com.grupaA.knowledgeSharing.model.Podoblast;
import com.grupaA.knowledgeSharing.services.OblastService;
import com.grupaA.knowledgeSharing.services.PodoblastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class OblastController
{
    @Autowired
    private OblastService oblastService;
    @Autowired
    private PodoblastService podoblastService;

    @RequestMapping(value = "/izborOblasti", method = RequestMethod.GET)
    public String oblasti(Model model)
    {
    	List<Oblast> oblasti = oblastService.findAll();
    	model.addAttribute("oblasti", oblasti);
    	return "izborOblasti";
    }

}
