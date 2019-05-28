package com.example.demo.controller;

import com.example.demo.models.Utilisateur;
import com.example.demo.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Mouhamed NDOYE
 * @since 26/05/2019
 * this a controller class when we offer service to a client to get or post data if it is authenticated
 */
@RestController
@RequestMapping("/mschool")
public class UtilisateurController {
    @Autowired private UtilisateurService utilisateurService;


    @PostMapping("/login")
    public ResponseEntity connexion(@RequestBody Utilisateur utilisateur) {
        try{
            Utilisateur resuult = utilisateurService.connexion(utilisateur.getUsername(), utilisateur.getPassword());
            return new ResponseEntity<>(resuult, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-user")
    public ResponseEntity<List<Utilisateur>> listUser() {
        return ResponseEntity.ok(utilisateurService.allUser() != null ? utilisateurService.allUser() : new ArrayList<>());
    }
}
