<%@ page contentType="text/html;charset=UTF-8" %>
<% if (session.getAttribute("admin") == null) { response.sendRedirect("login.jsp"); return; } %>
<!DOCTYPE html><html><head><title>Add Employee</title><link rel="stylesheet" href="css/style.css"></head>
<body><div class="container small"><h1>Add Employee</h1><p class="error"><%= request.getParameter("error") != null ? "Please check the details. Email may already exist." : "" %></p>
<form action="addEmployee" method="post">
<label>Name</label><input name="name" required maxlength="100">
<label>Email</label><input type="email" name="email" required>
<label>Department</label><input name="department" required>
<label>Salary</label><input type="number" name="salary" min="0" step="0.01" required>
<button type="submit">Save Employee</button></form><a href="dashboard.jsp">Back to Dashboard</a></div></body></html>
