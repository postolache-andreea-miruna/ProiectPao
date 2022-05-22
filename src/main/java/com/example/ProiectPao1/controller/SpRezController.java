package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Rezultat;
import com.example.ProiectPao1.model.Sportiv;
import com.example.ProiectPao1.model.SportivDto;
import com.example.ProiectPao1.model.SportivLotDto;
import com.example.ProiectPao1.service.BusinessSportivRezService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SpRezController {
    private final BusinessSportivRezService service;
    @GetMapping("/sportivrez/{id}")
    public List<Rezultat> getAllRezultateForSportiv(@PathVariable Long id){
        return service.getAllRezultateForSportiv(id);
    }
    @GetMapping("/sportivirez")
    public Map<Long,List<Rezultat>> getSportiviSiRez(){
        return service.getSportiviSiRez();
    }

}
