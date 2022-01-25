package fr.banque.dao;

import java.util.List;

import fr.banque.beans.Compte;
import fr.banque.beans.User;

public interface CompteDao {
	void creercompte (Compte compte,User user);
	List<Compte> mescomptes(User user);
	boolean crediter(Compte compte,float montant);
	boolean retrait (Compte compte,float montant);
	boolean virement (Compte compte,Compte compte_re, float montant);
	Compte getComptebyNumero(int numero);
}
