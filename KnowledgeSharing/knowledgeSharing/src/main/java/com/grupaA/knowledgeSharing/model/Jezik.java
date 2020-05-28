package com.grupaA.knowledgeSharing.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="JEZIK")
public class Jezik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jezikId;
    @Column(name="Naziv", length=50, nullable=true, unique=false)
    private String naziv;
    public Long getJezikId() {
    	return jezikId;
    }
    public String getNaziv() {
    	return naziv;
    }
    public void setJezikId(Long jezikId) {
    	this.jezikId = jezikId;
    }
    public void setNaziv(String naziv) {
    	this.naziv = naziv;
    }
    public Jezik() {}

    @ManyToMany(mappedBy = "poznatiJezici")
    Set<Korisnik> korisnici;

}
