package fr.m2miage.geocartebck.controller;

import fr.m2miage.geocartebck.dao.*;
import fr.m2miage.geocartebck.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import fr.m2miage.geocartebck.App;

import javax.rmi.CORBA.Util;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;

@Service
@Configurable
public class ExempleController
{

	private static Logger log = Logger.getLogger(App.class);

    @Autowired
    private AncienNomRepository anr;

    @Autowired
    private CartePostaleRepository cpr;

    @Autowired
    private CarteUtilisateurRepository cur;

    @Autowired
    private CommuneRepository cor;

    @Autowired
    private DepartementRepository der;

    @Autowired
    private EditeurRepository edr;

    @Autowired
    private MonumentRepository mor;

    @Autowired
    private UtilisateurRepository utr;

    @Autowired
    private VarianteCarteRepository vcr;

    @Autowired
    private TypeMonumentRepository tmr;

	public void TestPersist()
	{
    	try
    	{/*
            Utilisateur u = new Utilisateur("user","use@mail.com","pass");
            utr.save(u);
            TypeMonument t = new TypeMonument("chateau");
            tmr.save(t);
            Editeur e = new Editeur("edi1","edi");
            edr.save(e);
            Departement d = new Departement("1","dep");
            der.save(d);
            Commune c = new Commune();
            c.setInsee("10");
            c.setNom("nom");
            c.setDepartement(d);
            cor.save(c);
            AncienNom an = new AncienNom(new AncienNomId(1,c),"","lenom");
            anr.save(an);
            int li = anr.findLastId(c);
            AncienNom an2 = new AncienNom(new AncienNomId(li+1,c),"","noma");
            anr.save(an2);*/
            log.info("done");
    	}
    	catch(Exception e)
    	{
    		log.error(e.toString());
    	}
	}

	public void TestTM()
    {
        log.info("test typeMonument start");
        try
        {
            TypeMonument tm = new TypeMonument("castle");
            TypeMonument tm2 = new TypeMonument("parc");
            tmr.save(tm);
            tmr.save(tm2);
            //tmr.findOne(5);
            tmr.delete(2);
            TypeMonument tm3 = tmr.findOne(1);
            tm3.setLibelle("chateau");
            tmr.save(tm3);
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage());
        }
        log.info("test typeMonument done");
    }
	
}
