<%@ page contentType="text/html;charset=UTF-8" %>
<% if (session.getAttribute("admin") == null) { response.sendRedirect("login.jsp"); return; } %>
<!DOCTYPE html><html><head><title>Dashboard</title><link rel="stylesheet" href="css/style.css"></head>
<body><div class="container"><div class="top"><h1>Employee Dashboard</h1><a href="logout">Logout</a></div>
<p>Welcome, <%= session.getAttribute("admin") %>!</p>
<div class="actions"><a class="button" href="addEmployee.jsp">Add Employee</a>
<a class="button" href="viewEmployees">View Employees</a></div>
<form action="searchEmployee" method="get"><label>Search employee by ID</label>
<input type="number" name="id" min="1" required><button type="submit">Search</button></form>
</div></body></html>
