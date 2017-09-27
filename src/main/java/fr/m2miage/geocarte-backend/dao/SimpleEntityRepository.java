package fr.ekolis.SpringBootJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ekolis.SpringBootJPA.model.SimpleEntity;

public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Integer>
{
}