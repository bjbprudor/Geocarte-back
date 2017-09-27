package fr.ekolis.SpringBootJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ekolis.SpringBootJPA.model.ComposedEntity;
import fr.ekolis.SpringBootJPA.model.ComposedId;

public interface ComposedEntityRepository extends JpaRepository<ComposedEntity, ComposedId>
{
}