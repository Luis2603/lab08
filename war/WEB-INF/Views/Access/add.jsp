<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<Resource> resources =(List<Resource>)request.getAttribute("resources"); %>
<% List<Rol> roles =(List<Rol>)request.getAttribute("roles"); %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Creando Nuevo rol</title>
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
  		<li><a href="/users/logout" >Logout</a></li>
  
  	</ul>
  
  </div>
	<div id="container">
		<table width="100%">
			<tr>
  				<td width="30%">
  					<h2>Actions</h2>
  					<a href="/resources">Lista de Recursos</a>
				</td>
  				<td>

					
	
				</td>
			</tr>
			<tr>
				<td>
					
				</td>	
				<td>
					<% if((!roles.isEmpty())&&(!resources.isEmpty())){ %>
					<form method="post" action="/access/add">
				
					<table border="0">
						<tr>
							<td>Rol</td>
							<td>
								<select name="rol">
								<% for(Rol r : roles){%>
									<option value="<%= r.getId() %>"><%= r.getName() %></option>
								<%} %>
								</select>
							
							</td>
						</tr>
							<td>Recurso</td>
							<td>
								<select name="recurso">
								<% for(Resource re: resources){%>
									<option value="<%= re.getId() %>"><%= re.getName() %></option>
								<%} %>
								</select>
							</td>
							
						<tr>
						</tr>
						<tr>
							<td>
							<input type="submit" value="Crear Acceso">
							</td>
						</tr>
					</table>
					</form>
					<%}if((!roles.isEmpty())&&resources.isEmpty()){ %>
						<h2>No hay recursos creados</h2>
					<%}if((roles.isEmpty())&&(!resources.isEmpty())){ %>
						<h2>No hay roles creados</h2>
					<%}if(roles.isEmpty()&&resources.isEmpty()){ %>
						<h2>No hay roles ni recursos creados</h2>
					<%} %>
				</td>
			</tr>
	</table>
	</div>

</body>
</html>