<?xml version="1.0" encoding="ISO-8859-1" ?>
<?xml-stylesheet type="text/xsl" href="../CSS/copy.xsl"?>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>
	    AlumNet::Alum Account
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
						<s:a href="ceit.jsp">CoEIT</s:a>
						<s:a href="coba.jsp">CoBA</s:a>
						<s:a href="class.jsp">CLASS</s:a>
						<s:a href="chhs.jsp">CHHS</s:a>
						<s:a href="cosm.jsp">CoSM</s:a>
						<s:a href="coe.jsp">CoE</s:a>
						<s:a href="coph.jsp">CoPH</s:a>
					</s:div>
			</s:div>&nbsp;
			<s:a href = "about.jsp">About AlumNet</s:a>&nbsp;
			
			<s:div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
					<s:div class="dropdown-content">	
						<s:a href = "login.jsp" action="setupRegistration">Login</s:a>
						<a href="<s:url action="setupRegistration"/>">Register</a>					</s:div>
			</s:div>&nbsp;
	</s:div>

	<main>
	<!--Main content of page!-->
	<br/>
	<br/>
	<br/>
	
	<s:form namespace="/" theme="simple" id="reg" ><!--The actionChange() function switches the onclick action depending on whether the user clicks Alum or Student. Function found in the login.js file -->
			
		<!-- ****************** ALUM **************
		*********************** Mapped action:  -->
		<s:div id="ifAlum" cssStyle="border: 1px solid;">
		    <br/>
		    <label id="l1">First Name: </label>
			<s:property value="alumnus.firstName"/><br/><br/>
		    <label id="l2">Last Name: </label>
			<s:property value="alumnus.lastName"/><br/><br/>
		    <label id="l3">Grad Year: </label>
			<s:property value="alumnus.graduationDate"/><br/><br/>
		    <label id="l5">Company: </label>
			<s:property value="alumnus.company"/><br/><br/>
		    <label id="l6">Job Title: </label>
			<s:property value="alumnus.jobTitle"/><br/><br/>
		    <label id="l7">Job Field: </label>
			<s:property value="alumnus.jobField"/><br/><br/>
		    <label id="l8">Email: </label>
			<s:property value="alumnus.email"/><br/><br/>
		    <label id="l9">Password: </label>
			<s:property value="alumnus.password"/><br/><br/>
		</s:div>	
		
		
		

	</s:form>
	
	
	</main>
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
