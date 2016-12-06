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
<link rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css" />

</head>
<body>	
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
            <h2 id = "college_name">
			College of Education
		</h2>
		
		<br/>
		 <p>
                The bachelor's degree in education is the oldest professional degree at Georgia Southern, and from 1924 to 1955, the entire institution focused exclusively on preparing future teachers. 
                With reorganization of the institution's academic divisions in 1968, the School of Education was created to consolidate the teacher education programs. On July 1, 1990, Georgia Southern received university status,
                and two years later all "school" designations were changed to "college" thereby establishing the College of Education. In 1992, the College of Education initiated the university's first doctoral program, the Doctorate of Education, which was also the first doctorate to be offered by an institution located in South Georgia.
            </p>
            <p>
                The Department of Curriculum, Foundations, and Reading offers a master's degree, education specialist degree, and endorsement program in reading education as well as a doctoral degree in curriculum studies. 
                Additionally, the department provides a service function to all other programs in the College of Education.
            </p>
            <p>
                The Department of Leadership, Technology and Human Development offers a broad range of programs that provide school, system-wide, and student-oriented support services for traditional and alternative settings. 
                Graduate programs offered by the department prepare school and community agency personnel in the areas of school and clinical mental health counselor education, higher education student services, educational leadership, higher education administration, instructional technology, and school psychology.  
                A doctoral degree program in educational leadership is also offered.
            </p>
            <p>
                The Department of Teaching and Learning offers undergraduate teacher preparation programs in early childhood education (grades P-5); middle grades education (grades 4-8); special education (P-12); and the P-12 teaching field in health and physical education. 
                Graduate programs are offered for initial teacher preparation through the Master of Arts in Teaching program and for advanced teacher education at the master's and education specialist levels.  
                Additionally, the department offers an endorsement program in English for Speakers of Other Languages (ESOL).
            </p>
            <br/>
            
            <h3>Departments within the College of Liberal Arts and Social Sciences</h3>
            <a href="http://coe.georgiasouthern.edu/cfr/">Department of Curriculum, Foundations, &amp; Reading</a>
            <br/>
            <a href="http://coe.georgiasouthern.edu/lthd/">Department of Leadership, Technology, and Human Development</a>
            <br/>
            <a href="http://coe.georgiasouthern.edu/tandl/">Department of Teaching and Learning</a>
            <br/>
		<br/>
		
		
		
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
