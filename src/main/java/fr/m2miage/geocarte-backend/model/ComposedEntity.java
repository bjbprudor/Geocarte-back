package fr.ekolis.SpringBootJPA.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ComposedIdEntity")
public class ComposedEntity implements Serializable
{
	
	private static final long serialVersionUID = 2959644193621394587L;

	@EmbeddedId
	private ComposedId id;
    
	private String name;
	
    @Column(name = "created_at")
    private Timestamp createdAt;
       
    public ComposedId getId() 
    {
		return id;
	}

	public void setId(ComposedId id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Timestamp getCreatedAt() 
	{
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) 
	{
		this.createdAt = createdAt;
	}

	public ComposedEntity()
    {
    	
    }
    
    public ComposedEntity(int id, Timestamp dt, String name, Timestamp ct)
    {
    	ComposedId cid = new ComposedId(id,dt);
    	this.id = cid;
    	this.name = name;
    	this.createdAt = ct;
    }
    
    @Override
    public String toString() 
    {
    	return String.format("CE : { id : %s, name : %s , createdAt : %s }", id, name, createdAt);
    }
    
}