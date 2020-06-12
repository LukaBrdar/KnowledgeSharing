package com.grupaA.knowledgeSharing.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "KORISNIK")
public class Korisnik {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korisnik_id", unique = true)
    private Long korisnikId;

    @Column(name = "Ime", length = 50, nullable = true, unique = false)
    private String ime;
    @Column(name = "Prezime", length = 50, nullable = true, unique = false)
    private String prezime;
    @Column(name = "Email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "Sifra", length = 120, nullable = false, unique = false)
    private String sifra;
    @Column(name = "Biografija", length = 4000, nullable = true, unique = false)
    private String biografija;
    @Column(name = "AdminStatus", length = 20, nullable = true, unique = false)
    private String adminStatus;

    public Set<Jezik> getPoznatiJezici()
    {
        return poznatiJezici;
    }

    public void setPoznatiJezici(Set<Jezik> poznatiJezici)
    {
        this.poznatiJezici = poznatiJezici;
    }

    public Set<Oblast> getOblastiZaUcenje()
    {
        return oblastiZaUcenje;
    }

    public void setOblastiZaUcenje(Set<Oblast> oblastiZaUcenje)
    {
        this.oblastiZaUcenje = oblastiZaUcenje;
    }

    public Set<Oblast> getOblastiZaPredavanje()
    {
        return oblastiZaPredavanje;
    }

    public void setOblastiZaPredavanje(Set<Oblast> oblastiZaPredavanje)
    {
        this.oblastiZaPredavanje = oblastiZaPredavanje;
    }

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
            inverseJoinColumns = @JoinColumn(name = "oblast_id"))
    Set<Oblast> oblastiZaUcenje;

    @ManyToMany
    @JoinTable(
            name = "zeli_da_predaje",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "oblast_id"))
    Set<Oblast> oblastiZaPredavanje;



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
    public String getAdminStatus()
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
    public void setAdminStatus(String adminStatus)
    {
        this.adminStatus = adminStatus;
    }

    public Korisnik(Long korisnikId, String ime, String prezime, String email, String sifra, String biografija, String adminStatus){
        this.korisnikId = korisnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
        this.biografija = biografija;
        this.adminStatus = adminStatus;
    }

    public Korisnik(){}
}
