<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<User> users =(List<User>)request.getAttribute("users"); %>
<!DOCTYPE HTML>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
  <style type="text/css">
  	
  	#header{
  		margin:auto;
        float:left;
        width: 100%;
        font-family:Arial, Helvetica, sans-serif;
        background-color: #000000;
  	}
      ul, ol {
        list-style: none;
      }
      .nav li a {
          
          background-color: #000;
          color: #FFF;
          text-decoration: none;
          padding: 10px 15px;
          display: block;
      }
      .nav li a:hover{
          background-color: #434343;
          color: #DDDDDD;
      }
      .nav >li {
          float: left;
      }
      #container{
          margin: auto;
          float: left;
          width: 100%;
          height: 100%;
          border: 8px;
          border-color: aqua;
          
      }
      td, tr{
      	  padding: 10px 10px;
      }
  
  </style>	
  </head>

  <body>
  <div id="header">
  	<ul class="nav">
  		<li><a href="/roles">Roles</a></li>
  		<li><a href="/users">Users</a></li>
  		<li><a href="/resources">Resources</a></li>
  		<li><a href="/access">Access</a></li>
  		<li><a href="/seminaries">Seminaries</a></li>
  		<li><a href="/users/login">Login</a></li>
  		<li><a href="/users/logout">Logout</a></li>
  
  	</ul>
  
  </div>
  <div id="container">
  	<table width="100%">
  	<tr>
  		<td width="30%">
  			<h2>Actions</h2>
  			<a href="/users/add">Crear nuevo usuario</a>
  		</td>
  		
  		<td>
  			<% if (users.size() > 0) { %>
			<span class="heading">Usuarios Registrados: <%= users.size() %> </span>
			
			<table>
				<tr>
					<td>Id</td>
					<td>Email</td>
					<td>Rol</td>
					<td>Birth</td>
					<td>Gender</td>
					<td>Status</td>
					<td>Created</td>
				
				</tr>
					<% for (int i = 0;i<users.size();i++) { %>
					<% User u = (User)users.get(i); %>
					<tr style="background:#ffffff"onMouseOver="this.style.background='#eeeeee';"onMouseOut="this.style.background='#ffffff';">
					<td><%= u.getId() %></td>
					<td><%= u.getEmail() %></td>
					<td><%= u.getRolID() %></td>
					<td><%= u.getBirth() %></td>
					<td><%= u.getGender() %></td>
					<td><%= u.getStatus() %></td>
					<td><%= u.getDate() %></td>
					<td><a href="/users/recover?userID=<%=u.getId() %>">Editar</a></td>
					<td><a href="/users/delete?userID=<%=u.getId() %>">Eliminar</a></td>
				</tr>
					<% } %>
			</table>
			<% } else { %>
			<span class="heading">No hay usuarios registrados</span>
			<% } %>
  		
  		</td>
  	</tr>
  	</table>
  </div>
   
  </body>
</html>