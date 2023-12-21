package com.pokemon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private Integer tipoPokemon;
    private Date fechaDescubrimiento;
    private Integer generacion;
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "tipo_pokemon")
    private TipoPokemon tipoPokemonEntity;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
