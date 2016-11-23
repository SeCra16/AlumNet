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
				<LINK rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
				<script type="text/javascript" src="../JS/login.js"></script>
</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	
		<h1 id="header">
		    <a href = "index.jsp"><img src="../Images/logo.png" alt="logo" id="logo"/></a>
		</h1>
        
	
	<!--Navigation Bar-->
	<div class = "nav">
		<a href = "index.jsp">Home</a>&nbsp;
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
			<a href = "about.jsp">About AlumNet</a>&nbsp;
			
			<div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
					<div class="dropdown-content">	
						<a href = "login.jsp">Login</a>
						<a href = "register.jsp">Register</a>
					</div>
				</div>&nbsp;
	</div>

	<main>
	<!--Main content of page!-->
	
		<br/>
		<br/>
		<h1>
		    <strong>Thanks <s:property value="name"/> for registering!</strong>
		</h1>
	</main>

	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
