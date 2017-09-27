package fr.ekolis.SpringBootJPA.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SimpleIdEntity")
public class SimpleEntity implements Serializable
{
	
	private static final long serialVersionUID = 2959644193621394587L;

	@Id
	private int id;
    
    private String name;
    
    @Column(name = "created_at")
    private Timestamp createdAt; 
    
    public int getId() 
    {
		return id;
	}

	public void setId(int id) 
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

	public SimpleEntity()
    {
    	
    }
    
    public SimpleEntity(int id, String name, Timestamp ct)
    {
    	this.id = id;
    	this.name = name;
    	this.createdAt = ct;
    }
    
    @Override
    public String toString() 
    {
    	return String.format("SE : { id : %s , name : %s , createdAt : %s }", this.id, this.name, this.createdAt);
    }
    
}