package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.model.Rezultat;
import com.example.ProiectPao1.model.Sala;
import com.example.ProiectPao1.model.Sportiv;
import com.example.ProiectPao1.service.BusinessSporAntrService;
import com.example.ProiectPao1.service.BusinessSportivRezService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class SportAntrController {
    private final BusinessSporAntrService service;
    @GetMapping("/sportantr")
    public Map<String, Set<Antrenor>> getAntrenoriForTipSport(){
        return service.getAntrenoriForTipSport();
    }

    @GetMapping("/sportsali")
    public Map<String, Set<Sala>> getSaliForTipSport(){
        return service.getSaliForTipSport();
    }

}
