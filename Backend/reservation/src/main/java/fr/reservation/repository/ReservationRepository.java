package fr.reservation.repository;

import fr.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUtilisateur(long id);
    List<Reservation> findByCamping(long id);
}
