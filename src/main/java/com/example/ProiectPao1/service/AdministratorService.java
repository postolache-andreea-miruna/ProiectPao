package com.example.ProiectPao1.service;

import com.example.ProiectPao1.model.Administrator;
import com.example.ProiectPao1.repository.AdministratorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j //pentru logare
@Service

@RequiredArgsConstructor
public class AdministratorService {
    //@Autowired
    private final AdministratorRepository administratorRepository;

    public Administrator getAdministratorById(Long id){
        log.info("afisare administrator cu id: {}",id);
        return administratorRepository.getById(id);
    }
    public List<Administrator> getAllAdministratori(){
        log.info("afisare toti administratori");
        return administratorRepository.findAll();
    }
    public Administrator saveAdministrator(Administrator administrator)
    {
        log.info("creare administrator cu id: {}",administrator.getId());
        return administratorRepository.save(administrator);
    }
    public Administrator updateAdministrator(Long id, Administrator newAdministrator) throws Exception
    {
        log.info("editare administrator cu id: {}",id);
        Administrator accFromDb = administratorRepository.getById(id);
        if(nonNull(accFromDb)){
            accFromDb.setNume(newAdministrator.getNume());
            accFromDb.setPrenume(newAdministrator.getPrenume());
            accFromDb.setTelefon(newAdministrator.getTelefon());
            accFromDb.setVechime(newAdministrator.getVechime());
            return administratorRepository.save(accFromDb);
        }else
        {
            throw new Exception(String.format("Nu exista administrator cu id-ul dat: %s",id.toString()));
        }
    }

    public void deleteById(Long id){
        log.info("stergere administrator cu id: {}",id);
        administratorRepository.deleteById(id);
    }
}
