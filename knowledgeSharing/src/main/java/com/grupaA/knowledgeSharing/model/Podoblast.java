package com.grupaA.knowledgeSharing.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PODOBLASTI")
public class Podoblast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long podoblastiId;
    @Column(name = "NazivPodoblasti", length = 50, nullable = true, unique = false)
    private String nazivPodoblasti;

    @ManyToOne
    @JoinColumn(name = "oblast_id")
    private Oblast oblast;

    @ManyToMany(mappedBy = "podoblastiZaUcenje")
    Set<Korisnik> korisniciUcenje;

    @ManyToMany(mappedBy = "podoblastiZaPredavanje")
    Set<Korisnik> korisniciPredavanje;
}
