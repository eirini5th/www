package relations.web;

import games.model.Game;
import login.model.User;
import games.dao.GameDao;
import login.dao.UserDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import relations.dao.ListEntryDao;
import relations.model.ListEntry;


@WebServlet("/displayuserlist")
public class DisplayUserListServlet extends HttpServlet {
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
			displayList(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void displayList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		// get userID from homepage.jsp SHOULD ALSO give it back to homepage.jsp/homepageServlet
		int userID = Integer.parseInt(request.getParameter("id"));
		String listname = request.getParameter("listname");
		
		UserDao userDao = new UserDao();
		User loggedUser = userDao.giveUserFromID(userID);
		String loggedUsername = loggedUser.getUsername();
		
		List<ListEntry> userList = listEntryDao.getAllListEntries(userID, listname);
		
		// PUT HERE getGameFromList
		List<Game> listEntryGames = new ArrayList<Game>();
		GameDao gameDao = new GameDao();
		Iterator<ListEntry> listIt = userList.iterator();
		while (listIt.hasNext()) {
			ListEntry f = listIt.next();
			Game g = gameDao.getGameFromList(f.getGameID());
			listEntryGames.add(g);
		}
		
		Iterator<Game> gameIt = listEntryGames.iterator();
		while (gameIt.hasNext()) {
			System.out.println((gameIt.next()).getTitle());
		}
		
		//try to give id back to homepage.jsp
//		request.setAttribute(userID, "loggedID");
		
		// set username & id to use when "calling" pages with game lists
		request.setAttribute("loggedUsername", loggedUsername);
		request.setAttribute("loggedID", userID);
		
		// REPLACE WITH A SWITCH CASE FOR EACH LIST NAME
		String attr = new String();
		switch (listname) {
			case "favourites":
				attr = "Favourites";
				break;
			case "wanttoplay":
				attr = "Want To Play";
				break;
			case "currplaying":
				attr = "Currently Playing";
				break;
			case "hasplayed":
				attr = "Has Played";
				break;
		}
		request.setAttribute("listnamespaces", attr);
		request.setAttribute("listname", listname);

		//display list of games instead of list of relations
		request.setAttribute("listGame", listEntryGames);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("listpage.jsp");
		dispatcher.forward(request, response);

	}
}
