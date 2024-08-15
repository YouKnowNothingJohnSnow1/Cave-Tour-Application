package com.niewiadoma.CaveTourApplication.service;

import com.niewiadoma.CaveTourApplication.model.Chamber;
import com.niewiadoma.CaveTourApplication.model.Corridor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CaveTourService {

    @Autowired
    private ChamberService chamberService;
    @Autowired
    private CorridorService corridorService;

    public List<Integer> findTourPath(int entryChamberId) {
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(entryChamberId, path, visited);
        return path;
    }

    private boolean dfs(int chamberId, List<Integer> path, Set<Integer> visited) {
        visited.add(chamberId);
        path.add(chamberId);

        if (path.size() == chamberService.getAllChambers().size()) {
            return true;
        }

        Chamber chamber = chamberService.getChamberById(chamberId).orElseThrow();
        List<Corridor> corridors = new ArrayList<>(chamber.getCorridorsFrom());
        corridors.addAll(chamber.getCorridorsTo());

        corridors.sort(Comparator.comparingInt(c -> c.isDifficult() ? 1 : 0)); // Priorytet łatwych korytarzy

        for (Corridor corridor : corridors) {
            int nextChamberId = corridor.getChamberFrom().getId() == chamberId ? corridor.getChamberTo().getId() : corridor.getChamberFrom().getId();
            if (!visited.contains(nextChamberId)) {
                if (dfs(nextChamberId, path, visited)) {
                    return true;
                }
            }
        }

        visited.remove(chamberId);
        path.remove(path.size() - 1);
        return false;
    }




}
