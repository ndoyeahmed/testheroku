package com.example.demo.services;

import com.example.demo.models.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mouhamed NDOYE
 * this is a service class when we make all traitement
 * before sending data to the cleint
 * and it manage automatically the transaction processus
 */
@Service
@Transactional
public class UtilisateurService {
    /**
     * this is a way to instantiate the repository with dependency injection
     */
    @Autowired private UtilisateurRepository utilisateurRepository;

    /**
     * This allow to add a new user
     * @param utilisateur the that will gonna be addedd
     * @return return true if all is ok and false if there is problem on insertion
     */
    public boolean addUser(Utilisateur utilisateur) {
        try {
            utilisateurRepository.save(utilisateur);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * this function allow us to identify a user who want to connect to the
     * application
     * @param username
     * @param password
     * @return return the user corresponding with the credentials
     */
    public Utilisateur connexion(String username, String password) {
        try {
            Utilisateur utilisateur = utilisateurRepository.getUtilisateurByUsernameAndPassword(username, password).orElse(null);
            return utilisateur;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  method that return all users in the database
     * @return return all users
     */
    public List<Utilisateur> allUser() {
        return utilisateurRepository.findAll();
    }
}
