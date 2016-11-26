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
		College of Science and Mathematics
            </h2>
            <p>
                The College of Science and Mathematics prepares students in baccalaureate majors and the Master of Science programs. 
                COSM offers B. S. degrees in biology, chemistry and biochemistry, Geology and Geography, Mathematical Sciences, Military Science, and physics.
                The College also supports the University's general education program through extensive offerings in the Core Curriculum.
            </p>
            <p>
                The Department of Biology offers undergraduate degree programs leading to the B.S. or B.A. in Biology, as well as a graduate program offering the M.S. in Biology.
            </p>
            <p>
                The Department of Chemistry and Biochemistry offers four undergraduate degrees and concentrations which are certified by the American Chemical Society (ACS-Certified). 
                Students with a bachelor's degree in any area of science with interest in the Master of Physical Science in Applied Physical Science (MS-APS) will be considered for admission into the program, but degrees in Chemistry and Physics are preferred.
            </p>
            <p>
                The Department of Geology and Geography offers two undergraduate degree programs leading to the B.S. and B.A. in Geology and the B.S. and B.A. in Geography.
            </p>
            <p>
                The Department of Mathematical Sciences offers two undergraduate degrees, the B.S. with a major in Mathematics and the B.S. in Mathematics. 
                The department also offers the M.S. degree with concentrations in Mathematics and Statistics.
            </p>
            <p>
                The Department of Military Science "Eagle Battalion" has a national reputation for producing mentally and physically tough Officers, 
                fully prepared for the challenge of leading our nation's Soldiers.
            </p>
            <p>
                The Department of Physics offers a variety of studies in the fields of Physics and Astronomy leading to a B.S. in Physics or a B.A. with a Major in Physics degree. 
                Students with a bachelor's degree in any area of science with interest in the Master of Physical Science in Applied Physical Science (MS-APS) will be considered for admission into the program, but degrees in Chemistry and Physics are preferred.
            </p>
            <h3>
                Departments Within the College of Science and Mathematics
            </h3>
            <a href="http://cosm.georgiasouthern.edu/biology/">Department of Biology</a>
            <br/>
            <a href="http://cosm.georgiasouthern.edu/chemistry/">Department of Chemistry and Biochemistry</a>
            <br/>
            <a href="http://cosm.georgiasouthern.edu/geo/">Department of Geology and Geography</a>
            <br/>
            <a href="http://cosm.georgiasouthern.edu/math/">Department of Mathematical Sciences</a>
            <br/>
            <a href="http://cosm.georgiasouthern.edu/rotc/">Department of Military Science</a>
            <br/>
            <a href="http://cosm.georgiasouthern.edu/physics/">Department of Physics</a>
            <br/>
	    <br/>
		
		
		
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>