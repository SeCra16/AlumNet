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
<link rel="stylesheet" href="../CSS/alumnet_college.css" type="text/css"/>

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
						<a href="<s:url action="setupRegistration"/>">Register</a>
					</div>
				</div>&nbsp;
	</div>
	
	
	<div id="main">
            <h2 id = "college_name">
			College of Liberal Arts and Social Sciences
	    </h2>
		
		<br/>
		<p>
               The college of Liberal Arts and Social Sciences offers nearly 20 undergraduate degrees and many more concentrations from its 11 departments and five academic centers. 
               The college is accredited by the Southern Association of Colleges and Schools (SACSCOC) and also has program specific accreditations from the National Association of Schools of Art and Design,
               National Association of Schools of Music, National Council for Accreditation of Teacher Education, and the National Association of Schools of Theatre.
            </p>
            <h3>Departments within the College of Liberal Arts and Social Sciences</h3>
            <a href="http://class.georgiasouthern.edu/africana/">Center for Africana Studies</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/art/">Betty Foy Sanders Department of Art</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/commarts/">Department for Communication Arts</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/justice/">Department of Criminal Justice and Criminology</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/foreign-languages/">Department of Foreign Languages</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/history/">Department of History</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/irish/">Center for Irish Studies</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/music/">Department of Music</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/points/">Department of Political Science and International Studies</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/psychology/">Department of Psychology</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/ipns/">Institute for Public & Nonprofit Studies</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/religious/">Center for Religious Studies</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/rhri/">Rural Health Research Institute</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/gerontology/">Center for Social Gerontology</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/socianth/">Department of Sociology & Anthropology</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/wgender/">Women's and Gender Studies</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/writling/">Writing & Linguistics</a>
            <br/>
            <a href="https://class.georgiasouthern.edu/dh/">Digital Humanities</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/bgs/">General Studies</a>
            <br/>
            <a href="http://class.georgiasouthern.edu/litphi/">Literature and Philosophy</a>
            <br/>
            
		<br/>
		
		<script type="text/javascript" src="http://t58sanpu4r.embed.talkiforum.com/embed/1.js"></script><div style="font-size:80%; text-align:center;" id="t58sanpu4rt4lk1prm0">Hosted by <a href="http://talkiforum.com?utm_source=install&utm_medium=link&utm_campaign=get_your_own" target="_blank">Talki</a></div>
		
	</div>
	<div id = "footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
