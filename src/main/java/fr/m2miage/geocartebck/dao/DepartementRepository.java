package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, String>
{
}