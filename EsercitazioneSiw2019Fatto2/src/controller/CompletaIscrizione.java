package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;

public class CompletaIscrizione extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Studente stud = (Studente) req.getAttribute("studente");
		String password = req.getParameter("password");
		
		//TODO PERSISTENZA
		
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("studenteIscritto.html");
		dispacher.forward(req, resp);
	}
}
