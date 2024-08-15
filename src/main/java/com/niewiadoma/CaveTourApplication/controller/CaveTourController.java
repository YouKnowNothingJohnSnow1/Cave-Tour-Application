package com.niewiadoma.CaveTourApplication.controller;

import com.niewiadoma.CaveTourApplication.service.CaveTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cave-tour")
public class CaveTourController {


    @Autowired
    private CaveTourService caveTourService;

    @GetMapping("/path")
    public ResponseEntity<List<Integer>> getTourPath(@RequestParam int entryChamberId) {
        List<Integer> path = caveTourService.findTourPath(entryChamberId);
        return ResponseEntity.ok(path);
    }
}
