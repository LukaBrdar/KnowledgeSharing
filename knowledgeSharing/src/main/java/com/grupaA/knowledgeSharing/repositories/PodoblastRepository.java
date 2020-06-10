package com.grupaA.knowledgeSharing.repositories;

import com.grupaA.knowledgeSharing.model.Podoblast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PodoblastRepository extends JpaRepository<Podoblast, Long>
{
    List<Podoblast> findAllByOblast_OblastId(Long OblastId);
}
