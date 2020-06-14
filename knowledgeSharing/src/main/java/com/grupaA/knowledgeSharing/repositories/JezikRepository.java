package com.grupaA.knowledgeSharing.repositories;

import com.grupaA.knowledgeSharing.model.Jezik;
import com.grupaA.knowledgeSharing.model.Oblast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface JezikRepository extends JpaRepository<Jezik, Long>
{
    @Query("SELECT j from Jezik j where j.naziv like ?1")
    public Jezik findByName(String naziv);

    @Query("select j from Jezik j")
    public Set<Jezik> findAllSet();
}
