package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Korisnik;
import java.util.Optional;

public interface IKorisnikService
{
    Optional<Korisnik> findById(Long id);
}
