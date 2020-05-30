package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Oblast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupaA.knowledgeSharing.repositories.OblastRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OblastService implements IOblastService
{
    @Autowired
    private OblastRepository oblastRepository;

    @Override
    public Optional<Oblast> findById(Long id)
    {
        return oblastRepository.findById(id);
    }
    public List<Oblast> findAll()
    {
        return this.oblastRepository.findAll();
    }
}
