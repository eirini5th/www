package relations.web;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import relations.dao.ListEntryDao;
import relations.model.ListEntry;

@WebServlet("/editlistentry")
public class EditListEntryServlet extends HttpServlet {
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
			showEditForm(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ListEntry existingListEntry = listEntryDao.getListEntry(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userlist-form.jsp"); //former favourite-form
		request.setAttribute("listEntry", existingListEntry);
		dispatcher.forward(request, response);

	}
}
