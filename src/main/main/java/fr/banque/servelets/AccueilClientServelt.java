package fr.banque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.banque.beans.User;
import fr.banque.dao.CompteDao;
import fr.banque.dao.DaoFactory;

public class AccueilClientServelt  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private CompteDao comptedao;
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.comptedao = daoFactory.getCompteDao();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// On appelera ici la methode pour lister les compte pour un client :)))
		User user = (User) req.getSession().getAttribute("user");
		if(user != null)
		{
			req.setAttribute("mescomptes",comptedao.mescomptes(user));	
		}
	    req.getRequestDispatcher("/WEB-INF/client/index.jsp").forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

}
