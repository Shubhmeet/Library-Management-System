

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <form action ="Check_Serv" name="myform">
	<div class="container">
		<div class="top">
<!--			<h1 id="title" class="hidden" align = center>New Borrower Details:</h1>
                        <h2 id="title" class="hidden" align = center><span id="logo"><i><b>Fill all the details to successfully add the new borrower!</b></i></span></h2>-->
		</div>
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Book Loans</h2>
			</div>
                    <b>Book Check Out: </b>
                        <hr>
                  
			<label for="isbn">ISBN: </label>
			<br/>
			<input type="text" class="form-control" name="isbn" placeholder="Enter Book ISBN" required>
			<br/>
                        <label for="card_id">Card Id: </label>
			<br/>
			<input type="text" class="form-control" name="card_id" placeholder="Enter Card Id" required>
			<br/>
			<br/>
			<button type="submit" style="width:195px">Check Out</button>
			<br/>
<!--			<a href="#"><p class="small">Forgot your password?</p></a>-->
<br/>
                        <a href="./webpages/index.html" align = center><u>Back</u></a>
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