package com.pokemon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "captura")
public class Captura {

	   @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	   // Relación con la tabla pokemon.pokemon
	   @ManyToOne
	   @JoinColumn(name = "pokemon_id")
	   private Pokemon pokemon;

	   // Relación con la tabla pokemon.entrenador
	   @ManyToOne
	   @JoinColumn(name = "entrenador_id")
	   private Entrenador entrenador;

}
