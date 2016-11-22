<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
		<title>
			AlumNet
		</title>
				<LINK rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css">
				<script type="text/javascript" src="../JS/login.js"></script>
</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	<header>
		<h1>
		    <a href = "index.jsp"><img src="../Images/logo.png" alt="logo" id="logo"/></a>
		</h1>
        </header>
	
	<!--Navigation Bar-->
	<ul class = "nav">
		<li><a href = "index.jsp">Home</a></li>&nbsp;
			<div class="dropdown">
				<button class="dropbtn" id="college">Colleges</button>
					<div class="dropdown-content">
						<a href="colleges/ceit.jsp" id="1">CoEIT</a>
						<a href="colleges/coba.jsp" id="2">CoBA</a>
						<a href="colleges/class.jsp" id="3">CLASS</a>
						<a href="colleges/chhs.jsp" id="4">CHHS</a>
						<a href="colleges/cosm.jsp" id="5">CoSM</a>
						<a href="colleges/coe.jsp" id="6">CoE</a>
						<a href="colleges/coph.jsp" id="7">CoPH</a>
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

	<main>
	<!--Main content of page!-->
		
		
		<br>
		<h2 id="u_e">
			Here are upcoming Alumni related events on campus!
			
		</h2>
		
		<br>
		<br>
		
		<div id = "upcoming"><!--Got this from GSU website!-->
		<script type="text/javascript" src="http://calendar.georgiasouthern.edu/widget/combo?schools=georgia&types=88966&days=60&num=25&match=all&show_types=0&target_blank=1&template=modern"></script>
		<div id="lclst_widget_footer">
		    <a rel="nofollow" style="margin-left:auto;margin-right:auto;display:block;width:81px;margin-top:10px;"></a>
		</div>
		
		</div>
		
	</main>
	
	<!-- **This is to enable the "Top of Page" button to be centered on page!** -->
	<div class="topper">
		<a href = "#top">Top of Page<br></a>
		<a href ="https://securelb.imodules.com/s/1544/index.aspx?sid=1544&gid=1&pgid=463&cid=1157" target="_blank">Make a gift to GSU!</a>
	</div>
	</div>
	<footer>
		AlumNet<sub>&copy;</sub> 2016
	</footer>
</body>
</html>
