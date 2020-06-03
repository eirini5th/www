package relations.web;

import games.model.Game;
import games.dao.GameDao;

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
		int userID = Integer.parseInt(request.getParameter("id"));
		String listname = request.getParameter("listname");
		
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
		
		//display list of games instead of list of relations
		request.setAttribute("listGame", listEntryGames);
		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(request, response);
		
//		request.setAttribute("listListEntry", listListEntry);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("listEntry-list.jsp");
//		dispatcher.forward(request, response);
	}
}
