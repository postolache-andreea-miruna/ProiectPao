package com.example.ProiectPao1.service;

import com.example.ProiectPao1.model.Antrenor;
import com.example.ProiectPao1.model.Sportiv;
import com.example.ProiectPao1.model.SportivDto;
import com.example.ProiectPao1.model.SportivLotDto;
import com.example.ProiectPao1.repository.SportivRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class SportivService {
    private final SportivRepository sportivRepository;

    public SportivDto getSportivDtoById(long id){
        log.info("afisare sportiv simplu cu id: {}",id);
        Sportiv sportiv1 =  sportivRepository.getById(id);
        SportivDto sportivDto = new SportivDto();
        sportivDto.setId(id);
        sportivDto.setCnp(sportiv1.getCnp());
        sportivDto.setNume(sportiv1.getNume());
        sportivDto.setPrenume(sportiv1.getPrenume());
        sportivDto.setAn_nastere(sportiv1.getAn_nastere());
        sportivDto.setGen(sportiv1.getGen());
        sportivDto.setCategorie(sportiv1.getCategorie());
        sportivDto.setAntrenorId(sportiv1.getAntrenorId());

        return sportivDto;
    }

    public SportivLotDto getSportivLotDtoById(long id){
        log.info("afisare sportiv lot cu id: {}",id);
        Sportiv sportiv1 = sportivRepository.getById(id);
        return SportivLotDto.builder().
                id(id).
                cnp(sportiv1.getCnp()).
                nume(sportiv1.getNume()).
                prenume(sportiv1.getPrenume()).
                an_nastere(sportiv1.getAn_nastere()).
                gen(sportiv1.getGen()).
                categorie(sportiv1.getCategorie()).
                indemnizatie(sportiv1.getIndemnizatie()).
                nr_ani_lot(sportiv1.getNr_ani_lot()).
                antrenorId(sportiv1.getAntrenorId()).
                build();
    }


    public List<Sportiv> getAllSportivi(){
        log.info("afisarea tuturor sportivilot");
        return sportivRepository.findAll();
    }

    public Sportiv saveSportiv(Sportiv sportiv)
    {
        log.info("creare sportiv cu id: {}",sportiv.getId());
        return sportivRepository.save(sportiv);
    }

    public Sportiv updateSportiv(Long id, Sportiv newSportiv) throws Exception
    {
        log.info("editare sportiv cu id: {}",id);
        Sportiv accFromDb = sportivRepository.getById(id);
        if(nonNull(accFromDb)){
            accFromDb.setCnp(newSportiv.getCnp());
            accFromDb.setNume(newSportiv.getNume());
            accFromDb.setPrenume(newSportiv.getPrenume());
            accFromDb.setAn_nastere(newSportiv.getAn_nastere());
            accFromDb.setGen(newSportiv.getGen());
            accFromDb.setCategorie(newSportiv.getCategorie());
            accFromDb.setIndemnizatie(newSportiv.getIndemnizatie());
            accFromDb.setNr_ani_lot(newSportiv.getNr_ani_lot());

            return sportivRepository.save(accFromDb);
        }else
        {
            throw new Exception(String.format("Nu exista sportiv cu id-ul dat: %s",id.toString()));
        }
    }

    public void deleteById(Long id){
        log.info("stergerea sportivului cu id: {}",id);
        sportivRepository.deleteById(id);
    }
}
