package com.example.ProiectPao1.controller;

import com.example.ProiectPao1.model.Administrator;
import com.example.ProiectPao1.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService service;

    @GetMapping("/administratori")
    public List<Administrator> getAllAdministratori(){
        return service.getAllAdministratori();
    }

    @GetMapping("/administratori/{id}")
    public Administrator getAdministratorById(@PathVariable Long id)
    {
        return service.getAdministratorById(id);
    }

    @PutMapping("/administratori/{id}")
    public Administrator updateAdministrator(@RequestBody Administrator administrator,@PathVariable Long id) throws Exception{
        return  service.updateAdministrator(id,administrator);
    }

    @PostMapping("/administratori")
    public Administrator saveAdministrator(@RequestBody Administrator administrator)
    {
        return service.saveAdministrator(administrator);
    }

    @DeleteMapping("/administratori/{id}")
    public void deleteAdministrator(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
