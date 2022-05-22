package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Club;
import com.example.ProiectPao1.model.Rezultat;
import com.example.ProiectPao1.service.ClubService;
import com.example.ProiectPao1.service.RezultatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RezultatController {
    private final RezultatService service;

    @GetMapping("/rezultate")
    public List<Rezultat> getAllRezultate(){
        return service.getAllRezultate();
    }

    @GetMapping("/rezultate/{id}")
    public Rezultat getRezultatById(@PathVariable Long id)
    {
        return service.getRezultatById(id);
    }

    @PutMapping("/rezultate/{id}")
    public Rezultat updateRezultat(@RequestBody Rezultat rezultat, @PathVariable Long id) throws Exception{
        return  service.updateRezultat(id,rezultat);
    }
    @PostMapping("/rezultate")
    public Rezultat saveRezultat(@RequestBody Rezultat rezultat)
    {
        return service.saveRezultat(rezultat);
    }

    @DeleteMapping("/rezultate/{id}")
    public void deleteRezultat(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
