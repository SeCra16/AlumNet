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
			Allen E. Paulson <br/> College of Engineering and Information Technology
	    </h2>
		
		<br/>
		<%-- Some basic information about the college --%>
                <p>
                    The Allen E.Paulson School of Engineering and Information Technology consists of three building on the main campus. The IT building opened for the 2003 fall semester. 
                    It houses the Departments of Computer Sciences, Electrical Engineering, Information Technology and Manufacturing Engineering, the administrative suite for the Dean and Associate Deans, and the College's Student Services Center.
                    The The Engineering Building was opened in 1995, and is home to the Departments of Civil Engineering & Construction Management and Mechanical Engineering. The Carruth Building was built in 1959 and has been re-purposed to serve as Georgia Southern's Engineering Research Center.
                </p>
                <p>
                    The bachelor's degree programs in Computer Sciences and Information Technology are accredited by the Computing Accreditation Commission of ABET, http://www.abet.org.   
                    The bachelor's degree program in Construction Management is accredited by the American Council for Construction Education (ACCE), http://www.acce-hq.org.  
                    The bachelor's degree programs in Civil Engineering, Electrical Engineering and Mechanical Engineering are accredited by the Engineering Accreditation Commission of ABET, http://www.abet.org.
                </p>
		<br/>
		<br/>
                <h3>
                    Departments within the Allen E. Paulson <br/> College of Engineering and Information Technology
                </h3>
                
                <a href="http://ceit.georgiasouthern.edu/cecm/">Civil Engineering & Construction Management</a>
                <br/>
                <a href="http://ceit.georgiasouthern.edu/electrical-engineering/">Electrical Engineering</a>
                <br/>
                <a href="http://ceit.georgiasouthern.edu/manufacturing-engineering/">Manufacturing Engineering</a>
                <br/>
                <a href="http://ceit.georgiasouthern.edu/mechanical-engineering/">Mechanical Engineering</a>
                <br/>
                <a href="http://ceit.georgiasouthern.edu/cs/">Computer Sciences</a>
                <br/>
                <a href="http://ceit.georgiasouthern.edu/it/">Information Systems</a>
                <br/>
                <a href="http://ceit.georgiasouthern.edu/citems/">CITEMS Research Center</a>
		<br/>
		<br/>
		<br/>
		
		<script type="text/javascript" src="http://8igf1nyldy.embed.talkiforum.com/embed/1.js"></script><div style="font-size:80%; text-align:center;" id="8igf1nyldyt4lk1prm0">Hosted by <a href="http://talkiforum.com?utm_source=install&utm_medium=link&utm_campaign=get_your_own" target="_blank">Talki</a></div>
		
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
