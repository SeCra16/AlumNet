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
			College of Health and Human Sciences
		</h2>
		
		<br/>
		<p>
                The College of Health and Human Services contains the Schools of Nursing, Health and Kinesiology, and the School of Human Ecology.
            </p>
            <h3><a href="http://chhs.georgiasouthern.edu/nursing/"> The School of Nursing</a></h3>
            <p>
                The School of Nursing offers the following undergraduate nursing programs: Bachelors of Science in Nursing, LPN-BSN (Bachelors of Science in Nursing for LPNs), 
                RN-BSN (Online Bachelors of Science in Nursing for RNs). At the graduate level, a BSN to DNP with MSN opt out, Post-MSN Certificate, MSN, 
                and Doctor of Nursing Practice (DNP) are offered.
            </p>
            <h3><a href="http://chhs.georgiasouthern.edu/hk/">School of Health and Kinesiology</a></h3>
            <p>
                The School of Health and Kinesiology offers undergraduate degrees programs in Health Education and Promotion, Exercise Science, Athletic Training, 
                Nutrition and Food Science, and Sport Management. The School also offers several graduate programs of study, including online programs.
            </p>
            <h3><a href="http://chhs.georgiasouthern.edu/she/">School of Human Ecology</a></h3>
            <p>
                The School of Human Ecology offers undergraduate degree programs in Child and Family Development, 
                Fashion Merchandising and Apparel Design, Interior Design, and Recreation.
            </p>
            <br/>
		<br/>
		
		<script type="text/javascript" src="http://bq911lsllt.embed.talkiforum.com/embed/1.js"></script><div style="font-size:80%; text-align:center;" id="bq911lslltt4lk1prm0">Hosted by <a href="http://talkiforum.com?utm_source=install&utm_medium=link&utm_campaign=get_your_own" target="_blank">Talki</a></div>
		
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
