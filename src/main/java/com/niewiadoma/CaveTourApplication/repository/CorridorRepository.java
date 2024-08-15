package com.niewiadoma.CaveTourApplication.repository;

import com.niewiadoma.CaveTourApplication.model.Corridor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorridorRepository extends JpaRepository<Corridor, Integer> {
}
