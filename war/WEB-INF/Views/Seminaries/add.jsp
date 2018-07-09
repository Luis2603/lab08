<%@ page language="java" pageEncoding="UTF-8" session="false"%>



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
					<form method="post" action="/seminaries/add">
				
					<table border="0">
						<tr>
							<td>Curso:</td>
							<td><select name="course">
								  <option value="Matematica Básica">Matemática Basica</option>
								  <option value="Fisica I">Física I</option>
								  <option value="Fisica II">Física II</option>
								  <option value="Fisica III">Física III</option>
								  <option value="Química I">Química I</option>
								  <option value="Química II">Química II</option>
								  <option value="Química III">Química III</option>
								  <option value="Biologia I">Biologia I</option>
								  <option value="Biologia II">Biologia II</option>
								  <option value="Constitución">Constitución</option>
								  <option value="Trigonometria">Trigonometria</option>
								  <option value="Historia">Historia</option>
								  <option value="Psicotecnico">Psicotecnico</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Profesor a cargo:</td>
							<td><input type="text" name="teacher" required></td>
						</tr>
						<tr>
							<td>Aula:</td>
							<td><input type="text" name="classroom" required></td>
						</tr>
						<tr>
							<td>Fecha:</td>
							<td><input type="text" name="date"></td>
						</tr>
						<tr>
							<td>Hora:</td>
							<td><select name="hour">
								<option value="1:00pm - 3:00pm">1:00pm - 3:00pm</option>
								<option value="2:00pm - 4:00pm">2:00pm - 4:00pm</option>
								<option value="3:00pm - 5:00pm">3:00pm - 5:00pm</option>
								<option value="4:00pm - 6:00pm">4:00pm - 6:00pm</option>
								<option value="5:00pm - 7:00pm">5:00pm - 7:00pm</option>
								<option value="6:00pm - 8:00pm">6:00pm - 8:00pm</option>
								</select>
							</td>
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