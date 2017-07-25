
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
    
    <form action ="Fine_Serv" name="myform">
	<div class="container">
		<div class="top">
<!--			<h1 id="title" class="hidden" align = center>New Borrower Details:</h1>
                        <h2 id="title" class="hidden" align = center><span id="logo"><i><b>Fill all the details to successfully add the new borrower!</b></i></span></h2>-->
		</div>
		<div class="login-box animated fadeInDownBig">
			<div class="box-header">
				<h2>Fine Management</h2>
			</div>
                    <b>Display Fines: </b>
                        <hr>              
			<label for="fine_disp">Enter Borrower Card Id: </label>
			<br/>
			<input type="text" width="150px" class="form-control" name="fine_disp" placeholder="Card Id" required>
			<br/>                        
                        <select name="task" id="task" size="1">
                        <option value="4">Over due books</option>
                        <option value="1">View Paid Fines</option>
                        <option value="2">View Unpaid Fines</option>
                        <option value="3">View all Fines (Paid and Unpaid)</option>
                        <!--<option value="4">Overdue Books</option>-->
                        <option value="5">Pay Fine</option>
                        </select>
                        <br/>
                        
                        <br/>
			<button type="submit" style="width:195px">Get Fines</button>
			<br/>
                        <br/>
                        <a href="./webpages/index.html" align = center><u>Back</u></a><br/>
                        <c:out value="${requestScope.number_of_result}"/> record/s found...
        <br>
        <hr>
        <c:forEach items="${requestScope.search_result}" var="result_search" varStatus="loop"> 
        Serial : <c:out value= "${loop.index + 1}" />
        <br/>
                    <object data="http://covers.openlibrary.org/b/isbn/${result_search.isbn}-M.jpg" width=100 height=150>
            <img src="C:\Users\Vimal\Documents\NetBeansProjects\Library_cd\web\notfound.jpg" type="text/html" style="width:100px;height:150px;" />  
            </object>
        <br/>
        <b>Loan Id : </b><c:out value="${result_search.loanid}" />
        <br/>
        <b>Title : </b><c:out value="${result_search.title}" />
        <br/>
        <b>ISBN : </b><c:out value="${result_search.isbn}" />
        <br/>
        <b>Borrower : </b><c:out value="${result_search.fname} ${result_search.lname}" />
        <br/>
        <b>Fine Amount : $</b><c:out value="${result_search.fineamt}" />
        <br/>
        <b>Paid : </b><c:out value="${result_search.paid}" />
        <br/>
        <!--<button id="button" type="submit">Check Out</button>-->
        <hr>
</c:forEach>
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
        
//        var buttons = document.querySelectorAll('.btn');
//        for (var i = 0; i < buttons.length; i++) {
//            buttons[i].onclick = function() {
//            var index1 = this.getAttribute('data-index');
//            //var img = document.querySelector('#img' + index);
//    };
//}
//out.println(index1);
</script>
</body>
</html>