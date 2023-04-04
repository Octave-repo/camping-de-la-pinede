package fr.camping.repository;

import fr.camping.entity.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisRepository extends JpaRepository<Avis,Integer> {
    List<Avis> findByCamping (long id);
}
