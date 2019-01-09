package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;
import persistence.DAOFactory;
import persistence.StudenteCredenziali;
import persistence.dao.StudenteDao;

public class CredenzialiLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		StudenteDao sDao = factory.getStudenteDAO();
		StudenteCredenziali s = sDao.findByPrimaryKeyCredential(username);
		
		if (s == null) {
			RequestDispatcher rd = req.getRequestDispatcher("loginFailed.html");
			rd.forward(req, resp);
		}else {
			if (s.getPassword().equals(password)) {
				req.getSession().setAttribute("username", username);
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("loginFailed.html");
				rd.forward(req, resp);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
