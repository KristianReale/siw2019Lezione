package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CorsoDiLaurea;
import model.Dipartimento;
import persistence.DatabaseManager;
import persistence.dao.CorsoDiLaureaDao;
import persistence.dao.DipartimentoDao;

public class FormIscrizioneFiller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dipartimento = req.getParameter("dipartimento");
		DipartimentoDao dDao = DatabaseManager.getInstance().getDaoFactory().getDipartimentoDAO();
		CorsoDiLaureaDao clDao = DatabaseManager.getInstance().getDaoFactory().getCorsoDiLaureaDAO();
		Dipartimento dip = dDao.findByPrimaryKey(Long.parseLong(dipartimento));
		resp.getOutputStream().println("<option>---</option>");
		for (CorsoDiLaurea cld : clDao.findByDipartimento(dip)) {
			resp.getOutputStream().println("<option value=\"" + cld.getCodice() + "\"> \"" + cld.getNome() + "\"</option>");
		}
	}
}
