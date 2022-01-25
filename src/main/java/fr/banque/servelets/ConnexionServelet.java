package fr.banque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.banque.beans.User;
import fr.banque.dao.DaoFactory;
import fr.banque.dao.UtilisateurDao;

public class ConnexionServelet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ce servelet permet de gerer la connexion d'un utilisateur
		// on lui renvoie le formulaire de connexion
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		User user = new User();
		User userconnecte;
		user.setLogin(req.getParameter("login"));
		user.setPassword(req.getParameter("password"));
		userconnecte = utilisateurDao.connexion(user);

		//  on verifie si le user est bien connecte
		if(userconnecte.getNom()!=null)
		{
			// on verifie si le user est admin ou client
			if(userconnecte.getEst_admin()==true)
			{
				// si admin redirection vers admin
				req.getSession().setAttribute("user",userconnecte);
				resp.sendRedirect("/banque/admin/index");
			}else
			{
				// si client redirection vers client 
				req.getSession().setAttribute("user",userconnecte);
				resp.sendRedirect("/banque/client/index");
			}
			
		}else
		{
			// on renvoie la page avec une erreur
			String erreur ="Idantifiant ou mot de passe incorrect !";
			req.setAttribute("error", erreur);
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}
		
	}
	

}
