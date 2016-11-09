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
				
			<li><a href = "../../../../Downloads/AlumNet%20v2.1/about.html">About AlumNet</a></li>&nbsp;
			
			<div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
					<div class="dropdown-content">	
						<li><a href = "login.jsp">Login</a></li>
						<li><a href = "../../../../Downloads/AlumNet%20v2.1/register.html">Register</a></li>
					</div>
				</div>&nbsp;
	</ul>
	
<br>
	<main>
	<!--Main content of page!-->

		<br>
		<form onsubmit="submitLogin()">
			<fieldset id="login_page">
				<legend id = "login">
					Please Login!
				</legend>
				
				<label for="uname" id = "uname">Email: </label>
					<input type="email" name="uname" id="name"><br><br>
				<label for="pword" id="pword">Password: </label>
					<input type="password" name="pword" id="pw"><br><br>
				<label for="submit" name="submit" id="submit"></label>
					<input type="submit" name="sbutton" id="submit" value="Submit">			
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
