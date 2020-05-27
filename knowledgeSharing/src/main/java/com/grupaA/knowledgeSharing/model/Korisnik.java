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

}
