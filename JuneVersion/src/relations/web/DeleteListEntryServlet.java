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
//import relations.model.ListEntry;

@WebServlet("/deletelistentry")
public class DeleteListEntryServlet extends HttpServlet {
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
			deleteListEntry(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void deleteListEntry(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		listEntryDao.deleteListEntry(id);
		response.sendRedirect("displayuserlist"); //former listfavourites
	}
}
