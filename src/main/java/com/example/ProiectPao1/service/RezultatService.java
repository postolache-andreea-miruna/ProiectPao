package com.example.ProiectPao1.service;

import com.example.ProiectPao1.model.Club;
import com.example.ProiectPao1.model.Rezultat;
import com.example.ProiectPao1.repository.ClubRepository;
import com.example.ProiectPao1.repository.RezultateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class RezultatService {
    private final RezultateRepository repository;

    public Rezultat getRezultatById(long id){
        log.info("afisare rezultat cu id: {}",id);
        return repository.getById(id);
    }

    public List<Rezultat> getAllRezultate(){
        log.info("afisarea tuturor rezultatelor");
        return repository.findAll();
    }

    public Rezultat saveRezultat(Rezultat rezultat)
    {
        log.info("creare rezultat cu id: {}",rezultat.getId());
        return repository.save(rezultat);
    }

    public Rezultat updateRezultat(Long id, Rezultat newRezultat) throws Exception
    {
        log.info("editare rezultat cu id: {}",id);
        Rezultat accFromDb = repository.getById(id);
        if(nonNull(accFromDb)){
            accFromDb.setNume_competitie(newRezultat.getNume_competitie());
            accFromDb.setNume_proba(newRezultat.getNume_proba());
            accFromDb.setTimp(newRezultat.getTimp());
            accFromDb.setZi_rez(newRezultat.getZi_rez());
            accFromDb.setLuna_rez(newRezultat.getLuna_rez());
            accFromDb.setAn_rez(newRezultat.getAn_rez());

            return repository.save(accFromDb);
        }else
        {
            throw new Exception(String.format("Nu exista rezultatul cu id-ul dat: %s",id.toString()));
        }
    }

    public void deleteById(Long id){
        log.info("stergere rezultat cu id: {}",id);
        repository.deleteById(id);
    }
}
