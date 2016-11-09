<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
		<title>
			AlumNet
		</title>
				<LINK rel="stylesheet" href="alumnet_styling.css" type="text/css">
				<script type="text/javascript" src="../../../../Downloads/AlumNet%20v2.1/login.js"></script>

</head>
<body>	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	<header>
		<h1>
			<a href = "index.html">AlumNet</a>
		</h1>
	</header>
	
		<!--Navigation Bar-->
	<ul class = "nav">
		<li><a href = "index.html">Home</a></li>&nbsp;
			<div class="dropdown">
				<button class="dropbtn">Colleges</button>
					<div class="dropdown-content">
						<a href="../../../../Downloads/AlumNet%20v2.1/colleges/ceit.html" id="1">CoEIT</a>
						<a href="../../../../Downloads/AlumNet%20v2.1/colleges/coba.html" id="2">CoBA</a>
						<a href="../../../../Downloads/AlumNet%20v2.1/colleges/class.html" id="3">CLASS</a>
						<a href="../../../../Downloads/AlumNet%20v2.1/colleges/chhs.html" id="4">CHHS</a>
						<a href="../../../../Downloads/AlumNet%20v2.1/colleges/cosm.html" id="5">CoSM</a>
						<a href="../../../../Downloads/AlumNet%20v2.1/colleges/coe.html" id="6">CoE</a>
						<a href="../../../../Downloads/AlumNet%20v2.1/colleges/coph.html" id="7">CoPH</a>
					</div>
				</div>&nbsp;
			<li><a href = "about.jsp">About AlumNet</a></li>&nbsp;
			
			<div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
					<div class="dropdown-content">	
						<li><a href = "login.jsp">Login</a></li>
						<li><a href = "register.jsp">Register</a></li>
					</div>
				</div>&nbsp;
	</ul>
	
<br>

	<main>
	<!--Main content of page!-->

		<br>
		<form onsubmit ="submitReg()">
			<fieldset id="register_page">
				<legend id = "register">
					Please Register!
				</legend>
				
				<label for="uname">Email: </label>
					<input type="email" name="uname" id="name" placeholder="sc06358@georgiasouthern.edu"><br>
				<label for="pword">Password: </label>
					<input type="password" name="pword" id="pw" placeholder="*********" min="8"><br>
				<label for "fname">First Name: </label>
					<input type="text" name = "fname" id="fname" placeholder="Sebastian"><br>
				<label for "lname">Last Name: </label>
					<input type="text" name="lname" id="lname" placeholder="Craige"><br>
				<label for "grad_yr">Grad Year: </label>
					<input type = "number" name="grad_yr" id="yr" placeholder="2016" min="1970"><br>
				<label for "college">College: </label>
					<select name="college" id="college" placeholder="Engineering and IT">
							<option value="ceit">College of Engineering and Information Tech</option>
						</select><br>
				<label for "major">Major: </label>
					<input type="text" name="major" id="major" placeholder="Computer Science"><br>
					
				<label for="submit"></label>
					<input type="submit" name="sbutton" value="Submit" id="submit">
							
			</fieldset>
		</form>
	</main>
	
	<!-- **This is to enable the "Top of Page" button to be centered on page!** -->
	<div class="topper">
	</div>
	</div>
	<footer>
		AlumNet<sub>&copy;</sub> 2016
	</footer>
</body>
</html>
