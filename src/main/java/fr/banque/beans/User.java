package fr.banque.beans;

import java.util.ArrayList;
import java.util.List;


public class User {
	
	private String login ;
	private String password,nom,prenom,adresse;
	private boolean est_admin;
    private List<Compte> mescomptes;
    
    public User()
    {
    	super();
    }
    
    public User(String nom, String prenom, String adresse,String login,String password, boolean admin){
    	this.nom = nom;
    	this.prenom = prenom;
    	this.adresse = adresse;
    	this.login = login;
    	this.password = password;
    	this.est_admin = admin;
    }
    
    
    public User(String nom, String prenom, String adresse, Compte a)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.est_admin = false;
		mescomptes = new ArrayList<Compte>();
		mescomptes.add(a);
		
	}
	
	
	public String getNom()
	{
		return this.nom;
	}
	public String getPrenom()
	{
		return this.prenom;
	}
	public String getAdresse()
	{
		return this.adresse;
	}
	
	public String getLogin()
	{
		return login;
	}
	
	public String getPassword()
	{
		return password;
	}
	public boolean getEst_admin()
	{
		return est_admin;
	}
	public List<Compte> getCompte()
	{
		return this.mescomptes;
	}
	
	
	public boolean MonCompte(Compte compte)
	{
		 for (int i = 0; i < mescomptes.size(); i++) {
		      if (mescomptes.get(i).getNumerocompte() == compte.getNumerocompte()) return true;
		      
		    }
		 return false;
	}
	
	
	public List<Compte> getMescomptes() {
		return mescomptes;
	}

	public void setMescomptes(List<Compte> mescomptes) {
		this.mescomptes = mescomptes;
	}

	public void addCompte(Compte a)
	{
		this.mescomptes.add(a);
	}
	
	
	public void setNom(String nom){
		this.nom = nom;
	}
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setEst_admin(boolean admin)
	{
		this.est_admin = admin;
	}
	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
	
	public String toString()
	{
		return this.prenom;
	}
	
	
	
}
