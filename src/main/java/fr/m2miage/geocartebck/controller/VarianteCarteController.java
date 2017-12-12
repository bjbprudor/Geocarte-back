package fr.m2miage.geocartebck.controller;

import fr.m2miage.geocartebck.dao.VarianteCarteRepository;
import fr.m2miage.geocartebck.model.VarianteCarte;
import fr.m2miage.geocartebck.model.VarianteCarteId;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class VarianteCarteController
{

    public static final Logger log = Logger.getLogger(VarianteCarteController.class);

    @Autowired
    private VarianteCarteRepository repo;


    // -------------------Recupere tous les VarianteCartes---------------------------------------------

    @RequestMapping(value = "/vcarte/", method = RequestMethod.GET)
    public ResponseEntity<List<VarianteCarte>> listAllVarianteCarte()
    {
        List<VarianteCarte> list = repo.findAll();
        if (list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // -------------------Recupere un VarianteCarte------------------------------------------

    @RequestMapping(value = "/vcarte/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getVarianteCarte(@PathVariable("id") VarianteCarteId id)
    {
        String msg = String.format("Fetching VarianteCarte with id {%s}", id);
        log.info(msg);
        VarianteCarte current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("VarianteCarte with id {%s} not found.", id);
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VarianteCarte>(current, HttpStatus.OK);
    }

    // -------------------Create a VarianteCarte-------------------------------------------

    @RequestMapping(value = "/vcarte/", method = RequestMethod.POST)
    public ResponseEntity<?> createVarianteCarte(@RequestBody VarianteCarte target, UriComponentsBuilder ucBuilder)
    {
        String msg = String.format("Creating VarianteCarte : {%s}", target);
        log.info(msg);

        VarianteCarte current = repo.findOne(target.getId());
        if (current != null)
        {
            msg = String.format("Unable to create. A VarianteCarte with id {%s} already exist", target.getId());
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg),HttpStatus.CONFLICT);
        }
        repo.save(target);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/tm/{id}").buildAndExpand(target.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a VarianteCarte ------------------------------------------------

    @RequestMapping(value = "/vcarte/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateVarianteCarte(@PathVariable("id") VarianteCarteId id, @RequestBody VarianteCarte target)
    {
        String msg = String.format("Updating VarianteCarte with id {%s}",id);
        log.info(msg);

        VarianteCarte current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("Unable to update. VarianteCarte with id {%s} not found.",id);
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg),HttpStatus.NOT_FOUND);
        }
        current.setFace(target.getFace());
        current.setDos(target.getDos());
        current.setLegende(target.getLegende());
        repo.save(current);
        return new ResponseEntity<VarianteCarte>(current, HttpStatus.OK);
    }

    // ------------------- Delete a VarianteCarte-----------------------------------------

    @RequestMapping(value = "/vcarte/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVarianteCarte(@PathVariable("id") VarianteCarteId id)
    {
        String msg = String.format("Fetching & Deleting VarianteCarte with id {%s}", id);
        log.info(msg);

        VarianteCarte current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("Unable to delete. VarianteCarte with id {%s} not found.", id);
            return new ResponseEntity(new CustomErrorType(msg), HttpStatus.NOT_FOUND);
        }
        repo.delete(id);
        return new ResponseEntity<VarianteCarte>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All VarianteCarte-----------------------------

    @RequestMapping(value = "/vcarte/", method = RequestMethod.DELETE)
    public ResponseEntity<VarianteCarte> deleteAllVarianteCarte()
    {
        log.info("Deleting All VarianteCarte");
        repo.deleteAll();
        return new ResponseEntity<VarianteCarte>(HttpStatus.NO_CONTENT);
    }


}