package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, Integer>
{
}