<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>
	    AlumNet
	</title>
				<link rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
				<script type="text/javascript" src="../JS/login.js"></script>
</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	
		<h1 id="header">
		    <s:a href = "index.jsp"><img src="../Images/logo.png" alt="logo" id="logo"/></s:a>
		</h1>
        
	
	<!--Navigation Bar-->
	<s:div class = "nav">
		<s:a href = "index.jsp">Home</s:a>&nbsp;
			<s:div class="dropdown">
				<button class="dropbtn" id="college">Colleges</button>
					<s:div class="dropdown-content">
						<s:a href="colleges/ceit.jsp">CoEIT</s:a>
						<s:a href="colleges/coba.jsp">CoBA</s:a>
						<s:a href="colleges/class.jsp">CLASS</s:a>
						<s:a href="colleges/chhs.jsp">CHHS</s:a>
						<s:a href="colleges/cosm.jsp">CoSM</s:a>
						<s:a href="colleges/coe.jsp">CoE</s:a>
						<s:a href="colleges/coph.jsp">CoPH</s:a>
					</s:div>
			</s:div>&nbsp;
			<s:a href = "about.jsp">About AlumNet</s:a>&nbsp;
			
			<s:div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
					<s:div class="dropdown-content">	
						<s:a href = "login.jsp" action="setupRegistration">Login</s:a>
						<s:a href = "register.jsp" action="setupRegistration">Register</s:a>
						<s:form action="setupRegistration">
						    <s:submit type="submit" value="Register"/> 
						</s:form>
					</s:div>
			</s:div>&nbsp;
	</s:div>

	<main>
	<!--Main content of page!-->
	

			
		<br/>
		<h2 id="u_e">
			Here are upcoming Alumni related events on campus!
			
		</h2>
		
		<br/>
		<br/>
		
		<div id = "upcoming"><!--Got this from GSU website!-->
		<script type="text/javascript" src="http://calendar.georgiasouthern.edu/widget/combo?schools=georgia&types=88966&days=60&num=25&match=all&show_types=0&target_blank=1&template=modern"></script>
		<div id="lclst_widget_footer">
		    <a rel="nofollow" style="margin-left:auto;margin-right:auto;display:block;width:81px;margin-top:10px;"></a>
		</div>
		
		</div>
		
	</main>
	
	<!-- **This is to enable the "Top of Page" button to be centered on page!** -->
	<div class="topper">
		<a href = "#top">Top of Page<br/></a>
		
	</div>
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
