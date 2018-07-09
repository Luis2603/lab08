<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="model.entity.*"%>
<%  Seminary editable=(Seminary)request.getAttribute("seminarioparaeditar");%>


<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Programando Nuevo Seminario</title>
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
  					<a href="/seminaries">Ver Seminarios Programados</a>
				</td>
  				<td>

					
	
				</td>
			</tr>
			<tr>
				<td>
					
				</td>	
				<td>
					<form method="post" action="/seminaries/edit">
				
					<table border="0">
						<tr>
							<td>Curso:</td>
							<td>
							<input type="hidden" name="semID" value="<%= editable.getId() %>">
							<input type="text" name="course"required value="<%= editable.getCourse() %>"></td>
						</tr>
						<tr>
							<td>Profesor a cargo:</td>
							<td><input type="text" name="teacher" required value="<%= editable.getTeacher() %>"></td>
						</tr>
						<tr>
							<td>Aula:</td>
							<td><input type="text" name="classroom" required value="<%= editable.getClassroom() %>"></td>
						</tr>
						<tr>
							<td>Fecha:</td>
							<td><input type="text" name="date" required value="<%= editable.getDate() %>"></td>
						</tr>
						<tr>
							<td>Hora:</td>
							<td><input type="text" name="hour" required value="<%= editable.getHour() %>"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Guardar"></td><td></td>
						</tr>
					</table>
					</form>
				
				</td>
			</tr>
	</table>
	</div>

</body>
</html>