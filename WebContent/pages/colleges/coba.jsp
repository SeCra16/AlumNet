<!-- Very basic looking and I mean basic -->

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
		<title>
			AlumNet
		</title>
				<LINK rel="stylesheet" href="../../CSS/alumnet_college.css" type="text/css">

</head>
<body>	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	<header>
		<h1>
			<a href = "../index.jsp">AlumNet</a>
		</h1>
	</header>
	
		<!--Navigation Bar-->
	<ul class = "nav">
		<li><a href = "../index.jsp">Home</a></li>&nbsp;
			<div class="dropdown">
				<button class="dropbtn">Colleges</button>
					<div class="dropdown-content">
						<a href="ceit.jsp" id="1">CoEIT</a>
						<a href="coba.jsp" id="2">CoBA</a>
						<a href="class.jsp" id="3">CLASS</a>
						<a href="chhs.jsp" id="4">CHHS</a>
						<a href="cosm.jsp" id="5">CoSM</a>
						<a href="coe.jsp" id="6">CoE</a>
						<a href="coph.jsp" id="7">CoPH</a>
					</div>
				</div>&nbsp;
			<li><a href = "../about.jsp">About AlumNet</a></li>&nbsp;
			
			<div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
					<div class="dropdown-content">	
						<li><a href = "../login.jsp">Login</a></li>
						<li><a href = "../register.jsp">Register</a></li>
					</div>
				</div>&nbsp;
	</ul>
	
	
	<main>
		<h2 id="college_name">
			College of Business Administration
		</h2>
		
		<br>
		<br>
		
		
		
	</main>
</body>
</html>