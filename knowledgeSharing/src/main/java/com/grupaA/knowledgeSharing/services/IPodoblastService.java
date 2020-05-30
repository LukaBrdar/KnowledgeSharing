package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Podoblast;
import java.util.Optional;

public interface IPodoblastService
{
    Optional<Podoblast> findById(Long id);
}
