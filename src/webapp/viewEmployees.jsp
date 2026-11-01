<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ems.model.Employee" %>
<% if (session.getAttribute("admin") == null) { response.sendRedirect("login.jsp"); return; }
Employee[] employees = (Employee[]) request.getAttribute("employees"); %>
<!DOCTYPE html><html><head><title>Employees</title><link rel="stylesheet" href="css/style.css"></head>
<body><div class="container wide"><div class="top"><h1>Employee List</h1><a href="dashboard.jsp">Dashboard</a></div>
<table><tr><th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Salary</th><th>Actions</th></tr>
<% if (employees != null) for (Employee e : employees) { if (e != null) { %>
<tr><td><%= e.getId() %></td><td><%= e.getName() %></td><td><%= e.getEmail() %></td>
<td><%= e.getDepartment() %></td><td><%= e.getSalary() %></td>
<td><a href="updateEmployee?id=<%= e.getId() %>">Edit</a> |
<a href="deleteEmployee?id=<%= e.getId() %>" onclick="return confirm('Delete this employee?')">Delete</a></td></tr>
<% } } %></table></div></body></html>
