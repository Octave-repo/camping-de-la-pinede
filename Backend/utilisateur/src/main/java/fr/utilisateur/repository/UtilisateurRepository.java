package fr.utilisateur.repository;

import fr.utilisateur.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findUtilisateurById(Long id);
    Utilisateur findUtilisateurByMail(String mail);
}

