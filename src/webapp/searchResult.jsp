<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ems.model.Employee" %>
<% if (session.getAttribute("admin") == null) { response.sendRedirect("login.jsp"); return; }
Employee e = (Employee) request.getAttribute("employee"); %>
<!DOCTYPE html><html><head><title>Search Result</title><link rel="stylesheet" href="css/style.css"></head>
<body><div class="container"><h1>Search Result</h1>
<% if (e == null) { %><p>No employee found for that ID.</p><% } else { %>
<p><b>ID:</b> <%= e.getId() %></p><p><b>Name:</b> <%= e.getName() %></p>
<p><b>Email:</b> <%= e.getEmail() %></p><p><b>Department:</b> <%= e.getDepartment() %></p>
<p><b>Salary:</b> <%= e.getSalary() %></p><% } %>
<a href="dashboard.jsp">Back to Dashboard</a></div></body></html>
