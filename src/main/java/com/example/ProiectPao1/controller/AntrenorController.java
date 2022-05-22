package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.model.AntrenorDto;
import com.example.ProiectPao1.model.AntrenorOlimpicDto;
import com.example.ProiectPao1.model.Club;
import com.example.ProiectPao1.service.AntrenorService;
import com.example.ProiectPao1.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AntrenorController {
    private final AntrenorService service;

    @GetMapping("/antrenori")
    public List<Antrenor> getAllAntrenori(){
        return service.getAllAntrenori();
    }

    @GetMapping("/antrenori/{id}")
    public AntrenorDto getAntrenorDtoById(@PathVariable Long id)
    {
        return service.getAntrenorDtoById(id);
    }
    @GetMapping("/antrenori/ol/{id}")
    public AntrenorOlimpicDto getAntrenorOlimpicDtoById(@PathVariable Long id)
    {
        return service.getAntrenorOlimpicDtoById(id);
    }

    @PutMapping("/antrenori/{id}")
    public Antrenor updateAntrenor(@RequestBody Antrenor antrenor, @PathVariable Long id) throws Exception{
        return  service.updateAntrenor(id,antrenor);
    }

    @PostMapping("/antrenori")
    public Antrenor saveAntrenor(@RequestBody Antrenor antrenor)
    {
        return service.saveAntrenor(antrenor);
    }

    @DeleteMapping("/antrenori/{id}")
    public void deleteAntrenor(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
