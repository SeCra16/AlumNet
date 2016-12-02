<%@page import="java.io.PrintWriter"%>
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
				<link rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	
		<h1 id="header">
	    <a href = "index.jsp"><img src="Images/logo.png" alt="" id="logo"/></a>
	</h1>
    
	
    <!--Navigation Bar-->
    <div class = "nav">
	<a href = "index.jsp">Home</a>&nbsp;
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
	<a href = "about.jsp">About AlumNet</a>&nbsp;
	    <div class="dropdown">
		<button class="dropbtn" id="account">My Account</button>
		    <div class="dropdown-content">	
			<a href = "login.jsp">Login</a>
			<a href="<s:url action="setupRegistration" namespace="/JSP" />">Register</a>
		    </div>
	    </div>&nbsp;
    </div>
		    
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
			<s:property value="password"/><br/><br/>
		</s:div>	
		
		
		

	</s:form>
	
	
	</main>
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
