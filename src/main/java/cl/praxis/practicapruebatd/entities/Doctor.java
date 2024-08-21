package cl.praxis.practicapruebatd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "doctores")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String run;
    private int experiencia;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
            @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;

    @ManyToMany(mappedBy = "doctores")
    private Set<Paciente> pacientes = new HashSet<>();


}
