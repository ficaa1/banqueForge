package fr.banque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.banque.beans.User;
import fr.banque.dao.DaoFactory;
import fr.banque.dao.UtilisateurDao;

public class AddAdminServelet extends HttpServlet {
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
		req.getRequestDispatcher("/WEB-INF/admin/addadmin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User admin = new User();
		admin.setPrenom(req.getParameter("prenom"));
		admin.setNom(req.getParameter("nom"));
		admin.setAdresse(req.getParameter("adresse"));
		admin.setLogin(req.getParameter("login"));
		admin.setPassword(req.getParameter("password"));
		admin.setEst_admin(true);
		
		utilisateurDao.ajouterUser(admin);
		resp.sendRedirect("/banque/admin/index");
	}
	

}
