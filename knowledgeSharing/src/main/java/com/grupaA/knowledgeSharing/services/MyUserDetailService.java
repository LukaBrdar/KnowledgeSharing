package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Korisnik;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Korisnik korisnik = korisnikRepository.findByEmail(email);
        if(korisnik==null){
            throw new UsernameNotFoundException("Korisnik nije pronadjen");
        }
        return new KorisnikPrincipal(korisnik);
    }
}
