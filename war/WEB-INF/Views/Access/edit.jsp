<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="model.entity.*"%>
<%  Access editable = (Access)request.getAttribute("accesoparaeditar");%>


<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Access ID : <%= editable.getId() %></title>
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
  					<a href="/access">Lista de Accesos</a>
				</td>
  				<td>
	
				</td>
			</tr>
			<tr>
				<td>
					
				</td>	
				<td>
					<form method="post" action="/access/edit">
					
					<table border="0">
					
						<tr>
							<td colspan="2"><input type="hidden" name ="accessId" value="<%= editable.getId() %>"></td>
						</tr>
						<tr>
							<td>Rol</td>
							<td><%= editable.getRol() %></td>
						</tr>
						<tr>
							<td>Recurso</td>
							<td><%= editable.getResource() %></td>
						</tr>
						<tr>
							<td>Status</td>
							<td>
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
							<td colspan="2"><input type="submit" value="Actualizar"></td>
						</tr>
					</table>
					</form>
				
				</td>
			</tr>
	</table>
	</div>

</body>
</html>