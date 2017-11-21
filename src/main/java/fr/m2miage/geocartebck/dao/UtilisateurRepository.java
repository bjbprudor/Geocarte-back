package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>
{
}