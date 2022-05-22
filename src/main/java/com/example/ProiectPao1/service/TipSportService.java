package com.example.ProiectPao1.service;


import com.example.ProiectPao1.model.TipSport;
import com.example.ProiectPao1.repository.TipSportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class TipSportService {

    private final TipSportRepository tipSportRepository;

    public TipSport getTipSportById(long id){
        log.info("afisare tip sport cu id: {}",id);
        return tipSportRepository.getById(id);
    }

    public List<TipSport> getAllTipSporturi(){
        log.info("afisarea tuturor sporturilor");
        return tipSportRepository.findAll();
    }

    public TipSport saveTipSport(TipSport tipSport)
    {
        log.info("creare tip sport cu id: {}",tipSport.getId());
        return tipSportRepository.save(tipSport);
    }

    public TipSport updateTipSport(Long id, TipSport newTipSport) throws Exception
    {
        log.info("editare tip sport cu id: {}",id);
        TipSport accFromDb = tipSportRepository.getById(id);
        if(nonNull(accFromDb)){
            accFromDb.setNume(newTipSport.getNume());
            accFromDb.setEchipa(newTipSport.getEchipa());
            accFromDb.setDificultate(newTipSport.getDificultate());
            return tipSportRepository.save(accFromDb);
        }else
        {
            throw new Exception(String.format("Nu exista tip sport cu id-ul dat: %s",id.toString()));
        }
    }

    public void deleteById(Long id){
        log.info("stergere tip sport cu id: {}",id);
        tipSportRepository.deleteById(id);
    }
}
