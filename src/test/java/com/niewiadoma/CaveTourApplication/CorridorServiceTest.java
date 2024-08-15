package com.niewiadoma.CaveTourApplication;

import com.niewiadoma.CaveTourApplication.model.Chamber;
import com.niewiadoma.CaveTourApplication.model.Corridor;
import com.niewiadoma.CaveTourApplication.repository.CorridorRepository;
import com.niewiadoma.CaveTourApplication.service.CorridorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CorridorServiceTest {
    @Mock
    private CorridorRepository corridorRepository;

    @InjectMocks
    private CorridorService corridorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCorridors() {
        List<Corridor> corridors = List.of(new Corridor(), new Corridor());
        when(corridorRepository.findAll()).thenReturn(corridors);

        List<Corridor> result = corridorService.getAllCorridors();
        assertEquals(2, result.size());
       verify(corridorRepository, times(1)).findAll();
    }

    @Test
    void testGetCorridorById() {
        Corridor corridor = new Corridor();
        when(corridorRepository.findById(1)).thenReturn(Optional.of(corridor));

        Optional<Corridor> result = corridorService.getCorridorById(1);
        assertTrue(result.isPresent());
        assertEquals(corridor, result.get());
        verify(corridorRepository, times(1)).findById(1);
    }

    @Test
    void testCreateCorridor() {
        Corridor corridor = new Corridor();
        when(corridorRepository.save(corridor)).thenReturn(corridor);

        Corridor result = corridorService.createCorridor(corridor);
        assertEquals(corridor, result);
        verify(corridorRepository, times(1)).save(corridor);
    }

    @Test
    void testUpdateCorridor() {
        Corridor corridor = new Corridor();
        corridor.setId(1);
        Corridor updatedCorridorDetails = new Corridor();
        updatedCorridorDetails.setChamberFrom(new Chamber());
        updatedCorridorDetails.setChamberTo(new Chamber());
        updatedCorridorDetails.setDifficult(true);

        when(corridorRepository.findById(1)).thenReturn(Optional.of(corridor));
        when(corridorRepository.save(any(Corridor.class))).thenReturn(corridor);

        Corridor result = corridorService.updateCorridor(1, updatedCorridorDetails);

        assertNotNull(result);
        assertEquals(corridor.getId(), result.getId());
        assertEquals(updatedCorridorDetails.getChamberFrom(), result.getChamberFrom());
        assertEquals(updatedCorridorDetails.getChamberTo(), result.getChamberTo());
        assertEquals(updatedCorridorDetails.isDifficult(), result.isDifficult());

        verify(corridorRepository, times(1)).findById(1);
        verify(corridorRepository, times(1)).save(any(Corridor.class));
    }

    @Test
    void testDeleteCorridor() {
        doNothing().when(corridorRepository).deleteById(1);

        corridorService.deleteCorridor(1);

        verify(corridorRepository, times(1)).deleteById(1);
    }
}
