package com.ems.servlet;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee e = new Employee();
        e.setName(request.getParameter("name"));
        e.setEmail(request.getParameter("email"));
        e.setDepartment(request.getParameter("department"));
        try {
            e.setSalary(Double.parseDouble(request.getParameter("salary")));
            boolean saved = new EmployeeDAO().addEmployee(e);
            response.sendRedirect(saved ? "viewEmployees" : "addEmployee.jsp?error=1");
        } catch (NumberFormatException ex) {
            response.sendRedirect("addEmployee.jsp?error=1");
        }
    }
}
