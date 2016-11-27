<?xml version="1.0" encoding="ISO-8859-1" ?>
<?xml-stylesheet type="text/xsl" href="../CSS/copy.xsl"?>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="application/xhtml+xml;charset=UTF-8" />
	<title>
	    AlumNet
	</title>
<link rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css" />
<script type="text/javascript" src="../JS/login.js"></script>

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
			<a href="colleges/ceit.jsp">CoEIT</a>
			<a href="colleges/coba.jsp">CoBA</a>
			<a href="colleges/class.jsp">CLASS</a>
			<a href="colleges/chhs.jsp">CHHS</a>
			<a href="colleges/cosm.jsp">CoSM</a>
			<a href="colleges/coe.jsp">CoE</a>
			<a href="colleges/coph.jsp">CoPH</a>
		    </div>
	    </div>&nbsp;
	<a href = "about.jsp">About AlumNet</a>&nbsp;
	    <div class="dropdown">
		<button class="dropbtn" id="account">My Account</button>
		    <div class="dropdown-content">	
			<a href = "login.jsp">Login</a>
			<a href = "register.jsp">Register</a>
		    </div>
	    </div>&nbsp;
    </div>
    <br/>
    <s:div id="main">
    <!--Main content of page!-->
	<br/>
	<!-- This is the string to make a cookie "makeCookie('USER_N' , 'cookievalue' , path=\"/\");
"-->
	<s:form namespace="/" theme="simple" id="reg"><!--The actionChange() function switches the onclick action depending on whether the user clicks Alum or Student. Function found in the login.js file -->
	    
	    <h2><s:text name="Please Register!"/></h2>
				    
		<s:radio id="alumTrue" onclick="document.getElementById('ifAlum').style.display=''; document.getElementById('ifStud').style.display='none';document.getElementById('reg').action='addAlumnus';" name="alumStud" list="{'Alumnus'}" />
		<s:radio id="studentTrue" onclick="document.getElementById('ifStud').style.display=''; document.getElementById('ifAlum').style.display='none';document.getElementById('reg').action='addStudent';" name="alumStud" list="{'Student'}"/><hr/>
			
		<!-- ****************** ALUM **************
		*********************** Mapped action: addAlumnus -->
		<s:div id="ifAlum" cssStyle="display:none;">
		    <label id="l1">First Name</label>
			<s:textfield type="text" name = "alumnus.firstName" id="firstName" placeholder="John" /><br/><br/>
		    <label id="l2">Last Name</label>
			<s:textfield label="Last Name" type="text" name="alumnus.lastName" id="lastName" placeholder="Doe" /><br/><br/>
		    <label id="l3">Grad Year</label>
			<s:textfield label="Grad Year" type = "text" name="alumnus.graduationDate" id="Grad" placeholder="2016-01-23"/><br/><br/>
		    <label id="l5">Company</label>
			<s:textfield label="Company" type="text" name="alumnus.company" id="jobComp" placeholder="Dell" /><br/><br/>
		    <label id="l6">Job Title</label>
			<s:textfield label="Job Title" type="text" name="alumnus.jobTitle" id="jobTitle" placeholder="Network Analyst" /><br/><br/>
		    <label id="l7">Job Field</label>
			<s:textfield label="Job Field" type="text" name="alumnus.jobField" id="jobField" placeholder="IT" /><br/><br/>
		    <label id="l8">Email</label>
			<s:textfield label="Email" type="email" name="alumnus.email" id="Email" placeholder="jd00000@georgiasouthern.edu" /><br/><br/>
		    <label id="l9">Password</label>
			<s:password label="Password" type="password" name="pword" id="pw" placeholder="*********" /><br/><br/>
		    <s:submit type="submit" name="submit" value="Submit!" id="submit" />
		</s:div>	
		
		<!-- **************STUDENT ******** -->
		<s:div id="ifStud" cssStyle="display:none;">
		    <label id="l10">First Name</label>
			<s:textfield label="First Name" type="text" name = "student.firstName" id="firstName" placeholder="John" /><br/><br/>
		    <label id="l11">Last Name</label>
			<s:textfield label="Last Name" type="text" name="student.lastName" id="lastName" placeholder="Doe" /><br/><br/>
		    <label id="l12">Student ID</label>
			<s:textfield label="Student ID" type = "number" name="student.studentID" id="id" placeholder="900XXXXXX" min="900000000" /><br/><br/>
		    <label id="l13">Grad Year</label>
			<s:textfield label="Grad Year" type = "number" name="student.expectedGraduation" id="expectedGraduation" placeholder="2017" min="1970" max="2070" /><br/><br/>
		    <label id="l14">Major</label>
			<s:textfield label="Major" type="text" name="student.major" id="major" placeholder="Computer Science" /><br/><br/>
		    <label id="l15">Resume</label>
			<s:textarea label="Resume" type="file" name="student.resume" id="resume" /><br/><br/>
		    <label id="l16">Email</label>
			<s:textfield label="Email" type="email" name="student.Email" id="Email" placeholder="jd00000@georgiasouthern.edu" /><br/><br/>
		    <label id="l17">Password</label>
			<s:password label="Password" type="password" name="pword" id="pw" placeholder="*********" min="8" /><br/><br/>
		    <s:submit type="submit" name="submit" value="Submit!" id="submit" />
		</s:div>
		
	</s:form>
		
	
	<br/>
	
    </s:div>

    
    <!-- **This is to enable the "Top of Page" button to be centered on page!** -->
    <div class="topper">
    </div>
    <div id = "footer">
	AlumNet<sub>&copy;</sub> 2016
    </div>
</body>
</html>
