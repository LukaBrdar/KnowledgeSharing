package com.grupaA.knowledgeSharing.services;

import com.grupaA.knowledgeSharing.model.Oblast;
import java.util.Optional;

public interface IOblastService
{
    Optional<Oblast> findById(Long id);
}
