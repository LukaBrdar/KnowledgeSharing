package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService implements IKorisnikService
{
    @Autowired
    KorisnikRepository korisnikRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    ModelAndView modelAndView = new ModelAndView();

    @Override
    public Optional<Korisnik> findById(Long id)
    {
        return korisnikRepository.findById(id);
    }


    public List<Korisnik> findAll()
    {
        return this.korisnikRepository.findAll();
    }

    public void sacuvajKorisnika(Korisnik korisnik)
    {
        korisnik.setSifra(passwordEncoder.encode(korisnik.getSifra()));

        korisnikRepository.save(korisnik);
    }

    public boolean postojiKorisnik(Korisnik korisnik)
    {
        boolean korisnikVecPostoji=false;
        Korisnik postojeciKorisnik = korisnikRepository.findByEmail(korisnik.getEmail());
        if(postojeciKorisnik!=null)
        {
            korisnikVecPostoji=true;
        }
        return korisnikVecPostoji;
    }
}
