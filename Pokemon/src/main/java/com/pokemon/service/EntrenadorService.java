package com.pokemon.service;

import com.pokemon.entities.Entrenador;
import com.pokemon.entities.Pokemon;
import com.pokemon.repository.EntrenadorRepository;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public EntrenadorService(EntrenadorRepository entrenadorRepository, PokemonRepository pokemonRepository) {
        this.entrenadorRepository = entrenadorRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public String login(String email) {
        Entrenador entrenador = entrenadorRepository.findByEmail(email);
        if (entrenador != null) {
            return entrenador.getUuid();
        }
        return null;
    }

    public List<Pokemon> getPokemonsByEntrenador(String entrenadorUuid) {
        return pokemonRepository.findByEntrenadorUuid(entrenadorUuid);
    }

    public boolean addPokemonToEntrenador(String entrenadorUuid, String pokemonUuid) {
        Entrenador entrenador = entrenadorRepository.findByUuid(entrenadorUuid);
        Pokemon pokemon = pokemonRepository.findByUuid(pokemonUuid);

        if (entrenador != null && pokemon != null) {
            List<Pokemon> pokemons = entrenador.getPokemons();
            if (!pokemons.contains(pokemon)) {
                pokemons.add(pokemon);
                entrenador.setPokemons(pokemons);
                entrenadorRepository.save(entrenador);
                return true;
            }
        }
        return false;
    }
}
