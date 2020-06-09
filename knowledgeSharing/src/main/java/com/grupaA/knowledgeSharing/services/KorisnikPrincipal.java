package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Korisnik;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sun.nio.cs.KOI8_R;

import java.util.Collection;
import java.util.Collections;

public class KorisnikPrincipal implements UserDetails {

    private Korisnik korisnik;

    public KorisnikPrincipal(Korisnik korisnik){
        super();
        this.korisnik = korisnik;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(korisnik.getAdminStatus()));
    }

    @Override
    public String getPassword() {
        return korisnik.getSifra();
    }

    @Override
    public String getUsername() {
        return korisnik.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
