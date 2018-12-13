package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.DAOFactory;
import persistence.dao.StudenteDao;

public class DammiStudenti extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {						
//		
//		PrintWriter out = resp.getWriter();
//		out.println("<h1>Di seguito gli studenti richiesti</h1>");
//		
//		RequestDispatcher rd = req.getRequestDispatcher("gestioneStudenti/studenti.html");		
//		rd.include(req, resp);
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {						
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Di seguito gli studenti richiesti</h1>");
		
		if (req.getParameter("filtraCognome") != null) {
			StudenteDao dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getStudenteDAO();
			System.out.println(dao.findAll().size());
			
			RequestDispatcher rd = req.getRequestDispatcher("filtraStudenti");		
			rd.include(req, resp);
		}else {
			
			
			RequestDispatcher rd = req.getRequestDispatcher("gestioneStudenti/studenti.html");		
			rd.include(req, resp);
		}
		
	}
}
