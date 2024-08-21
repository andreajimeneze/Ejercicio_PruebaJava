package cl.praxis.practicapruebatd.repositories;

import cl.praxis.practicapruebatd.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
    @Modifying
    @Query(value = "UPDATE citas SET doctor_id = NULL WHERE doctor_id = :doctorId", nativeQuery = true)
    void setDoctorToNull(@Param("doctorId") int doctorId);

}
