package com.park.parkinglot.servlet.user;

import com.park.parkinglot.ejb.UserBean;
import com.park.parkinglot.util.PasswordUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author theo_
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole"}))
@WebServlet(name = "AddUser", urlPatterns = {"/Users/Create"})
public class AddUser extends HttpServlet {

    @Inject
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/user/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String position = request.getParameter("position");

        String passwordSha256 = PasswordUtil.convertToSha256(password);

        userBean.createUser(username, email, passwordSha256, position);

        response.sendRedirect(request.getContextPath() + "/Users");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
