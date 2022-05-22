package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.model.Sportiv;
import com.example.ProiectPao1.service.BusinessAntrSportivService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class AntrSportivController {
    private final BusinessAntrSportivService service;
    @GetMapping("/sportiviantr")
    public Map<String, Set<Sportiv>> getAntrenoriSportivi() {
        return service.getAntrenoriSportivi();
    }
    @GetMapping("/sportiviantr/{id}")
    public List<Sportiv> getAllSportiviForAntrenor(@PathVariable Long id){ //se da id antrenor
        return service.getAllSportiviForAntrenor(id);
    }
}
