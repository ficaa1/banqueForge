package fr.banque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.banque.beans.Compte;
import fr.banque.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CompteDaoImpl implements CompteDao{
	private DaoFactory daoFactory;
	public CompteDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	public void creercompte(Compte compte, User user) {
		UtilisateurDao utilisateurDao;
		utilisateurDao = daoFactory.getUtilisateurDao();
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        /* l'ajout d'un compte se fait en 2 etapes on ajoute d'abord le User
         * puis la clé primaire (login) de User migre vers le model du compte bancaire
         */
        
        // appel de la methode d'ajout d'un compte 
        utilisateurDao.ajouterUser(user);
        
        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO compte(solde,decouvertmaximal,debitmaximal,login_user) VALUES(?,?,?,?);");
            preparedStatement.setFloat(1, compte.getSolde());
            preparedStatement.setInt(2, compte.getDecouvertmaximal());
            preparedStatement.setInt(3, compte.getDebitmaximal());
            preparedStatement.setString(4,user.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		

	
		
	}

	public List<Compte> mescomptes(User user) {
		// TODO Auto-generated method stub
		 List<Compte> mescomptes = new ArrayList<Compte>();
	        Connection connexion = null;
	        ResultSet resultat = null;
	        PreparedStatement preparedStatement = null;


	        try {
	            connexion = (Connection) daoFactory.getConnection();
	          //  statement = (Statement) connexion.createStatement();
	            preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM compte where  login_user=?;");
	            preparedStatement.setString(1, user.getLogin());
	            resultat = preparedStatement.executeQuery();	
	            while (resultat.next()) {
	                int  numero = resultat.getInt("numero_compte");
	                float solde = resultat.getFloat("solde");
	                int decouvertmax = resultat.getInt("decouvertmaximal");
	                int debitmaximal = resultat.getInt("debitmaximal");
	                
	                Compte compte = new Compte(solde, decouvertmax, debitmaximal);
	                compte.setNumero(numero);
	                mescomptes.add(compte);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return mescomptes;
	    }
	

	public boolean crediter(Compte compte, float montant) {
		
		// on verifie dabord qu'on peut crediter le montant
		if(compte.crediter(montant)==true)
		{
			// on update le compte
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = (Connection) daoFactory.getConnection();
	            preparedStatement = (PreparedStatement) connexion.prepareStatement("Update compte set solde=? where numero_compte=?;");
	            preparedStatement.setFloat(1, compte.getSolde()+montant);
	            preparedStatement.setInt(2,compte.getNumerocompte());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

			
			return true;
		}else
		{
			return false;
		}
		
	}
	public boolean virement(Compte compte, Compte compte_re, float montant) {
		CompteDao compteDao = daoFactory.getCompteDao();
		
		if(compte.virement(montant, compte_re)==true)
		{
			
			compteDao.crediter(compte_re, montant);
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = (Connection) daoFactory.getConnection();
	            preparedStatement = (PreparedStatement) connexion.prepareStatement("Update compte set solde=? where numero_compte=?;");
	            preparedStatement.setFloat(1, (compte.getSolde()-montant));
	            preparedStatement.setInt(2,compte.getNumerocompte());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
			return true;
			
		}else
		{
			return false;
		}
	}
	
	public Compte getComptebyNumero(int numero) {
        Connection connexion = null;
        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;
        Compte  compte;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM compte where  numero_compte=?;");
            preparedStatement.setInt(1, numero);
            resultat = preparedStatement.executeQuery();	
            while (resultat.next()) {
                int  numero_compte = resultat.getInt("numero_compte");
                float solde = resultat.getFloat("solde");
                int decouvertmax = resultat.getInt("decouvertmaximal");
                int debitmaximal = resultat.getInt("debitmaximal");
                
                compte = new Compte(solde, decouvertmax, debitmaximal);
                compte.setNumero(numero_compte);
                return compte;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     
        return null;
	

	}
	
	public boolean retrait(Compte compte, float montant) {
		// on verifie dabord si on peut debiter ce compte
		System.out.println(compte.toString()+" montant retrait : "+montant);

		if(compte.retrait(montant)==true)
		{
			// maj du compte
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = (Connection) daoFactory.getConnection();
	            preparedStatement = (PreparedStatement) connexion.prepareStatement("Update compte set solde=? where numero_compte=?;");
	            preparedStatement.setFloat(1, compte.getSolde()-montant);
	            preparedStatement.setInt(2,compte.getNumerocompte());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

			
			return true;
		}else
		{
			return false;
		}

	
	}

	

	
	
	}
	


