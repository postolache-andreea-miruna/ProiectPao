package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Sala;
import com.example.ProiectPao1.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SalaController {
    private final SalaService service;

    @GetMapping("/sali")
    public List<Sala> getAllSali(){
        return service.getAllSali();
    }

    @GetMapping("/sali/{id}")
    public Sala getSalaById(@PathVariable Long id)
    {
        return service.getSalaById(id);
    }

    @PutMapping("/sali/{id}")
    public Sala updateSala(@RequestBody Sala sala, @PathVariable Long id) throws Exception{
        return  service.updateSala(id,sala);
    }

    @PostMapping("/sali")
    public Sala saveSala(@RequestBody Sala sala)
    {
        return service.saveSala(sala);
    }

    @DeleteMapping("/sali/{id}")
    public void deleteSala(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
