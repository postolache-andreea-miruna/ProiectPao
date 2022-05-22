package com.example.ProiectPao1.repository;

import com.example.ProiectPao1.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdministratorRepository extends JpaRepository<Administrator,Long>
{

}
