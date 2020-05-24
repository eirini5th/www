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

@WebServlet("/")
public class GameServlet extends HttpServlet {
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
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertGame(request, response);
				break;
			case "/delete":
				deleteGame(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateGame(request, response);
				break;
			case "/list":
				listGame(request, response);
				break;
			default:
				listGame(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listGame(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Game> listGame = gameDao.getAllGame();
		request.setAttribute("listGame", listGame);
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Game existingGame = gameDao.getGame(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-form.jsp");
		request.setAttribute("game", existingGame);
		dispatcher.forward(request, response);

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
		response.sendRedirect("list");
	}

	private void updateGame(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("ID"));
		String title = request.getParameter("title");
		String yearReleased = request.getParameter("yearReleased");
		String developers = request.getParameter("developers");
		String publishers = request.getParameter("publishers");
		String genres = request.getParameter("genres");
		String image = request.getParameter("image");

		Game game = new Game(id, title, yearReleased, developers, publishers, genres, image);
		gameDao.updateGame(game);
		response.sendRedirect("list");
	}

	private void deleteGame(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("ID"));
		gameDao.deleteGame(id);
		response.sendRedirect("list");
	}
}
