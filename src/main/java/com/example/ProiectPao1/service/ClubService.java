package com.example.ProiectPao1.service;

import com.example.ProiectPao1.model.Club;
import com.example.ProiectPao1.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j //pentru logare
@Service
@RequiredArgsConstructor
public class ClubService {
    private final ClubRepository clubRepository;

    public Club getClubById(long id){
        log.info("afisare club cu id: {}",id);
        return clubRepository.getById(id);
    }

    public List<Club> getAllCluburi(){
        log.info("afisarea tuturor cluburilor");
        return clubRepository.findAll();
    }

    public Club saveClub(Club club)
    {
        log.info("creare club cu id: {}",club.getId());
        return clubRepository.save(club);
    }

    public Club updateClub(Long id, Club newClub) throws Exception
    {
        log.info("editare club cu id: {}",id);
        Club accFromDb = clubRepository.getById(id);
        if(nonNull(accFromDb)){
            accFromDb.setNume(newClub.getNume());
            accFromDb.setEmail(newClub.getEmail());
            accFromDb.setNumar_inregistrare(newClub.getNumar_inregistrare());
            accFromDb.setAn_infiintare(newClub.getAn_infiintare());
            return clubRepository.save(accFromDb);
        }else
        {
            throw new Exception(String.format("Nu exista club cu id-ul dat: %s",id.toString()));
        }
    }

    public void deleteById(Long id){
        log.info("stergere club cu id: {}",id);
        clubRepository.deleteById(id);
    }
}
