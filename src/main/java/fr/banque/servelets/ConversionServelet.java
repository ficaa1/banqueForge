package fr.banque.servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.banque.util.*;

import fr.banque.beans.Compte;
import fr.banque.beans.User;

/**
 * Servlet implementation class ConversionServelet
 */
@WebServlet("/ConversionServelet")
public class ConversionServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversionServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/client/index_converter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response)
		
		// recuperaion des input
		String devise_from = req.getParameter("devise_from").toString();
		String devise_to = req.getParameter("devise_to").toString();
		double montant = Double.valueOf(req.getParameter("montant"));
		ConvertisseurDevise conv =new ConvertisseurDevise (devise_from,devise_to,montant);
		
		
		double res = conv.getConvertedVal();
		req.setAttribute("resultat_conversion", String.valueOf(res));
		req.getRequestDispatcher("/WEB-INF/client/index_converter.jsp").forward(req, resp);
		
		
	}
	

}
