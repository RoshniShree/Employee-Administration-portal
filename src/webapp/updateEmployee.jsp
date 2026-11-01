<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ems.model.Employee" %>
<% if (session.getAttribute("admin") == null) { response.sendRedirect("login.jsp"); return; }
Employee e = (Employee) request.getAttribute("employee");
if (e == null) { response.sendRedirect("viewEmployees"); return; } %>
<!DOCTYPE html><html><head><title>Update Employee</title><link rel="stylesheet" href="css/style.css"></head>
<body><div class="container small"><h1>Update Employee</h1><form action="updateEmployee" method="post">
<input type="hidden" name="id" value="<%= e.getId() %>">
<label>Name</label><input name="name" value="<%= e.getName() %>" required>
<label>Email</label><input type="email" name="email" value="<%= e.getEmail() %>" required>
<label>Department</label><input name="department" value="<%= e.getDepartment() %>" required>
<label>Salary</label><input type="number" name="salary" min="0" step="0.01" value="<%= e.getSalary() %>" required>
<button type="submit">Update</button></form><a href="viewEmployees">Back</a></div></body></html>
