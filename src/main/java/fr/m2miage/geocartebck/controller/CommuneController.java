package fr.m2miage.geocartebck.controller;

import fr.m2miage.geocartebck.dao.CommuneRepository;
import fr.m2miage.geocartebck.model.Commune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommuneController
{

    @Autowired
    CommuneRepository cre;

    @RequestMapping("/getCommunes")
    public List<Commune> getCommunes()
    {
        return cre.findAll();
    }

    @RequestMapping("/geocarte/c")
    public String getCommuneInsee()
    {
        return "insee";
    }

}
