package relations.web;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.List;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import games.model.Game;
import login.dao.UserDao;
import login.model.User;
import relations.dao.ListEntryDao;
//import relations.model.ListEntry;
import relations.model.ListEntry;

@WebServlet("/deletelistentry")
public class DeleteListEntryServlet extends HttpServlet {
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
			deleteListEntry(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void deleteListEntry(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int userID = Integer.parseInt(request.getParameter("user"));
		int gameID = Integer.parseInt(request.getParameter("game"));
		String listname = request.getParameter("listname");
		
		request.setAttribute("loggedID", userID);
		
		if (listname.equals("hasplayed")) {
			//remove from favourites
			List<ListEntry> userList = listEntryDao.getSpecificEntries(userID, gameID, "favourites");

			Iterator<ListEntry> listIt = userList.iterator();
			while (listIt.hasNext()) {
				listEntryDao.deleteListEntryObject(listIt.next());
			}
		}
		
		//find entry id from user, game, listname combo
		List<ListEntry> userList = listEntryDao.getSpecificEntries(userID, gameID, listname);

		Iterator<ListEntry> listIt = userList.iterator();
		while (listIt.hasNext()) {
			listEntryDao.deleteListEntryObject(listIt.next());
		}
		
		UserDao userDao = new UserDao();
		User loggedUser = userDao.giveUserFromID(userID);
		String loggedUsername = loggedUser.getUsername();
		request.setAttribute("loggedUsername", loggedUsername);
		request.setAttribute("loggedID", userID);
		request.setAttribute("listname", listname);

		RequestDispatcher dispatcher = request.getRequestDispatcher("displayuserlist?id="+userID+"&listname="+listname);

		dispatcher.forward(request, response);
	}
}
