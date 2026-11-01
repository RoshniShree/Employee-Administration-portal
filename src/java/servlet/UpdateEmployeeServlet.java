package com.ems.servlet;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Employee e = new EmployeeDAO().getEmployeeById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("employee", e);
            request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
        } catch (NumberFormatException ex) { response.sendRedirect("viewEmployees"); }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Employee e = new Employee(Integer.parseInt(request.getParameter("id")),
                    request.getParameter("name"), request.getParameter("email"),
                    request.getParameter("department"), Double.parseDouble(request.getParameter("salary")));
            new EmployeeDAO().updateEmployee(e);
            response.sendRedirect("viewEmployees");
        } catch (NumberFormatException ex) { response.sendRedirect("viewEmployees"); }
    }
}
