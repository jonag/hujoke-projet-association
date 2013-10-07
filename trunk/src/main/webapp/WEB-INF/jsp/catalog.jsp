<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Catalogue</title>
<%@ include file="fragments/head.jspf"%>
</head>

<%@ include file="fragments/top-navbar.jspf"%>

<%@ include file="fragments/messages.jspf"%>

<div class="container">
	<h2>Catalogue des articles</h2>

	<table class="table">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Stock</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.code}</td>
				<td>${product.name}</td>
				<td><fmt:formatNumber value="${product.price}" minFractionDigits="2" maxFractionDigits="2" /></td>
				<td>${product.stock}</td>
				<td>
				<c:if test="${product.stock > 0}">
					<a href="<c:url value="/cart?action=add&product=${product.code}"/>">Ajouter au panier</a>
				</c:if>
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</html>