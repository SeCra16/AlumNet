<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
	<title>
	    AlumNet
	</title>
<LINK rel="stylesheet" href="../CSS/alumnet_styling.css" type="text/css">
<script type="text/javascript" src="../JS/login.js"></script>

</head>
<body>	
<!--Header. The AlumNet button at the top of the page returns you to the homepage of the website-->
    <header>
	
	
	    
	<h1>
	    <a href = "index.jsp"><img src="../Images/logo.png" alt="logo" id="logo"/></a>
	</h1>
	
    </header>
	
    <!--Navigation Bar-->
    <ul class = "nav">
	<li><a href = "index.jsp">Home</a></li>&nbsp;
	    <div class="dropdown">
		<button class="dropbtn">Colleges</button>
		    <div class="dropdown-content">
			<a href="colleges/ceit.jsp" id="1">CoEIT</a>
			<a href="colleges/coba.jsp" id="2">CoBA</a>
			<a href="colleges/class.jsp" id="3">CLASS</a>
			<a href="colleges/chhs.jsp" id="4">CHHS</a>
			<a href="colleges/cosm.jsp" id="5">CoSM</a>
			<a href="colleges/coe.jsp" id="6">CoE</a>
			<a href="colleges/coph.jsp" id="7">CoPH</a>
		    </div>
	    </div>&nbsp;
	<li><a href = "about.jsp">About AlumNet</a></li>&nbsp;
	    <div class="dropdown">
		<button class="dropbtn" id="account">My Account</button>
		    <div class="dropdown-content">	
			<li><a href = "login.jsp">Login</a></li>
			<li><a href = "register.jsp">Register</a></li>
		    </div>
	    </div>&nbsp;
    </ul>
    <br>
    <main>
    <!--Main content of page!-->
	<br>
	<!-- This is the string to make a cookie "makeCookie('USER_N' , 'cookievalue' , path=\"/\");
"-->
	<s:form action="hello">
	    <fieldset id="register_page">
		<legend id = "register">
		    Please Register!
		</legend>
		    <label for="type">Student or Alum?</label>
			<input type="radio" id="alumTrue" onclick="javascript:alumCheck();" name="alumStud">Alumnus
			<input type="radio" id="studentTrue" onclick="javascript:alumCheck();" name="alumStud">Student<br><br><hr>
			
		<div id="ifAlum" style="display:none">
		    <label for="name">First Name: </label>
			<input type="text" name = "name" id="name" placeholder="Sebastian" ><br>
		    <label for="lname">Last Name: </label>
			<input type="text" name="lname" id="lname" placeholder="Craige" ><br>
		    <label for="grad_yr">Grad Year: </label>
			<input type = "number" name="grad_yr" id="yr" placeholder="2016" min="1970" ><br>
		    <label for="jobComp">Company:</label>
			<input type="text" name="jobComp" id="jobComp"><br>
		    <label for="jobTitle">Job Title: </label>
			<input type="text" name="jobTitle" id="jobTitle"><br>
		    <label for="jobField">Job Field: </label>
			<input type="text" name="jobField" id="jobField"><br>
		    <label for="uname">Email: </label>
			<input type="email" name="uname" id="uname" placeholder="sc06358@georgiasouthern.edu" ><br>
		    <label for="pword">Password: </label>
			<input type="password" name="pword" id="pw" placeholder="*********" min="8" ><br>
		    <label for="submit"></label>
			<input type="submit" name="addAlumnus" value="Submit" id="submit">
		</div>	
			
		<div id="ifStud" style="display:none">
		    <label for="name">First Name: </label>
			<input type="text" name = "name" id="name" placeholder="Sebastian" required><br>
		    <label for="lname">Last Name: </label>
			<input type="text" name="lname" id="lname" placeholder="Craige" required><br>
		    <label for="stud_ID">Student ID: </label>
			<input type = "number" name="stud_ID" id="id" placeholder="900XXXXXX" min="900000000" required><br>
		    <label for="grad_yr">Grad Year: </label>
			<input type = "number" name="grad_yr" id="yr" placeholder="2016" min="1970" required><br>
		    <label for="major">Major</label>
			<input type="text" name="major" id="major" placeholder="Computer Science"><br>
		    <label for="uname">Email: </label>
			<input type="email" name="uname" id="uname" placeholder="sc06358@georgiasouthern.edu"><br>
		    <label for="pword">Password: </label>
			<input type="password" name="pword" id="pw" placeholder="*********" min="8"><br>
		    <label for="submit"></label>
			<input type="submit" name="addStudent" value="Submit" id="addStudent">
		</div>   
	    </fieldset>
	</s:form>
	
	<p>HI #session.user.firstName</p>
	
	
	<br>
	
    </main>
    
	
    <!-- **This is to enable the "Top of Page" button to be centered on page!** -->
    <div class="topper">
    </div>
    <footer>
	AlumNet<sub>&copy;</sub> 2016
    </footer>
</body>
</html>