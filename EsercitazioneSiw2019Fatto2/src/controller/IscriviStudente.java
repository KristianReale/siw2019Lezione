package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dipartimento;
import model.Scuola;
import model.Studente;
import persistence.DAOFactory;
import persistence.dao.DipartimentoDao;
import persistence.dao.ScuolaDao;
import persistence.dao.StudenteDao;

public class IscriviStudente extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		String matricola = req.getParameter("matricola");
		String nome = req.getParameter("matricola");
		String cognome = req.getParameter("matricola");
		String dataNascita = req.getParameter("dataNascita");
		String idScuola = req.getParameter("scuola");
		
		ScuolaDao scuolaDao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getScuolaDAO();
		Scuola scuola = scuolaDao.findByPrimaryKey(Long.parseLong(idScuola));
		
		List<Scuola> scuole = scuolaDao.findAll();
		req.setAttribute("scuole", scuole);
		
		DateFormat format = new SimpleDateFormat(
							"yyyy-mm-dd", Locale.ITALIAN);
		
		try {
			Date date = format.parse(dataNascita);
			Studente s = new Studente(matricola, nome, cognome, date);	
			s.setScuolaDiDiploma(scuola);
			StudenteDao sDao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getStudenteDAO();
			sDao.save(s);
			
			Studente sSalvato = sDao.findByPrimaryKey(matricola);
			req.setAttribute("studenteCreato", sSalvato);
			
			RequestDispatcher rd = req.getRequestDispatcher("iscriviStudenti.jsp");
			rd.forward(req, resp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		resp.getWriter().println(matricola);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ScuolaDao sDao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getScuolaDAO();
		List<Scuola> scuole = sDao.findAll();
		req.setAttribute("scuole", scuole);
		
		DipartimentoDao dDao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getDipartimentoDAO();
		List<Dipartimento> dipartimenti = dDao.findAll();
		req.setAttribute("dipartimenti", dipartimenti);
		
		RequestDispatcher rd = req.getRequestDispatcher("iscriviStudenti.jsp");
		rd.forward(req, resp);
	}
}
