package fr.m2miage.geocartebck.controller;

import fr.m2miage.geocartebck.dao.DepartementRepository;
import fr.m2miage.geocartebck.model.Departement;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import fr.m2miage.geocartebck.App;

@Service
@Configurable
public class ExempleController
{

	private static Logger log = Logger.getLogger(App.class);
	
    @Autowired
    private DepartementRepository deRepo;

	public void TestPersist()
	{
    	try
    	{
            Departement de = new Departement(35,"Ille-Et-Villaine");
            deRepo.save(de);
    	}
    	catch(Exception e)
    	{
    		log.error(e.toString());
    	}
	}
	
}
