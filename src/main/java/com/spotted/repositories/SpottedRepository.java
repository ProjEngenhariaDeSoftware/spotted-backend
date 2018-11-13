package com.spotted.repositories;

import com.spotted.models.Spotted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpottedRepository extends JpaRepository<Spotted, Long> {

    @Query("select s from Spotted s where s.visible = true")
    List<Spotted> findVisible();

    @Query("select s from Spotted s where s.visible = false")
    List<Spotted> findHidden();
}
