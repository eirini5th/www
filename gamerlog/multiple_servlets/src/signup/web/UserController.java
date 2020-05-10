package signup.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signup.dao.UserDao;
import signup.model.User;


@WebServlet("/signup")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	signup(request, response);
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("signup-failed.jsp");
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //check if username already exists
        if (userDao.checkIfExists(username)) {
            response.sendRedirect("signup-failed.jsp");
        }
        else {
            userDao.saveUser(user);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("game-list.jsp");
            dispatcher.forward(request, response);
        }
        

    }
}