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
	<link rel="stylesheet" href="CSS/alumnet_styling.css" type="text/css"/>
</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	
		<h1 id="header">
	    <a href = "JSP/index.jsp"><img src="Images/logo.png" alt="" id="logo"/></a>
	</h1>
    
	
    <!--Navigation Bar-->
    <div class = "nav">
	<a href = "JSP/index.jsp">Home</a>&nbsp;
	    <div class="dropdown">
		<button class="dropbtn">Colleges</button>
		    <div class="dropdown-content">
			<a href="JSP/ceit.jsp">CoEIT</a>
			<a href="JSP/coba.jsp">CoBA</a>
			<a href="JSP/class.jsp">CLASS</a>
			<a href="JSP/chhs.jsp">CHHS</a>
			<a href="JSP/cosm.jsp">CoSM</a>
			<a href="JSP/coe.jsp">CoE</a>
			<a href="JSP/coph.jsp">CoPH</a>
		    </div>
	    </div>&nbsp;
	<a href = "JSP/about.jsp">About AlumNet</a>&nbsp;
	    <div class="dropdown">
		<button class="dropbtn" id="account">My Account</button>
		    <div class="dropdown-content">	
			<a href = "JSP/login.jsp">Login</a>
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
			<s:property value="#session.user.firstName"/><br/><br/>
		    <label id="l2">Last Name: </label>
			<s:property value="#session.user.lastName"/><br/><br/>
		    <label id="l3">Grad Year: </label>
			<s:property value="#session.user.graduationDate"/><br/><br/>
		    <label id="l5">Company: </label>
			<s:property value="#session.user.company"/><br/><br/>
		    <label id="l6">Job Title: </label>
			<s:property value="#session.user.jobTitle"/><br/><br/>
		    <label id="l7">Job Field: </label>
			<s:property value="#session.user.jobField"/><br/><br/>
		    <label id="l8">Email: </label>
			<s:property value="#session.user.email"/><br/><br/>
		    <label id="l9">Password: </label>
			<s:property value="#session.user.password"/><br/><br/>
		</s:div>	
		
		
		

	</s:form>
	
	
	</main>
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
