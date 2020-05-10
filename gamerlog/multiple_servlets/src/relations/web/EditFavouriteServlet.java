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

@WebServlet("/editfavourite")
public class EditFavouriteServlet extends HttpServlet {
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
			showEditForm(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Favourite existingFavourite = favouriteDao.getFavourite(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("favourite-form.jsp");
		request.setAttribute("favourite", existingFavourite);
		dispatcher.forward(request, response);

	}
}
