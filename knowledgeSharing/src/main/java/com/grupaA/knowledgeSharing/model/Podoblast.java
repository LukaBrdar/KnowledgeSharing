package com.grupaA.knowledgeSharing.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PODOBLASTI")
public class Podoblast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long podoblastId;
    @Column(name = "NazivPodoblasti", length = 50, nullable = true, unique = false)
    private String nazivPodoblasti;

    @ManyToOne
    @JoinColumn(name = "oblast_id")
    private Oblast oblast;

    @ManyToMany(mappedBy = "podoblastiZaUcenje")
    Set<Korisnik> korisniciUcenje;

    @ManyToMany(mappedBy = "podoblastiZaPredavanje")
    Set<Korisnik> korisniciPredavanje;

    public Long getPodoblastId()
    {
        return podoblastId;
    }
    public String getNazivPodoblasti()
    {
        return nazivPodoblasti;
    }
    public void setPodoblastId(Long podoblastId)
    {
        this.podoblastId = podoblastId;
    }
    public void setNazivPodoblasti(String nazivPodoblasti)
    {
        this.nazivPodoblasti = nazivPodoblasti;
    }
}
