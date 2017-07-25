
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action ="Check_In_Serv" name="myform">
	<div class="container">
		<div class="top">
<!--			<h1 id="title" class="hidden" align = center>New Borrower Details:</h1>
                        <h2 id="title" class="hidden" align = center><span id="logo"><i><b>Fill all the details to successfully add the new borrower!</b></i></span></h2>-->
		</div>
		<div class="login-box animated fadeInDownBig">
			<div class="box-header">
				<h2>Book Loans</h2>
			</div>
                    <b>Book Check In: </b>
                        <hr>
                  
			<label for="search_in">Enter Book or Borrower information: </label>
			<br/>
			<input type="text" width="150px" class="form-control" name="search_in" placeholder="Search..." required>
			<br/>
                        
<!--                        <label for="ssn">SSN: </label>
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
			<input type="text" class="form-control" name="phone_number" placeholder="Phone Number" required>-->
			<br/>
			<button type="submit" style="width:195px">Get Results</button>
			<br/>
                        <br/>
                        <a href="./webpages/index.html" align = center><u>Back</u></a>
<!--			<a href="#"><p class="small">Forgot your password?</p></a>-->
		</div>
	</div>
</form>
    <form action ="Check_In_Update" name="myform1">
    <div class="login-box animated fadeInUpBig">
        <c:out value="${requestScope.number_of_result}"/> book/s found...
        <br>
        <hr>
        <c:forEach items="${requestScope.search_in_result}" var="result_search_in" varStatus="loop"> 
        Serial : <c:out value= "${loop.index + 1}" />
        <br/>
                    <object data="http://covers.openlibrary.org/b/isbn/${result_search_in.isbn}-M.jpg" width=100 height=150>
            <img src="C:\Users\Vimal\Documents\NetBeansProjects\Library_cd\web\notfound.jpg" type="text/html" style="width:100px;height:150px;" />  
            </object>
            
            <br/>
        <b>Loan Id : </b><c:out value="${result_search_in.loanid}" />
        <br/>
        <b>Title : <c:out value="${result_search_in.title}" /></b>
        <br/>
        <b>ISBN : </b><c:out value="${result_search_in.isbn}" />
        <br/>
        <b>Borrower : </b><u><c:out value="${result_search_in.fname} ${result_search_in.lname}" /></u>
        <br/>
        <b>Card Id : </b><c:out value="${result_search_in.cardid}" />
        <br/>
        <b>Date Out : </b><c:out value="${result_search_in.dateout}" />
        <br/>
        <b>Due Date : <c:out value="${result_search_in.duedate}" /></b>
        <br/>
        <button class="btn" name="check" value="${result_search_in.loanid}">Check In</button>
        <hr>
</c:forEach>
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