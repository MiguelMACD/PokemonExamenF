package com.pokemon.entities;

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

}
