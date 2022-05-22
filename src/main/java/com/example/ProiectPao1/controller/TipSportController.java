package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.TipSport;
import com.example.ProiectPao1.service.TipSportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TipSportController {
    private final TipSportService service;

    @GetMapping("/tipsporturi")
    public List<TipSport> getAllTipSporturi(){
        return service.getAllTipSporturi();
    }

    @GetMapping("/tipsporturi/{id}")
    public TipSport getTipSportById(@PathVariable Long id)
    {
        return service.getTipSportById(id);
    }

    @PutMapping("/tipsporturi/{id}")
    public TipSport updateTipSport(@RequestBody TipSport tipSport, @PathVariable Long id) throws Exception{
        return  service.updateTipSport(id,tipSport);
    }

    @PostMapping("/tipsporturi")
    public TipSport saveTipSport(@RequestBody TipSport tipSport)
    {
        return service.saveTipSport(tipSport);
    }

    @DeleteMapping("/tipsporturi/{id}")
    public void deleteTipSport(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
