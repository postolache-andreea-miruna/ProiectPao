package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Club;
import com.example.ProiectPao1.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ClubController {
    private final ClubService service;

    @GetMapping("/cluburi")
    public List<Club> getAllCluburi(){
        return service.getAllCluburi();
    }

    @GetMapping("/cluburi/{id}")
    public Club getClubById(@PathVariable Long id)
    {
        return service.getClubById(id);
    }

    @PutMapping("/cluburi/{id}")
    public Club updateClub(@RequestBody Club club, @PathVariable Long id) throws Exception{
        return  service.updateClub(id,club);
    }

    @PostMapping("/cluburi")
    public Club saveClub(@RequestBody Club club)
    {
        return service.saveClub(club);
    }

    @DeleteMapping("/cluburi/{id}")
    public void deleteClub(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
