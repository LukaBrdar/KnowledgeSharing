package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Jezik;
import java.util.Optional;

public interface IJezikService
{
    Optional<Jezik> findById(Long id);
}
