package fr.m2miage.geocartebck.controller;

import fr.m2miage.geocartebck.dao.UtilisateurRepository;
import fr.m2miage.geocartebck.model.Utilisateur;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class UtilisateurController
{

    public static final Logger log = Logger.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurRepository repo;


    // -------------------Recupere tous les typeMonuments---------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Utilisateur>> listAllUsers()
    {
        List<Utilisateur> list = repo.findAll();
        if (list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // -------------------Recupere un TypeMonument------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") int id)
    {
        String msg = String.format("Fetching User with id {%s}", id);
        log.info(msg);
        Utilisateur current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("User with id {%s} not found.", id);
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Utilisateur>(current, HttpStatus.OK);
    }

    // -------------------Create a TypeMonument-------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Utilisateur target, UriComponentsBuilder ucBuilder)
    {
        String msg = String.format("Creating User : {%s}", target);
        log.info(msg);

        Utilisateur current = repo.findOne(target.getId());
        if (current != null)
        {
            msg = String.format("Unable to create. A User with id {%s} already exist", target.getId());
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg),HttpStatus.CONFLICT);
        }
        repo.save(target);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(target.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a TypeMonument ------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Utilisateur target)
    {
        String msg = String.format("Updating User with id {%s}",id);
        log.info(msg);

        Utilisateur current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("Unable to update. User with id {%s} not found.",id);
            log.error(msg);
            return new ResponseEntity(new CustomErrorType(msg),HttpStatus.NOT_FOUND);
        }
        current.setNom(target.getNom());
        current.setEmail(target.getEmail());
        current.setMotdepasse(target.getMotdepasse());
        repo.save(current);
        return new ResponseEntity<Utilisateur>(current, HttpStatus.OK);
    }

    // ------------------- Delete a TypeMonument-----------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id)
    {
        String msg = String.format("Fetching & Deleting user with id {%s}", id);
        log.info(msg);

        Utilisateur current = repo.findOne(id);
        if (current == null)
        {
            msg = String.format("Unable to delete. user with id {%s} not found.", id);
            return new ResponseEntity(new CustomErrorType(msg), HttpStatus.NOT_FOUND);
        }
        repo.delete(id);
        return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All TypeMonument-----------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<Utilisateur> deleteAllUser()
    {
        log.info("Deleting All user");
        repo.deleteAll();
        return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
    }


}