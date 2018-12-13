package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DammiStudentiFiltro  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {						
		String filtroCognome = req.getParameter("filtraCognome");
		
		if (filtroCognome != null) {
			resp.getWriter().println("<h1>Studenti filtrati per il seguente cognome: " + filtroCognome + "</h1>");
			//TODO FARE LA QUERY
		} else {
			resp.getWriter().println("<h1>Nessun filtro applicato</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("gestioneStudenti/studenti.html");		
			rd.include(req, resp);
		}
	}
}
