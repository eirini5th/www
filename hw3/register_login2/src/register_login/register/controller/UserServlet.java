package register_login.register.controller;

//package net.javaguides.employeemanagement.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.javaguides.employeemanagement.dao.EmployeeDao;
//import net.javaguides.employeemanagement.model.Employee;
import register_login.register.dao.UserDao;
import register_login.register.model.User;


@WebServlet("/register")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserDao userDao;

  public void init() {
  	userDao = new UserDao();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      String address = request.getParameter("address");
      String contact = request.getParameter("contact");

      User user = new User();
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setUsername(username);
      user.setPassword(password);
      user.setContact(contact);
      user.setAddress(address);

      try {
          userDao.registerUser(user);
      } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }

      response.sendRedirect("userdetails.jsp");
  }
}