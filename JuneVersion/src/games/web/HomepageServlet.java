package games.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import games.dao.GameDao;
import games.model.Game;
import login.dao.*;
import login.model.*;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the game.
 * 
 * @email Ramesh Fadatare
 */

@WebServlet("/homepageServlet")
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameDao gameDao;

	public void init() {
		gameDao = new GameDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			listGame(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listGame(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		UserDao userDao = new UserDao();
		
		// homepage only needs userID
		// get user id (first from login then from the rest of the pages)
		int userID = Integer.parseInt(request.getParameter("id"));
		User loggedUser = userDao.giveUserFromID(userID);
		String loggedUsername = loggedUser.getUsername();
		
		// set username & id to use when "calling" pages with game lists
		request.setAttribute("loggedUsername", loggedUsername);
		request.setAttribute("loggedID", userID);
		List<Game> listGame = gameDao.getAllGame();
		request.setAttribute("listGame", listGame);
//		System.out.println("LLLLLLLLL");

		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(request, response);
	}

}
