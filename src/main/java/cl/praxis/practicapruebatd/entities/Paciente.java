package cl.praxis.practicapruebatd.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private LocalDate fechaNacimiento;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "citas",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private Set<Doctor> doctores;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "historia_clinica",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
   private Set<Doctor> doctorSet;
}
