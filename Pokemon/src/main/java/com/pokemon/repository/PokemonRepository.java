package com.pokemon.repository;

import com.pokemon.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    List<Pokemon> findByTipoPokemonUuid(String tipoUuid);
    
    List<Pokemon> findByEntrenadorUuid(String entrenadorUuid);

    Pokemon findByUuid(String pokemonUuid);
}
