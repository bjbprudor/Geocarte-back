package fr.ekolis.SpringBootJPA.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ComposedId implements Serializable 
{
	
	private static final long serialVersionUID = -2965331985945746901L;

	@Column(name = "id")
    private int id;
 
    @Column(name = "date")
    private Timestamp date;
 
    public int getIdbalise() 
    {
		return id;
	}

    public void setIdbalise(int id)
    {
    	this.id = id;
    }
    
	public Timestamp getDate() 
	{
		return date;
	}
	
	public void setDate(Timestamp dt)
	{
		this.date = dt;
	}
    
    public ComposedId() 
    {
    }
 
    public ComposedId(int id, Timestamp date) 
    {
        this.id = id;
        this.date = date;
    }

	@Override
    public boolean equals(Object o) 
	{
        if (this == o) return true;
        if (!(o instanceof ComposedId)) return false;
        ComposedId that = (ComposedId) o;
        return Objects.equals(getIdbalise(), that.getDate()) && Objects.equals(getIdbalise(), that.getDate());
    }
 
    @Override
    public int hashCode() 
    {
        return Objects.hash(getIdbalise(), getDate());
    }
    
    @Override
    public String toString() 
    {
    	return String.format("CID : { id : %s, date : %s }", id, date);
    }
}