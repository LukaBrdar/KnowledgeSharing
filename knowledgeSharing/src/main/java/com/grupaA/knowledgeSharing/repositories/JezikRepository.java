package com.grupaA.knowledgeSharing.repositories;

import com.grupaA.knowledgeSharing.model.Jezik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JezikRepository extends JpaRepository<Jezik, Long>
{

}
