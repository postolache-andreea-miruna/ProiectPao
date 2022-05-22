package com.example.ProiectPao1.repository;

import com.example.ProiectPao1.model.Antrenor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntrenorRepository extends JpaRepository<Antrenor,Long> {
    long countAntrenorByClubId(Long id);
}
