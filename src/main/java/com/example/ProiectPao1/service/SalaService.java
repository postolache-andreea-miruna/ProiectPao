package com.example.ProiectPao1.service;

import com.example.ProiectPao1.model.Club;
import com.example.ProiectPao1.model.Sala;
import com.example.ProiectPao1.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class SalaService {
    private final SalaRepository salaRepository;

    public Sala getSalaById(long id){
        log.info("afisare sala cu id: {}",id);
        return salaRepository.getById(id);
    }

    public List<Sala> getAllSali(){
        log.info("afisarea tuturor salilor");
        return salaRepository.findAll();
    }

    public Sala saveSala(Sala sala)
    {
        log.info("creare sala cu id: {}",sala.getId());
        return salaRepository.save(sala);
    }

    public Sala updateSala(Long id, Sala newSala) throws Exception
    {
        log.info("editare sala cu id: {}",id);
        Sala accFromDb = salaRepository.getById(id);
        if(nonNull(accFromDb)){
            accFromDb.setNume(newSala.getNume());
            accFromDb.setLocatie(newSala.getLocatie());
            accFromDb.setEvaluare(newSala.getEvaluare());
            accFromDb.setLungime_zona_sport(newSala.getLungime_zona_sport());
            accFromDb.setLatime_zona_sport(newSala.getLatime_zona_sport());
            accFromDb.setLungime_sala(newSala.getLungime_sala());
            accFromDb.setInaltime_sala(newSala.getInaltime_sala());
            accFromDb.setRenovat(newSala.getRenovat());
            return salaRepository.save(accFromDb);
        }else
        {
            throw new Exception(String.format("Nu exista sala cu id-ul dat: %s",id.toString()));
        }
    }

    public void deleteById(Long id){
        log.info("stergere sala cu id: {}",id);
        salaRepository.deleteById(id);
    }
}
