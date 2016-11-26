<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">

<%@taglib prefix="s" uri="/struts-tags" %>
<head>

	<title>
	    AlumNet
	</title>

<link rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
<script type="text/javascript" src="../JS/login.js"></script>

</head>
<body>	
<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
    
	<h1 id="header">
	    <a href = "index.jsp"><img src="../Images/logo.png" alt="logo" id="logo"/></a>
	</h1>
    
	
    <!--Navigation Bar-->
    <div class = "nav">
	<a href = "index.jsp">Home</a>&nbsp;
	    <div class="dropdown">
		<button class="dropbtn">Colleges</button>
		    <div class="dropdown-content">
			<a href="colleges/ceit.jsp">CoEIT</a>
			<a href="colleges/coba.jsp">CoBA</a>
			<a href="colleges/class.jsp" >CLASS</a>
			<a href="colleges/chhs.jsp" >CHHS</a>
			<a href="colleges/cosm.jsp" >CoSM</a>
			<a href="colleges/coe.jsp">CoE</a>
			<a href="colleges/coph.jsp">CoPH</a>
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
    <br/>
    <s:div id="main">
	<!--Main content of page!-->

		<br/>
		<s:form onsubmit="submitLogin()" theme="simple" >
		    <h2><s:text name="Please Login!"/></h2>
		    
		    <s:div>
			<label id="l8">Email</label>
			    <s:textfield type="email" name="email" id="Email" placeholder="jd00000@georgiasouthern.edu" /><br/><br/>
			<label id="l9">Password</label>
			    <s:password type="password" name="pword" id="pw" placeholder="*********" /><br/><br/>
			<s:submit type="submit" name="submit" value="Submit!" id="submit" />	
		    </s:div>
		</s:form>
    </s:div>
	
	<!-- **This is to enable the "Top of Page" button to be centered on page!** -->
	<div class="topper">
	</div>

	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
