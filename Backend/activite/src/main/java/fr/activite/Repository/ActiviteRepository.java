package fr.activite.Repository;

import fr.activite.Entities.Activite;
import fr.activite.Entities.GPSLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite,Long> {

    List<Activite> findAll();
}
