package relations.web;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import relations.dao.ListEntryDao;
import relations.model.ListEntry;


@WebServlet("/updatelistentry")
public class UpdateListEntryServlet extends HttpServlet {
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
			updateListEntry(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void updateListEntry(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		int gameID = Integer.parseInt(request.getParameter("gameID"));
		String listname = request.getParameter("listname");

		ListEntry listEntry = new ListEntry(id, userID, gameID, listname);
		listEntryDao.updateListEntry(listEntry);
		response.sendRedirect("displayuserlist"); //former listfavourites - now displayuserlist
	}

}
