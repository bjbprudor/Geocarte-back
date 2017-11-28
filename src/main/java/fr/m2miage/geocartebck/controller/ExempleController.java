package fr.m2miage.geocartebck.controller;

import fr.m2miage.geocartebck.dao.*;
import fr.m2miage.geocartebck.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import fr.m2miage.geocartebck.App;

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

	public void TestPersist()
	{
    	try
    	{
    	    Departement d1 = new Departement(35,"Ille-Et-Villaine");
    	    der.save(d1);
    	    Commune c1 = new Commune(35000,"","Rennes",0,0,d1,null);
    	    Commune c2 = new Commune(35420, "","Herg",0,0,d1,null);
    	    Commune c3 = new Commune(35520,"","St-Brice-en-cogles",0,0,d1,c2);
    	    cor.save(c1);
    	    cor.save(c2);
            cor.save(c3);
            AncienNom a1 = new AncienNom(new AncienNomId(c1),"","Rennes-en-bretagne");
            anr.save(a1);
            Editeur e1 = new Editeur("edi1","editeur1");
            ArrayList<Commune> lc = new ArrayList<>();
            lc.add(c1);
            e1.setCommunes(lc);
            Editeur e2 = new Editeur("edi2","editeur2");
            ArrayList<Commune> lc2 = new ArrayList<>();
            lc2.add(c1);
            lc2.add(c2);
            e2.setCommunes(lc2);
            edr.save(e1);
            edr.save(e2);
            Monument m1 = new Monument("m1",1994,"",0,0);
            m1.setCommune(c1);
            Monument m2 = new Monument("m2",1991,"",0,0);
            m2.setCommune(c2);
            mor.save(m1);
            mor.save(m2);
            Utilisateur u1 = new Utilisateur("user","user@mail","pass");
            Utilisateur u2 = new Utilisateur("user2","user2@mail","pass");
            utr.save(u1);
            utr.save(u2);
            CartePostale cp1 = new CartePostale(60,e1);
            cp1.setCommune(c2);
            CartePostale cp2 = new CartePostale(71,e1);
            ArrayList<Monument> lm1 = new ArrayList<>();
            lm1.add(m1);
            lm1.add(m2);
            cp2.setMonuments(lm1);
            CartePostale cp3 = new CartePostale(60,e2);
            ArrayList<Monument> lm2 = new ArrayList<>();
            lm2.add(m2);
            cp3.setMonuments(lm2);
            cpr.save(cp1);
            cpr.save(cp2);
            cpr.save(cp3);
            VarianteCarte vc1 = new VarianteCarte(new VarianteCarteId(cp1),"photo de ville 1","","");
            VarianteCarte vc2 = new VarianteCarte(new VarianteCarteId(cp1),"cliche de ville 1", "","");
            VarianteCarte vc3 = new VarianteCarte(new VarianteCarteId(cp2),"Le monument 1 et 2","","");
            VarianteCarte vc4 = new VarianteCarte(new VarianteCarteId(cp3),"Le monument 2","","");
            vcr.save(vc1);
            vcr.save(vc2);
            vcr.save(vc3);
            vcr.save(vc4);
            CarteUtilisateur cu1 = new CarteUtilisateur(new CarteUtilisateurId(vc1,u1),1);
            CarteUtilisateur cu2 = new CarteUtilisateur(new CarteUtilisateurId(vc2,u1),2);
            CarteUtilisateur cu3 = new CarteUtilisateur(new CarteUtilisateurId(vc1,u2),40);
            cur.save(cu1);
            cur.save(cu2);
            cur.save(cu3);
            log.info("done");
    	}
    	catch(Exception e)
    	{
    		log.error(e.toString());
    	}
	}
	
}
