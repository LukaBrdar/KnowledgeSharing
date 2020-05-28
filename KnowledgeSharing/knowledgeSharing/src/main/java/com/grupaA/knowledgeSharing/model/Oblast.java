package com.grupaA.knowledgeSharing.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "OBLAST")
public class Oblast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oblastId;
    @Column(name = "NazivOblasti", length = 50, nullable = true, unique = false)
    private String naziv;
    public Long getOblastId() {
    	return oblastId;
    }
    public String getNaziv() {
    	return naziv;
    }
    public void setOblastId(Long oblastId) {
    	this.oblastId = oblastId;
    }
    public void setNaziv(String naziv) {
    	this.naziv = naziv;
    }
    public Oblast() {}
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "oblast_id")
    private Set<Podoblast> podoblasti;

}
