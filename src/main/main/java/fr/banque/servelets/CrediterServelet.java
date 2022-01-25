package fr.banque.servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.banque.beans.Compte;
import fr.banque.beans.User;
import fr.banque.dao.CompteDao;
import fr.banque.dao.DaoFactory;

public class CrediterServelet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CompteDao compteDao;
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.compteDao = daoFactory.getCompteDao();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.getRequestDispatcher("/WEB-INF/client/crediter.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		User user = (User) req.getSession().getAttribute("user");
		List<Compte> mescomptes = new ArrayList<Compte>();
		mescomptes = compteDao.mescomptes(user);
		user.setMescomptes(mescomptes);
		
		
		
		
		// recuperaion des input
		int numero = Integer.parseInt(req.getParameter("numero_compte"));
		float montant = Float.parseFloat(req.getParameter("montant"));
		// on verifie si le compte existe
		Compte compte = compteDao.getComptebyNumero(numero);
		if(compte!=null)
		{
			
			if (user.MonCompte(compte)) {
			// on credite ici
			if(compteDao.crediter(compte, montant)==true)
			{
				// on affiche success
				resp.sendRedirect("/banque/client/index");
			}else
			{
				String erreur ="Versement impossible ! Erreur interne !";
				req.setAttribute("error", erreur);
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		        }
			}else {
				//Erreur pas votre compte
				String erreur ="Versement impossible ! Le compte créditeur c'est pas le votre !";
				req.setAttribute("error", erreur);
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
			}
			
		}else
		{
			String erreur ="Versement impossible ! Compte inexistant !";
			req.setAttribute("error", erreur);
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);	
	        }
		
	}
	

}
