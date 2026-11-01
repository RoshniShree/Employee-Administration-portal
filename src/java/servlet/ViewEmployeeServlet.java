package com.ems.servlet;

import com.ems.dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/viewEmployees")
public class ViewEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("employees", new EmployeeDAO().getAllEmployees());
        request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
    }
}
