
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>




<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Daily UI - Day 1 Sign In</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
    <form action ="Borrower_Serv" name="myform">
	<div class="container">
		<div class="top">
			<h1 id="title" class="hidden" align = center>New Borrower Details:</h1>
                        <h2 id="title" class="hidden" align = center><span id="logo"><i><b>Fill all the details to successfully add the new borrower!</b></i></span></h2>
		</div>
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>New Borrower Details</h2>
			</div>
			<label for="firstname">First Name: </label>
			<br/>
			<input type="text" class="form-control" name="first_name" placeholder="First Name" required>
			<br/>
                        <label for="lastname">Last Name: </label>
			<br/>
			<input type="text" class="form-control" name="last_name" placeholder="Last Name" required>
			<br/>
                        <label for="ssn">SSN: </label>
			<br/>
			<input type="text" class="form-control" name="ssn" placeholder="Social Security Number" required>
			<br/>
			<label for="address">Address: </label>
			<br/>
			<input type="text" class="form-control" name="address" placeholder="Address" required>
			<br/>
                        <label for="city">City: </label>
			<br/>
			<input type="text" class="form-control" name="city" placeholder="City" required>
			<br/>
                        <label for="state">State: </label>
			<br/>
			<input type="text" class="form-control" name="state" placeholder="State" required>
			<br/>
                        <label for="phone">Phone: </label>
			<br/>
			<input type="text" class="form-control" name="phone_number" placeholder="Phone Number" required>
			<br/>
			<button type="submit" style="width:195px">Add</button>
			<br/>
                        <br/>
                        <a href="./webpages/index.html" align = center><u>Back</u></a>
<!--			<a href="#"><p class="small">Forgot your password?</p></a>-->
		</div>
	</div>
</form>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>
</body>
</html>