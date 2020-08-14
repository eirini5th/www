package relations.web;

import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
import java.sql.SQLException;
import java.util.Iterator;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
import java.util.List;

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
		String path = request.getServletPath();
		request.setAttribute("loggedID", userID);
		
		if (listEntryDao.checkIfExists(userID, gameID, listname) == false) {
			if (listname.equals("favourites")) {
				ListEntry newListEntry = new ListEntry(userID, gameID, "hasplayed");
				listEntryDao.saveListEntry(newListEntry);
			}
			
			if (listname.equals("hasplayed")) {
				//if added to hasplayed, remove from wanttoplay & currently playing
				List<ListEntry> userList = listEntryDao.getSpecificEntries(userID, gameID, "wanttoplay");
				Iterator<ListEntry> listIt = userList.iterator();
				while (listIt.hasNext()) {
					listEntryDao.deleteListEntryObject(listIt.next());
				}
				userList = listEntryDao.getSpecificEntries(userID, gameID, "currplaying");
				listIt = userList.iterator();
				while (listIt.hasNext()) {
					listEntryDao.deleteListEntryObject(listIt.next());
				}
			}

			ListEntry newListEntry = new ListEntry(userID, gameID, listname);
			listEntryDao.saveListEntry(newListEntry);
		}
		
		
		if (path.equals("/newlistentry")) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("homepageServlet?id="+userID);
//			dispatcher.forward(request, response);
			response.sendRedirect("homepageServlet?id="+userID);

		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("displayuserlist?id="+userID+"&listname="+listname);
			dispatcher.forward(request, response);
		}
	}

}
