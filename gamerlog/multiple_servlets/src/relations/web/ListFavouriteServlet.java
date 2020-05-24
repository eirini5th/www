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

import relations.dao.FavouriteDao;
import relations.model.Favourite;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the favourite.
 * 
 * @email Ramesh Fadatare
 */

@WebServlet("/listfavourites")
public class ListFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavouriteDao favouriteDao;

	public void init() {
		favouriteDao = new FavouriteDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listFavourite(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listFavourite(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int userID = Integer.parseInt(request.getParameter("id"));
		List<Favourite> listFavourite = favouriteDao.getAllFavourite(userID);
		// PUT HERE getGameFromList
		List<Game> favouriteGames = new ArrayList<Game>();
		GameDao gameDao = new GameDao();
		Iterator<Favourite> faveIt = listFavourite.iterator();
		while (faveIt.hasNext()) {
			Favourite f = faveIt.next();
			Game g = gameDao.getGameFromList(f.getGameID());
			favouriteGames.add(g);
		}
		
		System.out.println("TTTTT");
		Iterator<Game> gameIt = favouriteGames.iterator();
		while (gameIt.hasNext()) {
			System.out.println((gameIt.next()).getTitle());
		}
		
		//display list of games instead of list of relations
		
		request.setAttribute("listGame", favouriteGames);
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-list.jsp");
		dispatcher.forward(request, response);
		
//		request.setAttribute("listFavourite", listFavourite);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("favourite-list.jsp");
//		dispatcher.forward(request, response);
	}
}
