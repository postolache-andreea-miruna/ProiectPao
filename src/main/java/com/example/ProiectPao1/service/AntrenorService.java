package com.example.ProiectPao1.service;

import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.model.AntrenorDto;
import com.example.ProiectPao1.model.AntrenorOlimpicDto;
import com.example.ProiectPao1.model.Sportiv;
import com.example.ProiectPao1.repository.AntrenorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class AntrenorService {
    private final AntrenorRepository antrenorRepository;

    public AntrenorDto getAntrenorDtoById(long id){ //AntrenorDto      aici se modifica
        log.info("afisare antrenor simplu cu id: {}",id);

        Antrenor antrenor1 = antrenorRepository.getById(id);
        AntrenorDto antrenorDto = new AntrenorDto();
        antrenorDto.setId(id);
        antrenorDto.setNume(antrenor1.getNume());
        antrenorDto.setPrenume(antrenor1.getPrenume());
        antrenorDto.setEmail(antrenor1.getEmail());
        antrenorDto.setAni_experienta(antrenor1.getAni_experienta());
        antrenorDto.setEste_acreditat(antrenor1.getEste_acreditat());
        antrenorDto.setNr_sportivi_act(antrenor1.getNr_sportivi_act());
        antrenorDto.setSalariu(antrenor1.getSalariu());
        antrenorDto.setClubId(antrenor1.getClubId());
        antrenorDto.setTipsportId(antrenor1.getTipsportId());
        //toate campuri
        return antrenorDto;
    }

    public AntrenorOlimpicDto getAntrenorOlimpicDtoById(long id){
        log.info("afisare antrenor olimpic cu id: {}",id);

        Antrenor antrenor1 = antrenorRepository.getById(id);
        return AntrenorOlimpicDto.builder().id(id).
                nume(antrenor1.getNume()).
                prenume(antrenor1.getPrenume()).
                email(antrenor1.getEmail()).
                ani_experienta(antrenor1.getAni_experienta()).
                este_acreditat(antrenor1.getEste_acreditat()).
                nr_sportivi_act(antrenor1.getNr_sportivi_act()).
                salariu(antrenor1.getSalariu()).
                bonus(antrenor1.getBonus()).
                nr_ani_olimp_rez(antrenor1.getNr_ani_olimp_rez()).
                clubId(antrenor1.getClubId()).
                tipsportId(antrenor1.getTipsportId()).build();//toate campurile
    }

    public List<Antrenor> getAllAntrenori(){
        log.info("afisarea tuturor antrenorilor");
        return antrenorRepository.findAll();
    }

    public Antrenor saveAntrenor(Antrenor antrenor)
    {
        log.info("creare antrenor");
        return antrenorRepository.save(antrenor);
    }

    public Antrenor updateAntrenor(Long id, Antrenor newAntrenor) throws Exception
    {
        log.info("editare antrenor cu id: {}",id);
        Antrenor accFromDb = antrenorRepository.getById(id);
        if(nonNull(accFromDb)){
            accFromDb.setNume(newAntrenor.getNume());
            accFromDb.setPrenume(newAntrenor.getPrenume());
            accFromDb.setEmail(newAntrenor.getEmail());
            accFromDb.setAni_experienta(newAntrenor.getAni_experienta());
            accFromDb.setEste_acreditat(newAntrenor.getEste_acreditat());
            accFromDb.setNr_sportivi_act(newAntrenor.getNr_sportivi_act());
            accFromDb.setSalariu(newAntrenor.getSalariu());
            accFromDb.setBonus(newAntrenor.getBonus());
            accFromDb.setNr_ani_olimp_rez(newAntrenor.getNr_ani_olimp_rez());
            return antrenorRepository.save(accFromDb);
        }else
        {
            throw new Exception(String.format("Nu exista antrenor cu id-ul dat: %s",id.toString()));
        }
    }

    public void deleteById(Long id){
        log.info("stergerea antrenorului cu id: {}",id);
        antrenorRepository.deleteById(id);
    }

    public long getTotalNumberOfAntrenoriByClubId(Long clubId){
        return antrenorRepository.countAntrenorByClubId(clubId);
    }

}
