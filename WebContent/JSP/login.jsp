<?xml version="1.0" encoding="ISO-8859-1" ?>
<?xml-stylesheet type="text/xsl" href="../CSS/copy.xsl"?>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">

<head>

	<title>
	    AlumNet
	</title>

<link rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css"/>
<script type="text/javascript" src="../JS/login.js"></script>



</head>
<body id="login">	
<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
    
	<h1 id="header">
	    <a href = "index.jsp"><img src="../Images/logo.png" alt="logo" id="logo"/></a>
	</h1>
		    <!--This prevents someone from re-accessing the login page after a successful login-->
		    <s:if test= "%{#session.type == 'student'}" >
			<jsp:forward page="index.jsp"/>
		    </s:if>
		    <s:elseif test= "%{#session.type == 'alumnus'}" >
			<jsp:forward page="index.jsp"/>
		    </s:elseif>
	
    <!--Navigation Bar-->
    <div class = "nav">
	<a href = "index.jsp">Home</a>&nbsp;
	    <div class="dropdown">
		<button class="dropbtn">Colleges</button>
		    <div class="dropdown-content">
			<a href="ceit.jsp">CoEIT</a>
			<a href="coba.jsp">CoBA</a>
			<a href="class.jsp" >CLASS</a>
			<a href="chhs.jsp" >CHHS</a>
			<a href="cosm.jsp" >CoSM</a>
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
					    <s:a action="logout">Logout</s:a>
				    </s:div>
				</s:if>
				
				<s:elseif test= "%{#session.type == 'alumnus'}" >
				    <s:div class="dropdown-content">
					<a href="account_alum.jsp">My Alum Account</a>
					<s:a action="logout">Logout</s:a>
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
    <br/>
    <s:div id="main">
	<!--Main content of page!-->

	<div class="background">
	    <img class="bg" src="../Images/hedges.jpg" alt="hedges" style="width:100%"/>
	</div>
	
	
	
	
		<br/>
		<s:form action="login" theme="simple" namespace="/JSP" style="font-family: Cabin,Helvetica,Arial,sans-serif;">
		    <h2>Please Login!</h2>
		    
		    <s:div>
                <s:if test="hasActionErrors()">
                    <div>
                        <s:actionerror cssStyle="list-style: none; color: red;"/>
                    </div>
                </s:if>
			<label id="l8">Email</label>
			    <s:textfield type="email" name="loginDTO.email" id="Email" placeholder="jd00000@georgiasouthern.edu" /><br/><br/>
			<label id="l9">Password</label>
			    <s:password type="password" name="loginDTO.password" id="pw" placeholder="*********" /><br/><br/>
		    <s:submit type="submit" value="submit" id="submit" />
		    </s:div>
		</s:form>
    </s:div>
	
	<!-- **This is to enable the "Top of Page" button to be centered on page!** -->
	<div class="topper">
	</div>

	<div id="footer">
		AlumNet<sub>&copy;</sub> 2016
	</div>
</body>
</html>
