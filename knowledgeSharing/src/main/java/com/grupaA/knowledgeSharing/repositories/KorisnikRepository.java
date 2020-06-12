package com.grupaA.knowledgeSharing.repositories;

import com.grupaA.knowledgeSharing.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>
{
    Korisnik findByEmail(String email);

    @Query("SELECT k from Korisnik k where k.email like ?1")
    Korisnik findByMail(String mail);
}
