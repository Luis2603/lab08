<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<Access> accesos =(List<Access>)request.getAttribute("accesos"); %>
<!DOCTYPE HTML>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accesos</title>
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
      	  padding: 20px 10px;
      }
  
  </style>	
  </head>

  <body>
  <div id="header">
  	<ul class="nav">
  		<li><a href="/roles">Roles</a></li>
  		<li><a href="/users" target="container">Users</a></li>
  		<li><a href="/resources" target="container">Resources</a></li>
  		<li><a href="/access" target="container">Access</a></li>
  		<li><a href="/seminaries">Seminaries</a></li>
  		<li><a href="/users/login" target="container">Login</a></li>
  		<li><a href="/users/logout" target="container">Logout</a></li>
  
  	</ul>
  
  </div>
  <div id="container">
  <table>
  		<tr>
  			<td>
	  			<h2>Actions</h2>
	  			<a href="/access/add">Crear nuevo acceso</a>
	  		</td>
	  		<td>
	  			<% if (accesos.size() > 0) { %>
				<table>
					<tr>
						<td>Id</td>
						<td>Rol</td>
						<td>Resource</td>
						<td>Status</td>
						<td>Created</td>
						
					
					</tr>
						<% for (int i = 0;i<accesos.size();i++) { %>
						<% Access a1 = (Access)accesos.get(i); %>
						<tr style="background:#ffffff"onMouseOver="this.style.background='#eeeeee';"onMouseOut="this.style.background='#ffffff';">
						<td><%= a1.getId() %></td>
						<td><%= a1.getRol() %> </td>
						<td><%= a1.getResource() %> </td>
						<td><%= a1.getStatus() %></td>
						<td><%= a1.getDate() %></td>
						
						<td><a href="/access/view?accessID=<%=a1.getId() %>">Ver</a></td>
						<td><a href="/access/recover?accessID=<%=a1.getId() %>">Editar</a></td>
						<td><a href="/access/delete?accessID=<%=a1.getId() %>">Eliminar</a></td>
					</tr>
						<% } %>
				</table>
				<% } else { %>
				<span class="heading">No hay ningun acceso creado</span>
				<% } %>
	  			
	  		</td>	
  		</tr>
  	</table>
  </div>
   
  </body>
</html>