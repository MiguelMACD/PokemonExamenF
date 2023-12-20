package com.pokemon.repository;

import com.pokemon.entities.TipoPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPokemonRepository extends JpaRepository<TipoPokemon, Integer> {
    // Puedes agregar métodos de consulta personalizados si es necesario
}

