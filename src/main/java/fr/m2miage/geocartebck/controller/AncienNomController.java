package fr.m2miage.geocartebck.controller;

import fr.m2miage.geocartebck.CustomErrorType;
import fr.m2miage.geocartebck.dao.AncienNomRepository;
import fr.m2miage.geocartebck.model.AncienNom;
import fr.m2miage.geocartebck.model.AncienNomId;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/")
public class AncienNomController
{

    public static final Logger log = Logger.getLogger(AncienNomController.class);

    @Autowired
    private AncienNomRepository repo;


    // -------------------Recupere tous les AncienNoms---------------------------------------------

    @RequestMapping(value = "/anom/", method = RequestMethod.GET)
    public ResponseEntity<List<AncienNom>> listAllAncienNom()
    {
        List<AncienNom> list = repo.findAll();
        if (list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // -------------------Recupere un AncienNom------------------------------------------

    @RequestMapping(value = "/anom/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAncienNom(@PathVariable("id") AncienNomId id)
    {
        String msg = String.format("Fetching AncienNom with id {%s}", id);
        log.info(msg);
        AncienNom current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("AncienNom with id {%s} not found.", id);
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AncienNom>(current, HttpStatus.OK);
    }

    // -------------------Create a AncienNom-------------------------------------------

    @RequestMapping(value = "/anom/", method = RequestMethod.POST)
    public ResponseEntity<?> createAncienNom(@RequestBody AncienNom target, UriComponentsBuilder ucBuilder)
    {
        String msg = String.format("Creating AncienNom : {%s}", target);
        log.info(msg);

        AncienNom current = repo.findOne(target.getId());
        if (current != null)
        {
            msg = String.format("Unable to create. A AncienNom with id {%s} already exist", target.getId());
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg),HttpStatus.CONFLICT);
        }
        repo.save(target);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/anom/{id}").buildAndExpand(target.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a AncienNom ------------------------------------------------

    @RequestMapping(value = "/anom/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAncienNom(@PathVariable("id") AncienNomId id, @RequestBody AncienNom target)
    {
        String msg = String.format("Updating AncienNom with id {%s}",id);
        log.info(msg);

        AncienNom current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("Unable to update. AncienNom with id {%s} not found.",id);
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg),HttpStatus.NOT_FOUND);
        }
        current.setArticle(target.getArticle());
        current.setNom(target.getNom());
        repo.save(current);
        return new ResponseEntity<AncienNom>(current, HttpStatus.OK);
    }

    // ------------------- Delete a AncienNom-----------------------------------------

    @RequestMapping(value = "/anom/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAncienNom(@PathVariable("id") AncienNomId id)
    {
        String msg = String.format("Fetching & Deleting AncienNom with id {%s}", id);
        log.info(msg);

        AncienNom current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("Unable to delete. AncienNom with id {%s} not found.", id);
            return new ResponseEntity(new CustomErrorType(msg), HttpStatus.NOT_FOUND);
        }
        repo.delete(id);
        return new ResponseEntity<AncienNom>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All AncienNom-----------------------------

    @RequestMapping(value = "/anom/", method = RequestMethod.DELETE)
    public ResponseEntity<AncienNom> deleteAllAncienNom()
    {
        log.info("Deleting All AncienNom");
        repo.deleteAll();
        return new ResponseEntity<AncienNom>(HttpStatus.NO_CONTENT);
    }


}