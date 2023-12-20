package com.pokemon.controller;

import com.pokemon.entities.Entrenador;
import com.pokemon.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String email) {
        String uuid = entrenadorService.login(email);
        return ResponseEntity.ok(uuid);
    }

    @GetMapping("/{uuid}/pokemons")
    public ResponseEntity<List<Entrenador>> getPokemonsByEntrenador(@PathVariable String uuid) {
        List<Pokemon> pokemons = entrenadorService.getPokemonsByEntrenador(uuid);
        return ResponseEntity.ok(pokemons);
    }

    @PostMapping("/{uuid}/pokemons/{pokemonUuid}")
    public ResponseEntity<?> addPokemonToEntrenador(
            @PathVariable String uuid,
            @PathVariable String pokemonUuid) {
        boolean success = entrenadorService.addPokemonToEntrenador(uuid, pokemonUuid);
        if (success) {
            return ResponseEntity.ok("Pokémon agregado exitosamente");
        } else {
            return ResponseEntity.badRequest().body("El Pokémon ya está registrado al entrenador");
        }
    }
}
