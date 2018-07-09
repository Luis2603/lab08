<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<Rol> roles =(List<Rol>)request.getAttribute("roles"); %>
<% String []meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"}; %>
<% User editable = (User) request.getAttribute("usuarioparaeditar"); %>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Creando Nuevo Usuario</title>
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
  					<a href="/users">Lista de Usuarios</a>
				</td>
  				<td>

					
	
				</td>
			</tr>
			<tr>
				<td>
					
				</td>	
				<td>
					<% if(!roles.isEmpty()){ %>
					<form method="post" action="/users/edit">
				
					<table border="0">
						<tr>
							<td>Email:</td>
							<td colspan="3">
							<input type="hidden" name="userId" value="<%= editable.getId() %>">
							<input type="text" width="100%" name="email" value=<%= editable.getEmail() %>>
							</td>
						</tr>
						<tr>
							<td>Rol</td>
							<td colspan="3">
								<select name="rol">
								<% for(Rol r : roles){%>
									<option value="<%= r.getId() %>"><%= r.getName() %></option>
								<%} %>
								</select>
							</td>
						</tr>
						<tr>
							<td>Birth</td>
							<td>
								<select name="day">
								<% for(int contador = 1; contador<=31;contador++){ %>
									<option value="<%= contador %>"><%= contador %></option>
								<%} %>
								</select>
							</td>
							<td>
								<select name="month">
								<% for(int contador = 0; contador<=11;contador++){%>
									<option value="<%= meses[contador]%>"><%= meses[contador] %></option>
								<%} %>
								</select>
							</td>
							<td>
								<select name="year">
								<% for(int contador = 0; contador<=31;contador++){%>
									<option value="<%= 1985+contador%>"><%= 1985+contador%></option>
								<%} %>
								</select>
							</td>
						</tr>
						<tr>
							<td>Status
							</td>
							<td colspan="3">
								<% if(editable.getStatus()){%>	
									<select name="status">
										<option value="true" selected>True</option>
										<option value="false">False</option>
									</select>
								<% }else{%>
									<select name="status">
										<option value="true" >True</option>
										<option value="false" selected>False</option>
									</select>
								<%} %>
							</td>
						</tr>
						
						<tr>
							<td colspan="4">
								<input type="submit" value="Actualizar">
							</td>
						</tr>
						
					</table>
					</form>
					<% }else{%>
						<h3>No hay roles creados, primero cree uno para poder continuar</h3>
					<% } %>
				
				</td>
			</tr>
	</table>
	</div>

</body>
</html>