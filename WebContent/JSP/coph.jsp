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
			Jiann-Ping Hsu <br/> College of Public Health
		</h2>
		
		<br/>
		<p>
                Public Health at Georgia Southern University began in 1998 in the Department of Health and Kinesiology within the College of Health and Professional 
                Studies with the development of the Master of Public Health (M.P.H.) degree with an emphasis in Community Health Education and the Master of Health Services Administration (M.H.S.A.) degree.
                The Jiann-Ping Hsu College of Public Health (JPHCOPH) is fully accredited by the Council on Education for Public Health (CEPH).
            </p>
            <p>
                On January 14, 2004 the Board of Regents established the first School of Public Health in the University System of Georgia and named it the Jiann-Ping Hsu School of Public Health. The School was housed within the College of Health and Human Sciences. 
                The establishment of the School was made possible by a generous gift from Dr. Karl E. Peace, in memory and honor of his wife, Dr. Jiann-Ping Hsu.
            </p>
            <p>
                Currently, the Jiann-Ping Hsu College of Public Health offers the Master of Healthcare Administration (M.H.A.) and the Master of Public Health (M.P.H.) degrees, with emphasis areas in Biostatistics, Community Health, Environmental Health Sciences, Epidemiology, and Health Policy and Administration. 
                In addition, the Doctor of Public Health with program concentrations in Biostatistics, Community Health Behavior and Education, and Public Health Leadership was approved by the Board of Regents of the University System of Georgia on January 16, 2007.
            </p>
            <br/>
            <h3>Departments Within the Jiann-Ping Hsu College of Public Health</h3>
            <a href="http://jphcoph.georgiasouthern.edu/biostatistics/">Department of Biostatistics</a>
            <br/>
            <a href="http://jphcoph.georgiasouthern.edu/community-health/">Department of Community Health</a>
            <br/>
            <a href="http://jphcoph.georgiasouthern.edu/env-health/">Department of Environmental Health Sciences</a>
            <br/>
            <a href="http://jphcoph.georgiasouthern.edu/epidemiology/">Department of Epidemiology</a>
            <br/>
            <a href="http://jphcoph.georgiasouthern.edu/health-policy/">Department of Health Policy &amp; Management</a>
            <br/>
		<br/>
		
		
		
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
