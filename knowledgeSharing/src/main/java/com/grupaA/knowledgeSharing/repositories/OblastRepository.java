package com.grupaA.knowledgeSharing.repositories;

import com.grupaA.knowledgeSharing.model.Oblast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface OblastRepository extends JpaRepository<Oblast, Long>
{
    @Query("SELECT o from Oblast o where o.naziv like ?1")
    public Oblast findByName(String naziv);

    @Query("SELECT o from Oblast o")
    public Set<Oblast> findAllSet();
}
