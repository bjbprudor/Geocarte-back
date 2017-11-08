package fr.m2miage.geocartebck.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "departement")
public class Departement implements Serializable
{

	private static final long serialVersionUID = 2959644193621394587L;

	@Id
	private int id;

    private String name;

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

	public Departement()
    {

    }

    public Departement(int id, String name)
    {
    	this.id = id;
    	this.name = name;
    }
    
    @Override
    public String toString() 
    {
    	return String.format("SE : { id : %s , name : %s }", this.id, this.name);
    }
    
}