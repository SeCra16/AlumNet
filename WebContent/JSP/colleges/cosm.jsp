<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@taglib prefix="s" uri="/struts-tags" %>
<head>
	<title>
	    AlumNet
	</title>
				<LINK rel="stylesheet" href="../../CSS/alumnet_college.css" type="text/css"/>

</head>
<body>	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	
		<h1 id="header">
		    <a href = "index.jsp"><img src="../../Images/logo.png" alt="logo" id="logo"/></a>
		</h1>
	
	
		<!--Navigation Bar-->
	<div class = "nav">
		<a href = "../index.jsp">Home</a>&nbsp;
			<div class="dropdown">
				<button class="dropbtn">Colleges</button>
					<div class="dropdown-content">
						<a href="ceit.jsp">CoEIT</a>
						<a href="coba.jsp">CoBA</a>
						<a href="class.jsp">CLASS</a>
						<a href="chhs.jsp">CHHS</a>
						<a href="cosm.jsp">CoSM</a>
						<a href="coe.jsp">CoE</a>
						<a href="coph.jsp">CoPH</a>
					</div>
				</div>&nbsp;
			<a href = "../about.jsp">About AlumNet</a>&nbsp;
			
			<div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
					<div class="dropdown-content">	
						<a href = "../login.jsp">Login</a>
						<a href = "../register.jsp">Register</a>
					</div>
				</div>&nbsp;
	</div>
	
	
	<main>
		<h2 id = "college_name">
			College of Science and Mathematics
		</h2>
		
		<br/>
		<br/>

		
	</main>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
