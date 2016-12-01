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
	    <a href = "JSP/index.jsp"><img src="../Images/logo.png" alt="" id="logo"/></a>
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
			<a href="<s:url action="setupRegistration" namespace="/JSP" />">Register</a>
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
				    
		<s:radio id="alumTrue" onclick="document.getElementById('ifAlum').style.display=''; document.getElementById('ifStud').style.display='none';document.getElementById('reg').action='addAlumnus';" name="type" list="{'Alumnus'}" />
		<s:radio id="studentTrue" onclick="document.getElementById('ifStud').style.display=''; document.getElementById('ifAlum').style.display='none';document.getElementById('reg').action='addStudent';" name="type" list="{'Student'}"/><hr/>
			
		<!-- ****************** ALUM **************
		*********************** Mapped action: addAlumnus -->
		<s:div id="ifAlum" cssStyle="display:none;">
		    <label id="l1">First Name</label>
			<s:textfield type="string" name = "alumnus.firstName" id="firstName" placeholder="John" /><br/><br/>
		    <label id="l2">Last Name</label>
			<s:textfield label="Last Name" type="string" name="alumnus.lastName" id="lastName" placeholder="Doe" /><br/><br/>
		    <label id="l3">Grad Date</label>
			<s:textfield label="Grad Date" type = "date" name="alumnus.graduationDate" id="Grad" min="1906-01-02"/><br/><br/>
		    <label id="l5">Company</label>
			<s:textfield label="Company" type="string" name="alumnus.company" id="jobComp" placeholder="Dell" /><br/><br/>
		    <label id="l6">Job Title</label>
			<s:textfield label="Job Title" type="string" name="alumnus.jobTitle" id="jobTitle" placeholder="Network Analyst" /><br/><br/>
		    <label id="l7">Job Field</label>
			<s:select name="alumnus.jobField" list="majors" id="major"/><br/><br/>
		    <label id="l8">Email</label>
			<s:textfield label="Email" type="email" name="alumnus.email" id="Email" placeholder="jd00000@georgiasouthern.edu" /><br/><br/>
		    <label id="l9">Password</label>
			<s:password label="Password" type="password" name="password" id="pw" placeholder="*********" /><br/><br/>
		    <label id="l18">Profile Picture</label>
			<s:file id="pic" name="alumnus.picture"/><br/><br/>
		    <s:submit type="submit"  value="submit" id="submit" />
		</s:div>	
		
		<!-- **************STUDENT ******** -->
		<s:div id="ifStud" cssStyle="display:none;">
		    <label id="l10">First Name</label>
			<s:textfield label="First Name" type="string" name = "student.firstName" id="firstName" placeholder="John" /><br/><br/>
		    <label id="l11">Last Name</label>
			<s:textfield label="Last Name" type="string" name="student.lastName" id="lastName" placeholder="Doe" /><br/><br/>
		    <label id="l13">Grad Date</label>
			<s:textfield label="Grad Date" type = "date" name="student.expectedGraduation" id="expectedGraduation" min="2016-01-01" /><br/><br/>
		    <label id="l14">Major</label>
			<s:select name="student.major" id="major" list="majors"/><br/><br/>
		    <label id="l15">Resume</label>
			<s:file id="resume" name="student.resume"/><br/><br/>
		    <label id="l16">Email</label>
			<s:textfield label="Email" type="email" name="student.email" id="Email" placeholder="jd00000@georgiasouthern.edu" /><br/><br/>
		    <label id="l17">Password</label>
			<s:password label="Password" type="password" name="password" id="pw" placeholder="*********" min="8" /><br/><br/>
		    <label id="l19">Profile Picture</label>
			<s:file id="pic" name="student.picture"/><br/><br/>
		    <s:submit type="submit" value="submit" id="submit" />
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
