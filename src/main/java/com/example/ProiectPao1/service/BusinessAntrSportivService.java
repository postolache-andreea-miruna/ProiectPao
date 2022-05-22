package com.example.ProiectPao1.service;

import com.example.ProiectPao1.comparators.AntrenorComparator;
import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.model.Sportiv;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class BusinessAntrSportivService {
    private final AntrenorService antrenorService;
    private final SportivService sportivService;

    public List<Sportiv> getAllSportiviForAntrenor(Long id){
        log.info("afisarea sportivilor antrenati de antrenorul cu id: {}",id);
        List<Sportiv> sportivi = new ArrayList<>();
        sportivService.getAllSportivi().forEach(sportiv -> {
            if(sportiv.getAntrenorId() == id)
                sportivi.add(sportiv);
        });
        return sportivi;
    }

    public Map<String, Set<Sportiv>> getAntrenoriSportivi(){
        log.info("afisarea pentru fiecare antrenor in parte a sportivilor");
        final HashMap<String,Set<Sportiv>> map= new HashMap<>();
        antrenorService.getAllAntrenori().forEach(antrenor -> {
            if(map.containsKey(antrenor.getEmail())){
                Set<Sportiv> sportivi = map.get(antrenor.getEmail());

                sportivService.getAllSportivi().forEach(sportiv -> {
                    if(sportiv.getAntrenorId()==antrenor.getId())
                        sportivi.add(sportiv);
                });

            }else{
                Set<Sportiv> sportivi = new HashSet<>();
                sportivService.getAllSportivi().forEach(sportiv -> {
                            if (sportiv.getAntrenorId() == antrenor.getId())
                                sportivi.add(sportiv);
                });
                map.put(antrenor.getEmail(),sportivi);
            }
        });
        return map;
    }


}
