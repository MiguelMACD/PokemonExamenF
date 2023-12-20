package com.pokemon.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // Relación con la tabla pokemon.tipo_pokemon
    @ManyToOne
    @JoinColumn(name = "tipo_pokemon")
    private TipoPokemon tipoPokemonEntity;
}
