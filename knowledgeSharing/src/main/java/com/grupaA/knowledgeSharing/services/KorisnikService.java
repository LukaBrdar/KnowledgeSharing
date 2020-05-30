package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupaA.knowledgeSharing.repositories.KorisnikRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService implements IKorisnikService
{
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public Optional<Korisnik> findById(Long id)
    {
        return korisnikRepository.findById(id);
    }

    public List<Korisnik> findAll()
    {
        return this.korisnikRepository.findAll();
    }
}
