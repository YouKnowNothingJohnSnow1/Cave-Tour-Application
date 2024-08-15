package com.niewiadoma.CaveTourApplication.repository;

import com.niewiadoma.CaveTourApplication.model.Chamber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamberRepository extends JpaRepository<Chamber, Integer> {
}
