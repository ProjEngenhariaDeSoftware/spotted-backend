package com.spotted.repositories;

import com.spotted.models.Spotted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpottedRepository extends JpaRepository<Spotted, Long> {

}
