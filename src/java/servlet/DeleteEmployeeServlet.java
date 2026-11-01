package com.ems.servlet;

import com.ems.dao.EmployeeDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try { new EmployeeDAO().deleteEmployee(Integer.parseInt(request.getParameter("id"))); }
        catch (NumberFormatException ignored) { }
        response.sendRedirect("viewEmployees");
    }
}
