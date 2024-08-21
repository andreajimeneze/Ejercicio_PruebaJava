package cl.praxis.practicapruebatd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float monto;
    private LocalDate fechaPago;

    @OneToOne
    @JoinColumn(name = "factura_id")
    private Cita cita;
}
