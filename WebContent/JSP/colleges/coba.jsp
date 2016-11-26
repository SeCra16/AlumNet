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
<link rel="stylesheet" href="../../CSS/alumnet_college.css" type="text/css"/>

</head>
<body>	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	
		<h1 id="header">
		    <a href = "../index.jsp"><img src="../../Images/logo.png" alt="logo" id="logo"/></a>
		</h1>
	
	
		<!--Navigation Bar-->
	<div class = "nav">
		<a href = "../index.jsp">Home</a>&nbsp;
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
			<a href = "../about.jsp">About AlumNet</a>&nbsp;
			
			<div class="dropdown">
				<button class="dropbtn" id="account">My Account</button>
					<div class="dropdown-content">	
						<a href = "../login.jsp">Login</a>
						<a href = "../register.jsp">Register</a>
					</div>
				</div>&nbsp;
	</div>
	
	
	<div id="main">
            <h2 id = "college_name">
			College of Business Administration
		</h2>
		
		<br/>
		 <p>
                The College of Business seeks to develop and promote a learning environment of the highest quality, 
                characterized by inspired teaching and informed by meaningful research. Consistent with the traditions and mission of Georgia Southern University, 
                the College of Business offers a broad array of undergraduate programs and select graduate programs.
                The College of Business began offering the BBA degree during 1965, the MBA degree during 1969, Online MBA program in 2001, 
                the MAcc degree in 1988 and MSAE degree in 2007.
            </p>
            <h3><a href="http://coba.georgiasouthern.edu/soa/"> School of Accountancy</a></h3>
            <p>
                The School of Accountancy at Georgia Southern University is fully accredited by AACSB International,
                and offers both undergraduate and graduate degree programs in Accounting.
            </p>
            <h3><a href="http://coba.georgiasouthern.edu/dfe/"> Department of Finance and Economics</a></h3>
            <p>
                The Department of Finance and Economics offers B.B.A. degrees in economics, regional economic development, finance, and international business and a B.A. and minors in economics and regional economic development for non-business majors. 
                DFE also offers a Master of Science in Applied Economics.
            </p>
            <h3><a href="http://coba.georgiasouthern.edu/mgnt/"> Department of Management</a></h3>
            <p>
                The Department of Management primary degree offering is the B.B.A. degree in Management. 
                The department also houses a specialty emphasis area for the Management degree, the B.B.A. degree in Management with an emphasis in Operations Management.
            </p>
            <h3><a href="http://coba.georgiasouthern.edu/is/"> Department of Information Systems</a></h3>
            <p>
                Information Systems (IS) is first and foremost a business degree. This degree program prepares graduates to increase business agility and competitiveness through the application of Information Technology (IT). 
                IS students gain a solid foundation in business and become computer-savvy through hands-on experience with the latest technologies.
            </p>
            <h3><a href="http://coba.georgiasouthern.edu/lscm/"> Department of Logistics & Supply Chain Management</a></h3>
            <p>
                The Department of Logistics and Supply Chain Management  offers a bachelor of business administration (BBA) degrees majoring in logistics and intermodal transportation as well as a major in management with an emphasis in operations management.
            </p>
            <h3><a href="http://coba.georgiasouthern.edu/mktg/"> Department of Marketing</a></h3>
            <p>
                The Department of Marketing offers Bachelor of Business Administration (BBA) degrees in the areas of marketing. Our degree programs provide students with the problem-solving skills and versatile knowledge base needed to manage and lead the modern organization.
            </p>
		<br/>
		<br/>
		
		<script type="text/javascript" src="http://x0jkf782cm.embed.talkiforum.com/embed/1.js"></script><div style="font-size:80%; text-align:center;" id="x0jkf782cmt4lk1prm0">Hosted by <a href="http://talkiforum.com?utm_source=install&utm_medium=link&utm_campaign=get_your_own" target="_blank">Talki</a></div>
		
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
