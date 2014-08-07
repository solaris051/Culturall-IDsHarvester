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
	<script src="<c:url value="/resources/js/jquery.quickflip.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.quickflip.source.js"/>"></script>
</head>
<body>
	<div id="bgContainer">
		<div id="siteContainer">
			<div id="headerContainer">
				<a href="http://www.culturall.com" title="Culturall Home Page">
					<img id="cutrurallLogo" alt="Culturall.com logo" src="<c:url value="/resources/images/cult_logo_glass.png" />">
				</a>
			</div>
			<div id="contentContainer">
<!-- Flip tabs -->
				<div id="flip-tabs" >
					<ul id="flip-navigation" >
						<li class="selected"><a href="#" id="tab-0"  >ID Service</a></li>
						<li><a href="#" id="tab-1" >Einstellungen</a></li>
					</ul>
					<div id="flip-container" >
						<!-- 1-st tab -->
						<div>
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
						<!-- 2-nd tab -->
						<div>
							<!--Put Content for second tab here-->
							<table>
								<tbody>
									<tr>
										<td><button id="harvesterButton">collect ids</button></td>
										<td>Bei diesem Vorgang werden alle Bestehende Einträge in der Datenbank gelöscht und die Datenbank wird neu befüllt.</td>
									<tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
<!--  -->

			</div>
			<div id="footerContainer">
				Culturall 2014 
			</div>
		</div>
	</div>
</body>
</html>