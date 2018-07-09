<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="model.entity.*"%>
<% Access vista =(Access)request.getAttribute("vista"); %>
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
  			<table>
  				<tr style="background:#ffffff"onMouseOver="this.style.background='#eeeeee';"onMouseOut="this.style.background='#ffffff';">
  					<td>Id:</td>
  					<td><%= vista.getId() %></td>
  				</tr>
  				<tr style="background:#ffffff"onMouseOver="this.style.background='#eeeeee';"onMouseOut="this.style.background='#ffffff';">
  					<td>Rol:</td>
  					<td><%= vista.getRol() %></td>
  				</tr>
  				<tr style="background:#ffffff"onMouseOver="this.style.background='#eeeeee';"onMouseOut="this.style.background='#ffffff';">
  					<td>Resource:</td>
  					<td><%= vista.getResource() %></td>
  				</tr>
  				<tr style="background:#ffffff"onMouseOver="this.style.background='#eeeeee';"onMouseOut="this.style.background='#ffffff';">
  					<td>Status:</td>
  					<td><%= vista.getStatus() %></td>
  				</tr>
  				<tr style="background:#ffffff"onMouseOver="this.style.background='#eeeeee';"onMouseOut="this.style.background='#ffffff';">
  					<td>Created:</td>
  					<td><%= vista.getDate() %></td>
  				</tr>
  				
  			</table>
  		
  		</td>	
				
  	</table>
  </div>
   
  </body>
</html>