<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Accueil</title>
<%@ include file="fragments/head.jspf"%>
</head>

<%@ include file="fragments/top-navbar.jspf"%>

<%@ include file="fragments/messages.jspf"%>

<div class="container">
	<h2>Bienvenue sur le site des adhérents de l'association</h2>

	<ul>
		<li><a href="<c:url value="/catalog"/>">Consulter les articles disponibles</a></li>
		<li><a href="<c:url value="/cart"/>">Consulter votre commande</a></li>
	</ul>
</div>
</html>