<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/assets/css" />
<spring:url var="js" value="/assets/js" />
<spring:url var="images" value="/assets/images" />



<c:set var="contextRoot" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="Khozema Nullwala">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shop - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'

</script>




<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap Readable theme  CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation bar here-->

		<%@include file="./shared/navbar.jsp"%>


		<!-- Page Content -->

		<div class="content">
			<!-- loading the home content -->
			<c:if test="${userClickHome==true }">
				<%@include file="home.jsp"%>
			</c:if>


			<!-- loading the home only when user click about -->
			<c:if test="${userClickAbout==true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- loading the home only when user click contact -->
			<c:if test="${userClickContact==true }">
				<%@include file="contact.jsp"%>
			</c:if>


			<!-- loading the home only when user click contact -->
			<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
      
      <!-- Load only when user clicks show product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>	
			
			  <!-- Load only when user clicks manage product -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>	
			  <!-- Load only when user clicks to cart -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>	
			 <!-- Load only when user clicks to checkout -->
			<c:if test="${checkout == true}">
				<%@include file="checkout.jsp"%>
			</c:if>
			 <!-- Load only when user clicks to pay -->
			<c:if test="${pay == true}">
				<%@include file="success-pay.jsp"%>
			</c:if>	
			
			
			
			
      
		</div>






		<!-- footer here -->

		<%@include file="./shared/footer.jsp"%>

		<!-- core js -->
		<script src="${js}/jquery.js"></script>
		<!-- jquery validator -->
		<script src="${js}/jquery.validate.js"></script>
		
		

		<!-- Bootstrap core js -->
		<script src="${js}/bootstrap.js"></script>

         <!-- DataTable Plugin -->
		 <script src="${js}/jquery.dataTables.js"></script>

                <!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>



                <!-- Bootbox  -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- self coded javascript -->
		<script src="${js}/myapp.js"></script>


	</div>

</body>

</html>
