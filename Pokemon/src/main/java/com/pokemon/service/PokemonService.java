package com.pokemon.service;

import com.pokemon.entities.Pokemon;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> listarPokemonesPorTipo(String tipoUuid) {
        
        return pokemonRepository.findByTipoPokemonUuid(tipoUuid);
    }

    public Pokemon registrarPokemon(Pokemon pokemon) {
        
        return pokemonRepository.save(pokemon);
    }
}
