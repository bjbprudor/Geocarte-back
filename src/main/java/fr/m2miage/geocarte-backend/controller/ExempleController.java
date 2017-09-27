package fr.ekolis.SpringBootJPA.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import fr.ekolis.SpringBootJPA.App;
import fr.ekolis.SpringBootJPA.dao.ComposedEntityRepository;
import fr.ekolis.SpringBootJPA.dao.SimpleEntityRepository;
import fr.ekolis.SpringBootJPA.model.ComposedEntity;
import fr.ekolis.SpringBootJPA.model.SimpleEntity;

@Service
@Configurable
public class ExempleController 
{

	private static Logger log = Logger.getLogger(App.class);
	
    @Autowired
    private SimpleEntityRepository seRepo;
	
    @Autowired
    private ComposedEntityRepository ceRepo;
    
	public void TestPersist()
	{
    	try
    	{
    		Date d = new Date();
    		Timestamp t = new Timestamp(d.getTime());
    		SimpleEntity se = new SimpleEntity(1, "simple", t);
    		ComposedEntity ce = new ComposedEntity(2, t, "composed", t);
    		
    		seRepo.save(se);
    		ceRepo.save(ce);
    		
    		SimpleEntity se2;
    		ComposedEntity ce2;
    		
    		se2 = seRepo.findOne(se.getId());
    		ce2 = ceRepo.findOne(ce.getId());
    		
    		if(se2 != null)
    		{
    			log.info(se2.toString() + " found in the database");
    		}
    		else
    		{
    			log.info("Nothing was found in the database");
    		}
    		
    		if(ce2 != null)
    		{
    			log.info(ce2.toString() + " found in the database");
    		}
    		else
    		{
    			log.info("Nothing was found in the database");
    		}
    		
    	}
    	catch(Exception e)
    	{
    		log.error(e.toString());
    	}
	}
	
}
