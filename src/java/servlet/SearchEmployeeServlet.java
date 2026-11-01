package com.ems.servlet;

import com.ems.dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/searchEmployee")
public class SearchEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("employee", new EmployeeDAO().getEmployeeById(id));
        } catch (NumberFormatException ex) {
            request.setAttribute("employee", null);
        }
        request.getRequestDispatcher("searchResult.jsp").forward(request, response);
    }
}
