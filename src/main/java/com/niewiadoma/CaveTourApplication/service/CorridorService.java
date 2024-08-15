package com.niewiadoma.CaveTourApplication.service;

import com.niewiadoma.CaveTourApplication.model.Corridor;
import com.niewiadoma.CaveTourApplication.repository.CorridorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorridorService {

    @Autowired
    private CorridorRepository corridorRepository;

    public List<Corridor> getAllCorridors() {
        return corridorRepository.findAll();
    }

    public Optional<Corridor> getCorridorById(int id) {
        return corridorRepository.findById(id);
    }

    @Transactional
    public Corridor createCorridor(Corridor corridor) {
        return corridorRepository.save(corridor);
    }

    @Transactional
    public Corridor updateCorridor(int id, Corridor corridorDetails) {
        Optional<Corridor> optionalCorridor = corridorRepository.findById(id);

        if (optionalCorridor.isPresent()) {
            Corridor corridor = optionalCorridor.get();
            corridor.setChamberFrom(corridorDetails.getChamberFrom());
            corridor.setChamberTo(corridorDetails.getChamberTo());
            corridor.setDifficult(corridorDetails.isDifficult());
            return corridorRepository.save(corridor);
        } else {
            throw new RuntimeException("Corridor not found with id " + id);
        }
    }

    @Transactional
    public void deleteCorridor(int id) {
        corridorRepository.deleteById(id);
    }


}
