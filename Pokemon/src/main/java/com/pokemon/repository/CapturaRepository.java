package com.pokemon.repository;

import com.pokemon.entities.Captura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapturaRepository extends JpaRepository<Captura, Integer> {
     
}
