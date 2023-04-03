package fr.camping.repository;

import fr.camping.entity.Camping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampingRepository extends JpaRepository<Camping, Integer> {
    List<Camping>findByNom(String nom);
}
