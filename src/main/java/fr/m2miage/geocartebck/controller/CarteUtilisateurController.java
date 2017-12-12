package fr.m2miage.geocartebck.controller;

import fr.m2miage.geocartebck.CustomErrorType;
import fr.m2miage.geocartebck.dao.CarteUtilisateurRepository;
import fr.m2miage.geocartebck.model.CarteUtilisateur;
import fr.m2miage.geocartebck.model.CarteUtilisateurId;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CarteUtilisateurController
{

    public static final Logger log = Logger.getLogger(CarteUtilisateurController.class);

    @Autowired
    private CarteUtilisateurRepository repo;


    // -------------------Recupere tous les CarteUtilisateurs---------------------------------------------

    @RequestMapping(value = "/cu/", method = RequestMethod.GET)
    public ResponseEntity<List<CarteUtilisateur>> listAllCarteUtilisateur()
    {
        List<CarteUtilisateur> list = repo.findAll();
        if (list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // -------------------Recupere un CarteUtilisateur------------------------------------------

    @RequestMapping(value = "/cu/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCarteUtilisateur(@PathVariable("id") CarteUtilisateurId id)
    {
        String msg = String.format("Fetching CarteUtilisateur with id {%s}", id);
        log.info(msg);
        CarteUtilisateur current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("CarteUtilisateur with id {%s} not found.", id);
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CarteUtilisateur>(current, HttpStatus.OK);
    }

    // -------------------Create a CarteUtilisateur-------------------------------------------

    @RequestMapping(value = "/cu/", method = RequestMethod.POST)
    public ResponseEntity<?> createCarteUtilisateur(@RequestBody CarteUtilisateur target, UriComponentsBuilder ucBuilder)
    {
        String msg = String.format("Creating CarteUtilisateur : {%s}", target);
        log.info(msg);

        CarteUtilisateur current = repo.findOne(target.getId());
        if (current != null)
        {
            msg = String.format("Unable to create. A CarteUtilisateur with id {%s} already exist", target.getId());
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg),HttpStatus.CONFLICT);
        }
        repo.save(target);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/cu/{id}").buildAndExpand(target.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a CarteUtilisateur ------------------------------------------------

    @RequestMapping(value = "/cu/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCarteUtilisateur(@PathVariable("id") CarteUtilisateurId id, @RequestBody CarteUtilisateur target)
    {
        String msg = String.format("Updating CarteUtilisateur with id {%s}",id);
        log.info(msg);

        CarteUtilisateur current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("Unable to update. CarteUtilisateur with id {%s} not found.",id);
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg),HttpStatus.NOT_FOUND);
        }
        current.setNombreExemplaires(target.getNombreExemplaires());
        repo.save(current);
        return new ResponseEntity<CarteUtilisateur>(current, HttpStatus.OK);
    }

    // ------------------- Delete a CarteUtilisateur-----------------------------------------

    @RequestMapping(value = "/cu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCarteUtilisateur(@PathVariable("id") CarteUtilisateurId id)
    {
        String msg = String.format("Fetching & Deleting CarteUtilisateur with id {%s}", id);
        log.info(msg);

        CarteUtilisateur current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("Unable to delete. CarteUtilisateur with id {%s} not found.", id);
            return new ResponseEntity(new CustomErrorType(msg), HttpStatus.NOT_FOUND);
        }
        repo.delete(id);
        return new ResponseEntity<CarteUtilisateur>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All CarteUtilisateur-----------------------------

    @RequestMapping(value = "/cu/", method = RequestMethod.DELETE)
    public ResponseEntity<CarteUtilisateur> deleteAllCarteUtilisateur()
    {
        log.info("Deleting All CarteUtilisateur");
        repo.deleteAll();
        return new ResponseEntity<CarteUtilisateur>(HttpStatus.NO_CONTENT);
    }


}