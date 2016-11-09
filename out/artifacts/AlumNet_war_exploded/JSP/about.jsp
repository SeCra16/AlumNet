<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
		<title>
			AlumNet
		</title>
				<LINK rel="stylesheet" href="alumnet_styling.css" type="text/css">
</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
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
						<li><a href = "../../../../Downloads/AlumNet%20v2.1/register.html">Register</a></li>
					</div>
				</div>&nbsp;
	</ul>

	<main>
	<!--Main content of page!-->
		
		<br>
		<p id="about">
			About AlumNet<sub>&copy;</sub>
		</p>
		<p id="about_info">
			<div id="center">
				<em>AlumNet is currently a work-in-progress</em>
			</div>
			<hr>
			AlumNet is a site for Georgia Southern Alumni and current Georgia Southern Students to connect with each other and network. Features will be implemented as the development process continues.
		</p>
		<br>
		<p id = "origin">
			The idea behind AlumNet was given to Sebastian at a CASE conference in Atlanta, GA in the Summer of 2016. Ohio State University was giving a presentation about a Pen Pal program between Alum and current students. The OSU had given a great interest in the budding program, with over 200 signing up. However, due to it being the first time, the OSU Alumni Relations group were using a spreadsheet to fill in and save the data for everybody. They expressed interest in streamlining the process using a program written specifically for their needs, and as a Computer Science major, Sebastian had a general idea on how to use it for his own university, Georgia Southern. Sebastian, alongside his Software Engineering course team members, Evan, Nick, and Josh, began their work on AlumNet with the help of Alex, the person that allowed for all of this to happen.
		</p>
				
	</main>
	
	<!-- **This is to enable the "Top of Page" button to be centered on page!** -->
	<div class="topper">
		<a href = "#top">Top of Page<br></a>
	</div>
	</div>
	<footer>
		AlumNet<sub>&copy;</sub> 2016
	</footer>
</body>
</html>
