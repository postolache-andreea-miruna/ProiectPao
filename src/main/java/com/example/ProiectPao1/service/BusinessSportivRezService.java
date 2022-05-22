package com.example.ProiectPao1.service;

import com.example.ProiectPao1.model.Rezultat;
import com.example.ProiectPao1.model.Sportiv;
import com.example.ProiectPao1.model.SportivDto;
import com.example.ProiectPao1.model.SportivLotDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class BusinessSportivRezService {
    private final SportivService sportivService;
    private final RezultatService rezultatService;

    public List<Rezultat> getAllRezultateForSportiv(Long id){
        log.info("afisarea tuturor rezultatelor obtinute de sportiv cu id : {}",id);
        List<Rezultat> rezultate = new ArrayList<>();
        rezultatService.getAllRezultate().forEach(rezultat -> {
            if(rezultat.getSportivId()==id)
                rezultate.add(rezultat);
        });
        return rezultate;
    }

    public Map<Long,List<Rezultat>> getSportiviSiRez(){
        log.info("afisarea pentru fiecare id de legitimatie sportiv in parte sportivii");
        Map<Long,List<Rezultat>> map = new HashMap<>();
        sportivService.getAllSportivi().forEach(sportiv -> {
            if(map.containsKey(sportiv.getId()) ){
                List<Rezultat> rezultate = map.get(sportiv.getId());
                rezultatService.getAllRezultate().forEach(rezultat -> {
                    if(rezultat.getSportivId() == sportiv.getId() )
                        rezultate.add(rezultat);
                });
            }
            else {
                List<Rezultat> rezultate = new ArrayList<>();
                rezultatService.getAllRezultate().forEach(rezultat -> {
                    if(rezultat.getSportivId() == sportiv.getId() )
                        rezultate.add(rezultat);
                });
                map.put(sportiv.getId(),rezultate);
            }
        });
        return map;
    }

}
