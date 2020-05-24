package relations.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet("/favourites")
public class FavouriteServlet extends HttpServlet {
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
		String action = request.getServletPath();
		System.out.println("SERVLET ACTION: " + action);
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertFavourite(request, response);
				break;
			case "/delete":
				deleteFavourite(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateFavourite(request, response);
				break;
			case "/list":
				listFavourite(request, response);
				break;
			default:
				listFavourite(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listFavourite(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
//		List<Favourite> listFavourite = favouriteDao.getAllFavourite();
//		request.setAttribute("listFavourite", listFavourite);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("favourite-list.jsp");
//		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("favourite-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Favourite existingFavourite = favouriteDao.getFavourite(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("favourite-form.jsp");
		request.setAttribute("favourite", existingFavourite);
		dispatcher.forward(request, response);

	}

	private void insertFavourite(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println(request.getParameter("userID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		int gameID = Integer.parseInt(request.getParameter("gameID"));
		Favourite newFavourite = new Favourite(userID, gameID);
		favouriteDao.saveFavourite(newFavourite);
		response.sendRedirect("list");
	}

	private void updateFavourite(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("ID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		int gameID = Integer.parseInt(request.getParameter("gameID"));


		Favourite favourite = new Favourite(id, userID, gameID);
		favouriteDao.updateFavourite(favourite);
		response.sendRedirect("list");
	}

	private void deleteFavourite(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("ID"));
		favouriteDao.deleteFavourite(id);
		response.sendRedirect("list");
	}
}
