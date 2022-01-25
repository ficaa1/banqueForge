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

public class RetraitServelet  extends HttpServlet{
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
		req.getRequestDispatcher("/WEB-INF/client/retrait.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// recuperaion des input
		
		User user = (User) req.getSession().getAttribute("user");
		List<Compte> mescomptes = new ArrayList<Compte>();
		mescomptes = compteDao.mescomptes(user);
		user.setMescomptes(mescomptes);
		
				
				int numero = Integer.parseInt(req.getParameter("numero_compte"));
				float montant = Float.parseFloat(req.getParameter("montant"));
				// on verifie si le compte exite
				Compte compte = compteDao.getComptebyNumero(numero);
				if(compte!=null)
				{
					if (user.MonCompte(compte)) {
					
					// on credite ici
					if(compteDao.retrait(compte, montant)==true)
					{
						// on affiche success
						resp.sendRedirect("/banque/client/index");
					}else
					{
						// erreur
						String erreur ="Retrait impossible ! Pas assez de crédit !";
						req.setAttribute("error", erreur);
						req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
					}
					
					}else {
						
						// erreur pas votre compte
						String erreur ="Retrait impossible ! Le compte de retrait n'est pas le votre !";
						req.setAttribute("error", erreur);
						req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
						
					}
					
				}else
				{
					//  erreur compte
					String erreur ="Retrait impossible ! Compte inexistant !";
					req.setAttribute("error", erreur);
					req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
				}
				
			}
			

	}
	


