<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html><html><head><title>Admin Login</title><link rel="stylesheet" href="css/style.css"></head>
<body><div class="container small"><h1>Employee Management</h1><h2>Admin Login</h2>
<p class="error">${error}</p>
<form action="login" method="post">
<label>Username</label><input type="text" name="username" required>
<label>Password</label><input type="password" name="password" required>
<button type="submit">Login</button></form>
<p class="muted">Demo: admin / admin123</p></div></body></html>
