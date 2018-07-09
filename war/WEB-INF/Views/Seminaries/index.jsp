<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<Seminary> seminaries =(List<Seminary>)request.getAttribute("seminaries"); %>
<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Seminarios</title>
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
  			<a href="/seminaries/add">Programar nuevo seminario</a>
  		</td>
  		
  		<td>
  			<% if (seminaries.size() > 0) { %>
			<span class="heading">Seminarios Programados: <%= seminaries.size() %> </span>
			<p/>
			<table>
				<tr>
					<td>Curso</td>
					<td>Profesor a cargo</td>
					<td>Aula</td>
					<td>Fecha</td>
					<td>Hora</td>
				
				</tr>
					<% for (int i = 0;i<seminaries.size();i++) { %>
					<% Seminary s = (Seminary)seminaries.get(i); %>
					<tr style="background:#ffffff"onMouseOver="this.style.background='#eeeeee';"onMouseOut="this.style.background='#ffffff';">
					<td><%= s.getCourse() %></td>
					<td><%= s.getTeacher() %></td>
					<td><%= s.getClassroom() %></td>
					<td><%= s.getDate() %></td>
					<td><%= s.getHour() %></td>
					<td><a href="/seminaries/view?seminaryID=<%=s.getId() %>">Ver</a></td>
					<td><a href="/seminaries/recover?seminaryID=<%=s.getId() %>">Editar</a></td>
					<td><a href="/seminaries/delete?seminaryID=<%=s.getId() %>">Eliminar</a></td>
				</tr>
					<% } %>
			</table>
			<% } else { %>
			<span class="heading">No hay Seminarios programados</span>
			<% } %>
  		
  		</td>
  	</tr>
  	</table>
  </div>
   
  </body>
</html>