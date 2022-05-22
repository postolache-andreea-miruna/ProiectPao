package com.example.ProiectPao1.repository;

import com.example.ProiectPao1.model.TipSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipSportRepository extends JpaRepository<TipSport,Long> {
}
