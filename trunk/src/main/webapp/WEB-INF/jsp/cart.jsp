<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Votre commande</title>
<%@ include file="fragments/head.jspf"%>
</head>

<%@ include file="fragments/top-navbar.jspf"%>

<%@ include file="fragments/messages.jspf"%>

<div class="container">
	<h2>Votre panier</h2>

	<c:if test="${empty sessionScope.userSession.cart}">
		Votre panier ne contient aucun article.
	</c:if>
	<c:if test="${not empty sessionScope.userSession.cart}">
		<table class="table">
			<thead>
				<tr>
					<th>Code</th>
					<th>Nom</th>
					<th>Prix</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${sessionScope.userSession.cart}" var="product">
			<tr>
				<td>${product.code}</td>
				<td>${product.name}</td>
				<td><fmt:formatNumber value="${product.price}" minFractionDigits="2" maxFractionDigits="2" /></td>
				<td><a href="<c:url value="/cart?action=remove&product=${product.code}"/>">Retirer du panier</a></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="#" class="btn btn-danger">Annuler la commande</a>
	</c:if>
</div>
</html>