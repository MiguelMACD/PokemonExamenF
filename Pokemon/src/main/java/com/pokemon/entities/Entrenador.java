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
@Entity(name = "entrenador")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Date fechaVinculacion;

    // Relación con la tabla pokemon.pueblo
    @ManyToOne
    @JoinColumn(name = "pueblo_id")
    private Pueblo pueblo;

    private String email;
    private String uuid;
}
