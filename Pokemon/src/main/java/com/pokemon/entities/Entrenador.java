package com.pokemon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "entrenador")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Date fechaVinculacion;

    @ManyToOne
    @JoinColumn(name = "pueblo_id")
    private Pueblo pueblo;

    private String email;
    private String uuid;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    private List<Pokemon> pokemons = new ArrayList<>();

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        pokemon.setEntrenador(this);
    }
}
