package fr.banque.beans;




public class Compte {
	
	
	private int numero_compte ;
	
	//Debitmaximal de retrait
	private int decouvertmaximal,debitmaximal;
	private float solde;
	
	public Compte()
	{
		this.solde = 0;
		this.debitmaximal = 800;
		this.debitmaximal = 1000;
	}
	
	public Compte(float solde, int decouvertmax, int debitmax)
	{
		this.solde = solde;
		this.decouvertmaximal = decouvertmax;
		this.debitmaximal = debitmax;
	}

	
	public float getSolde()
	{
		return this.solde;
	}
	public int getDecouvertmaximal()
	{
		return this.decouvertmaximal;
	}
	public int getDebitmaximal()
	{
		return this.debitmaximal;
	}
	public int getNumerocompte()
	{
		return this.numero_compte;
	}
	public boolean getEtat()
	{
		if(this.solde>0){
			return true;
		}else
		{
			return false;
		}
	
	}
	
	public boolean crediter(float montant)
	{
		if(montant>0){
			
			return true;
		}else
		{
			
			return false;
		}
	}
	
	public boolean virement(float montant, Compte compte_recpeteur)
	{
		if(this.solde-montant>this.decouvertmaximal && (this.getNumerocompte()!=compte_recpeteur.getNumerocompte()))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean retrait (float montant)
	{
		if(montant > this.debitmaximal)
		{
			return false;
		}else
		{
			if(this.solde-montant>this.decouvertmaximal)
			{
				return true;
			}else
			{
				return false;
			}
		}
		
	}
	
	 
	public void setDebitmaximal(int debit)
	{
		this.debitmaximal = debit;
	
	}
	
	public void setDecouvertmaximal(int decouvert)
	{
		this.decouvertmaximal = decouvert;
	}
	
	public void setNumero(int numero)
	{
		this.numero_compte = numero;
	}
	public String toString()
	{
		String text =" N° Compte : "+this.getNumerocompte() + " - Solde = "+this.getSolde();
		return text;
	}
}
