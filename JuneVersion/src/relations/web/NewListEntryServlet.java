package relations.web;

import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import games.dao.GameDao;
//import games.model.Game;
import relations.model.ListEntry;

import relations.dao.ListEntryDao;
//import relations.model.ListEntry;


@WebServlet("/newlistentry")
public class NewListEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListEntryDao listEntryDao;

	public void init() {
		listEntryDao = new ListEntryDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			addToList(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("userlist-form.jsp"); //former favourite-form
//		dispatcher.forward(request, response);
//	}
	
	private void addToList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int userID = Integer.parseInt(request.getParameter("user"));
		int gameID = Integer.parseInt(request.getParameter("game"));
		String listname = request.getParameter("listname");
		
		ListEntry newListEntry = new ListEntry(userID, gameID, listname);
		listEntryDao.saveListEntry(newListEntry);
		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(request, response);

	}

}
