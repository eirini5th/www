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

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the game.
 * 
 * @email Ramesh Fadatare
 */

@WebServlet("/insertgame")
public class InsertGameServlet extends HttpServlet {
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
			insertGame(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}


	private void insertGame(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");
		String yearReleased = request.getParameter("yearReleased");
		String developers = request.getParameter("developers");
		String publishers = request.getParameter("publishers");
		String genres = request.getParameter("genres");
		String image = request.getParameter("image");
		Game newGame = new Game(title, yearReleased, developers, publishers, genres, image);
		gameDao.saveGame(newGame);
		response.sendRedirect("game-list.jsp");
	}
}
