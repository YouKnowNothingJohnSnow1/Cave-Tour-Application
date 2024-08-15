package com.niewiadoma.CaveTourApplication.service;

import com.niewiadoma.CaveTourApplication.model.Chamber;
import com.niewiadoma.CaveTourApplication.repository.ChamberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamberService {


    @Autowired
    private ChamberRepository chamberRepository;

    public List<Chamber> getAllChambers() {
        return chamberRepository.findAll();
    }

    public Optional<Chamber> getChamberById(int id) {
        return chamberRepository.findById(id);
    }

    public Chamber saveChamber(Chamber chamber) {
        return chamberRepository.save(chamber);
    }
}
