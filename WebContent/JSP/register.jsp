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
<LINK rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
<script type="text/javascript" src="../JS/login.js"></script>
<script type="text/javascript">
    function alumCheck() {
    if (document.getElementById('alumTrue').checked) {
        document.getElementById('ifAlum').style.display = 'block';
	document.getElementById('ifStud').style.display = 'none';
	document.getElementById('reg').action='addAlumnus';
    } else {
        document.getElementById('ifAlum').style.display = 'none';
        document.getElementById('ifStud').style.display = 'block';
	document.getElementById('reg').action='addStudent';
    }
}

</script>
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
    <div id="main">
    <!--Main content of page!-->
	<br/>
	<!-- This is the string to make a cookie "makeCookie('USER_N' , 'cookievalue' , path=\"/\");
"-->
	<s:form action="alumCheck" namespace="/" ><!--The actionChange() function switches the onclick action depending on whether the user clicks Alum or Student. Function found in the login.js file -->
		<label id="Status">Student or Alum?</label>

		
		<s:radio list="{'Alumnus','Student'}" name="alumStud" multiple="true"></s:radio>	
		<!-- ****************** ALUM **************-->
		<div id="ifAlum" style="display:none; border: 1px solid;">
		    <s:textfield type="text" label="First Name" name = "alumnus.FirstName" id="FirstName" placeholder="Sebastian" />
		    <s:textfield type="text" label="Last Name" name="alumnus.LastName" id="LastName" placeholder="Craige" />
		    <s:textfield type = "number" label="Grad Year" name="alumnus.GraduationDate" id="GraduationDate" placeholder="2016" min="1970" />
		    <s:textfield type="text" label="Major" name="major" id="major" placeholder="Computer Science"/>
		    <s:textfield type="text" label="Company" name="jobComp" id="jobComp"/>
		    <s:textfield type="text" label="Job Title" name="jobTitle" id="jobTitle"/>
		    <s:textfield type="text" label="Job Field" name="jobField" id="jobField"/>
		    <s:textfield type="email" label="Email" name="Email" id="Email" placeholder="sc06358@georgiasouthern.edu" />
		    <s:textfield type="password" label="Password" name="password" id="pw" placeholder="*********" min="8" />
		    <s:submit value="Submit" id="submit" align="center"/>
		</div>	
		
		<!-- **************STUDENT ******** -->
		
		<div id="ifStud" style="display:none">
		    <label for="name">First Name: </label>
			<input type="text" name = "FirstName" id="FirstName" placeholder="Sebastian" /><br/>
		    <label for="lname">Last Name: </label>
			<input type="text" name="LastName" id="LastName" placeholder="Craige" /><br/>
		    <label for="stud_ID">Student ID: </label>
			<input type = "number" name="stud_ID" id="id" placeholder="900XXXXXX" min="900000000" /><br/>
		    <label for="grad_yr">Grad Year: </label>
			<input type = "number" name="expectedGraduation" id="expectedGraduation" placeholder="2016" min="1970" /><br/>
		    <label for="major">Major: </label>
			<input type="text" name="major" id="major" placeholder="Computer Science"/><br/>
		    <label for="resume">Resume: </label>
			<input type="file" name="resume" id="resume"/><br/>
		    <label for="uname">Email: </label>
			<input type="email" name="Email" id="Email" placeholder="sc06358@georgiasouthern.edu"/><br/>
		    <label for="pword">Password: </label>
			<input type="password" name="pword" id="pw" placeholder="*********" min="8"/><br/>
		    <label for="submit"></label>
			<input type="submit" name="submit" value="Submit" id="addStudent"/>
		</div>
		
		
		<s:submit value="submit" name="submit" />

	</s:form>
	
	<p>HI #session.user.firstName</p>
	
	
	<br/>
	
    </div>
    
	
    <!-- **This is to enable the "Top of Page" button to be centered on page!** -->
    <div class="topper">
    </div>
    <div id = "footer">
	AlumNet<sub>&copy;</sub> 2016
    </div>
</body>
</html>