package fr.activite.Repository;

import fr.activite.Entities.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteRepository extends JpaRepository<Activite,Long> {
}
