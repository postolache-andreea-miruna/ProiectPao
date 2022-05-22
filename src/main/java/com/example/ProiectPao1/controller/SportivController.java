package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.*;
import com.example.ProiectPao1.service.SportivService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SportivController {
    private final SportivService service;

    @GetMapping("/sportivi")
    public List<Sportiv> getAllSportivi(){
        return service.getAllSportivi();
    }

    @GetMapping("/sportivi/{id}")
    public SportivDto getSportivDtoById(@PathVariable Long id)
    {
        return service.getSportivDtoById(id);
    }
    @GetMapping("/sportivi/lot/{id}")
    public SportivLotDto getSportivLotDtoById(@PathVariable Long id)
    {
        return service.getSportivLotDtoById(id);
    }

    @PutMapping("/sportivi/{id}")
    public Sportiv updateSportiv(@RequestBody Sportiv sportiv, @PathVariable Long id) throws Exception{
        return  service.updateSportiv(id,sportiv);
    }

    @PostMapping("/sportivi")
    public Sportiv saveSportiv(@RequestBody Sportiv sportiv)
    {
        return service.saveSportiv(sportiv);
    }

    @DeleteMapping("/sportivi/{id}")
    public void deleteSportiv(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
