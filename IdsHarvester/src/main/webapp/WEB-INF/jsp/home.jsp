<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
 --%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
	<script src="<c:url value="/resources/js/jquery-1.11.1.js"/>"></script>
	<script src="<c:url value="/resources/js/blur.js"/>"></script>
	<script src="<c:url value="/resources/js/home.js"/>"></script>
</head>
<body>
	<div id="bgContainer">
		<div id="siteContainer">
			<div id="headerContainer">
				<img id="cutrurallLogo" alt="Culturall.com logo" src="<c:url value="/resources/images/cult_logo_glass.png" />">
			</div>
			<div id="contentContainer">
				<table id="containerTable">
					<tr>
						<td>
							ID <input id="translateIdInput" type="text">
							<%-- <input type="image" id="translateIdSearch"  src="<c:url value="/resources/images/searchButton.png"/>"> --%>
							<button id="translateIdSearch">search</button>
						</td>
						<td id="urlCell">
							<a id="translateIdLink"></a>
						</td>
					</tr>
				</table>
			</div>
			<div id="footerContainer">
				Culturall 2014 <button id="harvesterButton">collect ids</button>
			</div>
		</div>
	</div>
</body>
</html>