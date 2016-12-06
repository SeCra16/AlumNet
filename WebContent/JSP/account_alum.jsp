<%@page import="java.io.PrintWriter"%>
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
	<link rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
	<s:set scope="session" name="#session.type" value="%{'alumnus'}" />

</head>
<body>
	<div id = "top"><!--This is to enable the "Top of Page" button to work-->
	
	<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
	
		<h1 id="header">
	    <a href = "index.jsp"><img src="../Images/logo.png" alt="" id="logo"/></a>
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
		    
	<main>
	<!--Main content of page!-->
	<br/>
	<br/>
	<br/>
	
	<s:form namespace="/" action="addAlumnus" method="POST" enctype="multipart/form-data" theme="simple" id="reg" ><!--The actionChange() function switches the onclick action depending on whether the user clicks Alum or Student. Function found in the login.js file -->
			
		<!-- ****************** ALUM **************
		*********************** Mapped action:  -->
		<s:div id="ifAlum" cssStyle="border: 1px solid;">
		    <br/>
		    
		    <label id="l10">First Name</label>
			<s:property value="#session.user.firstName"/><br/><br/>
		    <label id="l11">Last Name</label>
			<s:property value="#session.user.lastName"/><br/><br/>
		    <label id="l13">Grad Year</label>
			<s:property value="#session.user.graduationDate"/><br/><br/>
		    <label id="l14">Company</label>
			<s:property value="#session.user.company"/><br/><br/>
		    <label id="l15">Job Title</label>
			<s:property value="#session.user.jobTitle"/><br/><br/>
		    <label id="l16">Job Field</label>
			<s:property value="#session.user.jobField"/><br/><br/>
		    <label id="l17">Email</label>
			<s:property value="#session.user.email"/><br/><br/>
		    
		</s:div>	
	</s:form>

			<h1 style="text-align: center;"><strong>Georgia Southern Alum</strong></h1>
	<div>
	    <br/>
	    <img class="bg" src="../Images/alum_ga.jpg" alt="ga" style="max-width:100%;margin-left: 5px"/>
	    <img class="bg" src="../Images/alum_usa.jpg" alt="usa" style="max-width:100%;margin-left: 5px"/>
	    <img class="bg" src="../Images/alum_world.jpg" alt="world" style="max-width:100%;margin-left: 5px"/>
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
		setTimeout(carousel, 5000); // Change image every 10 seconds
	    }
	</script>
	<br/>		
	<h1><a href ="https://securelb.imodules.com/s/1544/index.aspx?sid=1544&gid=1&pgid=463&cid=1157" target="_blank" style="margin-left: 40%">Make a gift to GSU!</a></h1>
			
	</main>
	</div>
	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
