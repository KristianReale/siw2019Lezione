package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;

public class IscriviStudente extends HttpServlet{
		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricola = req.getParameter("matricola");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String dataNascita = req.getParameter("dataNascita");
	
		DateFormat format = new SimpleDateFormat
							("yyyy-mm-dd", Locale.ITALIAN);
		Date date;
		try {
			date = format.parse(dataNascita);
			Studente stud = 
					new Studente(matricola, nome, cognome, date);
			
			req.setAttribute("studente", stud);
			
			RequestDispatcher dispacher = 
					req.getRequestDispatcher("completaIscrizione");
			dispacher.forward(req, resp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
