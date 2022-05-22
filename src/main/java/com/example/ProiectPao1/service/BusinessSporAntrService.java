package com.example.ProiectPao1.service;

import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.model.Sala;
import com.example.ProiectPao1.model.Sportiv;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class BusinessSporAntrService {
    private final TipSportService tipSportService;
    private final AntrenorService antrenorService;
    private final SalaService salaService;

    public Map<String, Set<Antrenor>> getAntrenoriForTipSport(){
        log.info("afisarea pentru fiecare tip de sport in parte antrenorii");
        final HashMap<String,Set<Antrenor>> map = new HashMap<>();
        tipSportService.getAllTipSporturi().forEach(tipSport -> {
            if(map.containsKey(tipSport.getNume())){
                Set<Antrenor> antrenori = map.get(tipSport.getNume());
                antrenorService.getAllAntrenori().forEach(antrenor -> {
                    if(antrenor.getTipsportId() == tipSport.getId())
                        antrenori.add(antrenor);
                });
            }
            else{
                Set<Antrenor> antrenori = new HashSet<>();
                antrenorService.getAllAntrenori().forEach(antrenor -> {
                    if (antrenor.getTipsportId() == tipSport.getId())
                        antrenori.add(antrenor);
                });
                map.put(tipSport.getNume(),antrenori);
            }
        });
        return map;
    }


    public Map<String, Set<Sala>> getSaliForTipSport(){
        log.info("afisarea pentru fiecare tip de sport in parte a salilor");
        final HashMap<String,Set<Sala>> map = new HashMap<>();
        tipSportService.getAllTipSporturi().forEach(tipSport -> {
            if(map.containsKey(tipSport.getNume())){
                Set<Sala> sali = map.get(tipSport.getNume());
                salaService.getAllSali().forEach(sala -> {
                    if(sala.getTipsportId() == tipSport.getId())
                        sali.add(sala);
                });
            }
            else{
                Set<Sala> sali = new HashSet<>();
                salaService.getAllSali().forEach(sala -> {
                    if (sala.getTipsportId() == tipSport.getId())
                        sali.add(sala);
                });
                map.put(tipSport.getNume(),sali);
            }
        });
        return map;

    }


}
