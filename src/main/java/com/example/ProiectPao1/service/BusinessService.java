package com.example.ProiectPao1.service;

import com.example.ProiectPao1.comparators.AntrenorComparator;
import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.model.Club;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class BusinessService {
    private final ClubService clubService;
    private final AntrenorService antrenorService;

    public long getNrAntrenoriByClubId(Long clubId){
        log.info("afisarea numar de antrenori pentru clubul cu id: {}",clubId);
        return  antrenorService.getAllAntrenori().stream()
                .filter(antr -> antr.getClubId() == clubId).count();
    }

    public Map<String, Set<Antrenor>> getCluburiAntrenori(){
        log.info("afisarea pentru fiecare club in parte antrenorii");
        final HashMap<String,Set<Antrenor>> map= new HashMap<>();
        clubService.getAllCluburi().forEach(club -> {
            if(map.containsKey(club.getNume())){
                Set<Antrenor> antrenori = map.get(club.getNume());

                antrenorService.getAllAntrenori().forEach(antrenor -> {
                    if(antrenor.getClubId()==club.getId())
                        antrenori.add(antrenor);
                });
                AntrenorComparator comparator = new AntrenorComparator();
                antrenori.stream().sorted(comparator);
            }else{
                Set<Antrenor>antrenori = new HashSet<>();
                antrenorService.getAllAntrenori().forEach(antrenor -> {
                    if(antrenor.getClubId()==club.getId())
                        antrenori.add(antrenor);
                });
                map.put(club.getNume(),antrenori);
            }
        });
        return map;
    }
}
