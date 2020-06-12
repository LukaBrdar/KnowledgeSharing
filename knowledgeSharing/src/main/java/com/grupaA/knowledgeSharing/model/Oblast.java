package com.grupaA.knowledgeSharing.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "OBLAST")
public class Oblast {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oblast_id", unique = true)
    private Long oblastId;
    @Column(name = "naziv_oblasti", length = 50, nullable = true, unique = false)
    private String naziv;

    @ManyToMany(mappedBy = "oblastiZaUcenje", cascade = CascadeType.MERGE)
    Set<Korisnik> korisniciUcenje;

    @ManyToMany(mappedBy = "oblastiZaPredavanje", cascade = CascadeType.MERGE)
    Set<Korisnik> korisniciPredavanje;

    public Long getOblastId()
    {
        return oblastId;
    }
    public String getNaziv()
    {
        return naziv;
    }
    public void setOblastId(Long oblastId)
    {
        this.oblastId = oblastId;
    }
    public void setNaziv(String naziv)
    {
        this.naziv = naziv;
    }

}

