package com.example.demo.repositories;

import com.example.demo.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    /**
     * @author Mouhamed NDOYE
     * @param username username of the user
     * @param password password of the user
     * @return return the user if all credentials are correct meaning if he can connect or not
     * this is a method that verify into the database the credentials given by a user
     */
    @Query("select u from Utilisateur u where u.username=:username and u.password=:password")
    public Optional<Utilisateur> getUtilisateurByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
