package com.grupaA.knowledgeSharing.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "KORISNIK")
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long korisnikId;
    @Column(name = "Ime", length = 50, nullable = true, unique = false)
    private String ime;
    @Column(name = "Prezime", length = 50, nullable = true, unique = false)
    private String prezime;
    @Column(name = "Email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "Sifra", length = 50, nullable = false, unique = false)
    private String sifra;
    @Column(name = "Biografija", length = 4000, nullable = true, unique = false)
    private String biografija;
    @Column(name = "AdminStatus", nullable = true, unique = false)
    private Boolean adminStatus;

    @ManyToMany
    @JoinTable(
            name = "korisnicki_jezici",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "jezik_id"))
    Set<Jezik> poznatiJezici;

    @ManyToMany
    @JoinTable(
            name = "zeli_da_uci",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "podoblast_id"))
    Set<Podoblast> podoblastiZaUcenje;

    @ManyToMany
    @JoinTable(
            name = "zeli_da_predaje",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "podoblast_id"))
    Set<Podoblast> podoblastiZaPredavanje;

    public Long getKorisnikId()
    {
        return korisnikId;
    }
    public String getIme()
    {
        return ime;
    }
    public String getPrezime()
    {
        return prezime;
    }
    public String getEmail()
    {
        return email;
    }
    public String getSifra()
    {
        return sifra;
    }
    public String getBiografija()
    {
        return biografija;
    }
    public Boolean getAdminStatus()
    {
        return adminStatus;
    }
    //Setters:
    public void setKorisnikId(Long korisnikId)
    {
        this.korisnikId = korisnikId;
    }
    public void setIme(String ime)
    {
        this.ime = ime;
    }
    public void setPrezime(String prezime)
    {
        this.prezime = prezime;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setSifra(String sifra)
    {
        this.sifra = sifra;
    }
    public void setBiografija(String biografija)
    {
        this.biografija = biografija;
    }
    public void setAdminStatus(Boolean adminStatus)
    {
        this.adminStatus = adminStatus;
    }

}
