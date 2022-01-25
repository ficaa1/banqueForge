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

public class VirementServelet extends HttpServlet {
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
		req.getRequestDispatcher("/WEB-INF/client/virement.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		User user = (User) req.getSession().getAttribute("user");
		List<Compte> mescomptes = new ArrayList<Compte>();
		mescomptes = compteDao.mescomptes(user);
		user.setMescomptes(mescomptes);
		
		
		int debiteur = Integer.parseInt(req.getParameter("debiteur"));
		int crediteur = Integer.parseInt(req.getParameter("crediteur"));
		float montant = Float.parseFloat(req.getParameter("montant"));
		
		// on verifie si le compte exite
		Compte compte_crediteur = compteDao.getComptebyNumero(crediteur);
		Compte compte_debiteur = compteDao.getComptebyNumero(debiteur);
		if(compte_crediteur!=null && compte_debiteur!=null)
		{
			if(user.MonCompte(compte_debiteur)) {
			
			
			if(user.MonCompte(compte_debiteur) && compteDao.virement(compte_debiteur, compte_crediteur, montant)==true){
				resp.sendRedirect("/banque/client/index");
				
				
				
			}else
			{
				// erreur pas assez de credit
				String erreur ="Virement impossible !";
				req.setAttribute("error", erreur);
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
			
			}
			
			}else {
				// erreur compte debiteur pas le votre
				String erreur ="Virement impossible !";
				req.setAttribute("error", erreur);
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
				
				
				
			}
		}else
		{
			//erreur de compte qui n'existe pas
			String erreur ="Virement impossible !";
			req.setAttribute("error", erreur);
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}
	}
	

}
