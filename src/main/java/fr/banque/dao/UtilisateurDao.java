package fr.banque.dao;

import java.util.List;

import fr.banque.beans.User;

public interface UtilisateurDao {
	User connexion(User utilisateur);
	void ajouterUser( User utilisateur );
	void modifier( User utilisateur );
	void supprimer( User utilisateur );
    List<User> listeradmin();
    List<User> listerclient();
    

}
