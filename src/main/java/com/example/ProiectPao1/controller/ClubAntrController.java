package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class ClubAntrController {
    private final BusinessService service;
    @GetMapping("/nrantr/{id}")
    public long getNrAntrenoriByClubId(@PathVariable Long id){
        return service.getNrAntrenoriByClubId(id);
    }

    @GetMapping("/antrclub")
    public Map<String, Set<Antrenor>> getCluburiAntrenori(){
        return service.getCluburiAntrenori();
    }
}
