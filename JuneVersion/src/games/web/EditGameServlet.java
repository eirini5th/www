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

@WebServlet("/editgame")
public class EditGameServlet extends HttpServlet {
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
			showEditForm(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Game existingGame = gameDao.getGame(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-form.jsp");
		request.setAttribute("game", existingGame);
		dispatcher.forward(request, response);

	}
}
