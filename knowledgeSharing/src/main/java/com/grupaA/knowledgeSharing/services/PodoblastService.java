package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Podoblast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupaA.knowledgeSharing.repositories.PodoblastRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PodoblastService implements IPodoblastService
{
    @Autowired
    private PodoblastRepository podoblastRepository;

    @Override
    public Optional<Podoblast> findById(Long id)
    {
        return podoblastRepository.findById(id);
    }
    public List<Podoblast> findAll()
    {
        return this.podoblastRepository.findAll();
    }
}
