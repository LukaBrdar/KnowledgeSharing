package com.grupaA.knowledgeSharing.controllers;

import com.grupaA.knowledgeSharing.model.Jezik;
import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.model.Oblast;
import com.grupaA.knowledgeSharing.repositories.JezikRepository;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import com.grupaA.knowledgeSharing.repositories.OblastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController
{
    private KorisnikRepository korisnikRepository;

    @Autowired
    private OblastRepository oblastRepository;
    @Autowired
    private JezikRepository jezikRepository;
    @Autowired
    public AdminController(KorisnikRepository korisnikRepository)
    {
        this.korisnikRepository = korisnikRepository;
    }

    public AdminController(JezikRepository jezikRepository)
    {
        this.jezikRepository = jezikRepository;
    }

    public AdminController(OblastRepository oblastRepository1)
    {
        this.oblastRepository = oblastRepository;
    }

    @GetMapping("/korisnici/update/{korisnik_id}")
    public String showUpdateForm(@PathVariable("korisnik_id") Long korisnik_id, Model model)
    {
        Korisnik korisnik = korisnikRepository.findById(korisnik_id)
                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika:" + korisnik_id));
        model.addAttribute("korisnik", korisnik);
        return "update";
    }

    @PostMapping("/korisnici/update/{korisnik_id}")
    public String updateStudent(@PathVariable("korisnik_id") Long korisnik_id, @Valid Korisnik korisnik,  Model model)
    {
        korisnik.setKorisnikId(korisnik_id);
        korisnikRepository.save(korisnik);
        model.addAttribute("korisnici", korisnikRepository.findAll());
        return "update";
    }
    @GetMapping("/korisnici/delete/{korisnik_id}")
    public String deleteStudent(@PathVariable("korisnik_id") long korisnik_id, Model model)
    {
        Korisnik korisnik = korisnikRepository.findById(korisnik_id)
                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika:" + korisnik_id));
        korisnikRepository.delete(korisnik);
        model.addAttribute("korisnik", korisnikRepository.findAll());
        return "admin";
    }
    @GetMapping("/admin/dodavanje")
    public String dodavanjeOblastiForma(Model model)
    {
        Oblast oblast = new Oblast();
        model.addAttribute("oblast", oblast);
        return "dodavanje";
    }
    @PostMapping("/admin/dodavanje/post")
    public String dodavanjeOblasti(Oblast oblast, BindingResult bindingResult, ModelMap modelMap)
    {
        ModelAndView modelAndView = new ModelAndView();
        Oblast o = oblastRepository.findByName(oblast.getNaziv());
        if(bindingResult.hasErrors())
        {
            modelAndView.addObject("poruka", "Molimo Vas da ispravite greske");
            modelMap.addAttribute("bindingResult", bindingResult);
        }
        else if(o!=null)
        {
            modelAndView.addObject("poruka", "Uneta oblast vec postoji!");
        }
        else
        {
            oblastRepository.save(oblast);
            modelAndView.addObject("poruka", "Uspesno ste dodali oblast");
        }
        modelAndView.addObject("oblast", new Oblast());
        return "redirect:/admin/oblasti";
    }
    @GetMapping("/admin/oblasti")
    public String listaOblasti(Model model)
    {
        List<Oblast> oblasti = oblastRepository.findAll();
        model.addAttribute("oblasti",oblasti);
        return  "listaOblasti";
    }
    @GetMapping("/admin/jezici")
    public String listaJezika(Model model)
    {
        List<Jezik> jezici = jezikRepository.findAll();
        model.addAttribute("jezici",jezici);
        return "listaJezika";
    }
    @GetMapping("/admin/dodavanjeJezika")
    public String dodavanjeJezikaForma(Model model)
    {
        Jezik jezik = new Jezik();
        model.addAttribute("jezik", jezik);
        return "dodavanjeJezika";
    }
    @PostMapping("/admin/dodavanjeJezika/post")
    public String dodavanjeJezika(Jezik jezik, BindingResult bindingResult, ModelMap modelMap)
    {
        ModelAndView modelAndView = new ModelAndView();
        Jezik j = jezikRepository.findByName(jezik.getNaziv());
        if(bindingResult.hasErrors())
        {
            modelAndView.addObject("poruka", "Molimo Vas da ispravite greske");
            modelMap.addAttribute("bindingResult", bindingResult);
        }
        else if(j!=null)
        {
            modelAndView.addObject("poruka", "Uneta oblast vec postoji!");
        }
        else
        {
            jezikRepository.save(jezik);
            modelAndView.addObject("poruka", "Uspesno ste dodali jezik");
        }
        modelAndView.addObject("jezik", new Jezik());
        return  "redirect:/admin/jezici";
    }
}
