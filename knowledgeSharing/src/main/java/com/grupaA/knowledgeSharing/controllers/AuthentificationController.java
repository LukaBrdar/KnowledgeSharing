package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import com.grupaA.knowledgeSharing.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class AuthentificationController
{
    @Autowired
    KorisnikService korisnikService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register()
    {
        ModelAndView modelAndView = new ModelAndView();
        Korisnik korisnik = new Korisnik();
        modelAndView.addObject("korisnik", korisnik);
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerKorisnika(@Valid Korisnik korisnik, BindingResult bindingResult, ModelMap modelMap)
    {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors())
        {
            modelAndView.addObject("poruka", "Molimo Vas da ispravite greske");
            modelMap.addAttribute("bindingResult", bindingResult);
        }
        else if(korisnikService.postojiKorisnik(korisnik))
        {
            modelAndView.addObject("poruka", "Korisnik sa ovim emailom je vec registrovan!");
        }
        else
        {
            korisnikService.sacuvajKorisnika(korisnik);
            modelAndView.addObject("poruka", "Registrovali ste se");
        }
        modelAndView.addObject("korisnik", new Korisnik());
        modelAndView.setViewName("register");
        return modelAndView;
    }

}
