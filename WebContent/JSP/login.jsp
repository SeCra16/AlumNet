<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@taglib prefix="s" uri="/struts-tags" %>
<head>
    <meta charset="utf-8"/>
	<title>
	    AlumNet
	</title>
<LINK rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
<script type="text/javascript" src="../JS/login.js"></script>

</head>
<body>	
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
				<button class="dropbtn">Colleges</button>
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
	
<br/>
	<main>
	<!--Main content of page!-->

		<br/>
		<form onsubmit="submitLogin()">
			<fieldset id="login_page">
				<legend id = "login">
					Please Login!
				</legend>
				
				<label for="uname" id = "uname">Email: </label>
					<input type="email" name="uname" id="name"/><br/><br/>
				<label for="pword" id="pword">Password: </label>
					<input type="password" name="pword" id="pw"/><br/><br/>
				<label for="submit" name="submit" id="submit"></label>
					<input type="submit" name="sbutton" id="submit" value="Submit"/>			
			</fieldset>
		</form>
		<script> document.write(readCookie('USER_N'));</script>
	</main>
	
	<!-- **This is to enable the "Top of Page" button to be centered on page!** -->
	<div class="topper">
	</div>

	<footer>
		AlumNet<sub>&copy;</sub> 2016
	</footer>
</body>
</html>
