<?xml version="1.0" encoding="ISO-8859-1" ?>
<?xml-stylesheet type="text/xsl" href="../CSS/copy.xsl"?>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>
	AlumNet
    </title>
    
    <link rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
    <script type="text/javascript" src="../JS/login.js"></script>

</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
		<h1 id="header">
		    <s:a href = "index.jsp"><img src="../Images/logo.png" alt="logo" id="logo"/></s:a> 
		</h1>
		
		
		    <s:if test= "%{#session.type == 'student'}" >
			<h4>User: <s:property value="#session.user.firstName"/> <s:property value="#session.user.lastName"/></h4>
		    </s:if>
		    <s:elseif test= "%{#session.type == 'alumnus'}" >
			<h4>User: <s:property value="#session.user.firstName"/> <s:property value="#session.user.lastName"/></h4>
		    </s:elseif>

	
	<!--Navigation Bar-->
	<s:div class = "nav">
		<s:a href = "index.jsp">Home</s:a>&nbsp;
			<s:div class="dropdown">
				<button class="dropbtn" id="college">Colleges</button>
					<s:div class="dropdown-content">
						<s:a href="ceit.jsp">CoEIT</s:a>
						<s:a href="coba.jsp">CoBA</s:a>
						<s:a href="class.jsp">CLASS</s:a>
						<s:a href="chhs.jsp">CHHS</s:a>
						<s:a href="cosm.jsp">CoSM</s:a>
						<s:a href="coe.jsp">CoE</s:a>
						<s:a href="coph.jsp">CoPH</s:a>
					</s:div>
			</s:div>&nbsp;
			<s:a href = "about.jsp">About AlumNet</s:a>&nbsp;
			
			
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
	</s:div>

	<div id="main">
	<!--Main content of page!-->
	<div class="background" style="margin-left: 35%">
	    <br/>
	    <img class="bg" src="../Images/it.jpg" alt="it" style="max-width: 50%; max-height: 100%;"/>
	    <img class="bg" src="../Images/hedges.jpg" alt="hedges" style="max-width:50%; min-width: 25%"/>
	    <img class="bg" src="../Images/circle.jpg" alt="circle" style="max-width:50%; min-width: 25%"/>
	</div>
	
	<script>
	    var slideIndex = 0;
	    carousel();

	    function carousel() {
		var i;
		var x = document.getElementsByClassName("bg");
		for (i = 0; i < x.length; i++) {
		  x[i].style.display = "none"; 
		}
		slideIndex++;
		if (slideIndex > x.length) {slideIndex = 1} 
		x[slideIndex-1].style.display = "block"; 
		setTimeout(carousel, 4000); // Change image every 4 seconds
	    }
	</script>
		
		<br/>
		<h2 id="u_e">
		    Upcoming campus related events!	
		</h2>
		
		<br/>
		<br/>
		
		<div id = "upcoming"><!--Got this from GSU website!-->
		<script type="text/javascript" src="http://calendar.georgiasouthern.edu/widget/combo?schools=georgia&days=14&num=10&hide_past=1&template=card"></script>
		</div>
		
	</main>
	
	
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
