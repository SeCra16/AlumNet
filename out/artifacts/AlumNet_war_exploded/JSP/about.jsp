<?xml version="1.0" encoding="ISO-8859-1" ?>
<?xml-stylesheet type="text/xsl" href="../CSS/copy.xsl"?>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@taglib prefix="s" uri="/struts-tags" %>
<head>
	<title>
	    AlumNet
	</title>
	    <LINK rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
		<h1 id="header">
	    <a href = "index.jsp"><img src="../Images/logo.png" alt="logo" id="logo"/></a>
		</h1>
		
		
		    <s:if test= "%{#session.type == 'student'}" >
			<h4>User: <s:property value="#session.user.firstName"/> <s:property value="#session.user.lastName"/></h4>
		    </s:if>
		    <s:elseif test= "%{#session.type == 'alumnus'}" >
			<h4>User: <s:property value="#session.user.firstName"/> <s:property value="#session.user.lastName"/></h4>
		    </s:elseif>

	
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
			
			<s:div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
				
				<s:if test= "%{#session.type == 'student'}" >
				    <s:div class="dropdown-content">	
					    <a href="account_student.jsp">My Student Account</a>
				    </s:div>
				</s:if>
				
				<s:elseif test= "%{#session.type == 'alumnus'}" >
				    <s:div class="dropdown-content">
					<a href="account_alum.jsp">My Alum Account</a>
				    </s:div>
				</s:elseif>
					
				<s:else>
				    <div class="dropdown-content">	
					<a href = "login.jsp">Login</a>
					<a href="<s:url action="setupRegistration" namespace="/JSP" />">Register</a>
				    </div>    
				</s:else>
				
			</s:div>&nbsp;
	</div>

	<div id="main">
	<!--Main content of page!-->
		
		<br/>
		<p id="about">
			About AlumNet<sub>&copy;</sub>
		</p>
		<div id="about_info">
			<div id="center">
				<em>AlumNet is currently a work-in-progress</em>
			</div>
			<hr/>
		    AlumNet is a site for Georgia Southern Alumni and current Georgia Southern Students to connect with each other and network. Features will be implemented as the development process continues.
		</div>
		<br/>
		<p id = "origin" >
			The idea behind AlumNet was given to Sebastian at a CASE conference in Atlanta, GA in the Summer of 2016. Ohio State University was giving a presentation about a Pen Pal program between Alum and current students. The OSU had given a great interest in the budding program, with over 200 signing up. However, due to it being the first time, the OSU Alumni Relations group were using a spreadsheet to fill in and save the data for everybody. They expressed interest in streamlining the process using a program written specifically for their needs, and as a Computer Science major, Sebastian had a general idea on how to use it for his own university, Georgia Southern. Sebastian, alongside his Software Engineering course team members, Evan, Nick, and Josh, began their work on AlumNet with the help of Alex, the person that allowed for all of this to happen.
		</p>
				
	</div>
	
	<!-- **This is to enable the "Top of Page" button to be centered on page!** -->
	<div class="topper">
		<a href = "#top">Top of Page<br/></a>
		<a href ="https://securelb.imodules.com/s/1544/index.aspx?sid=1544&gid=1&pgid=463&cid=1157" target="_blank">Make a gift to GSU!</a>
	</div>
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
