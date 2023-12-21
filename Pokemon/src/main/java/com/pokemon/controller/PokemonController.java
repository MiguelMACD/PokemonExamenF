package com.pokemon.controller;

import com.pokemon.entities.Pokemon;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{tipo}")
    public ResponseEntity<List<Pokemon>> getPokemonsByTipo(@PathVariable String tipo) {
        List<Pokemon> pokemons = pokemonService.listarPokemonesPorTipo(tipo);
        return ResponseEntity.ok(pokemons);
    }

    @PostMapping
    public ResponseEntity<Pokemon> registerPokemon(@RequestBody Pokemon pokemon) {
        Pokemon registeredPokemon = pokemonService.registrarPokemon(pokemon);
        return ResponseEntity.ok(registeredPokemon);
    }
}
