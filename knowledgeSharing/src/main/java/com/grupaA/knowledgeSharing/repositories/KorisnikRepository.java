package com.grupaA.knowledgeSharing.repositories;

import com.grupaA.knowledgeSharing.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>
{
    Korisnik findByEmail(String email);
}
