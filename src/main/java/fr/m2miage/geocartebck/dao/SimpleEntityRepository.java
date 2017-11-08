package fr.m2miage.geocartebck.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2miage.geocartebck.model.SimpleEntity;

public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Integer>
{
}