<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Votre commande</title>
<%@ include file="fragments/head.jspf"%>
</head>

<%@ include file="fragments/top-navbar.jspf"%>

<%@ include file="fragments/messages.jspf"%>

<div class="container">
	<h2>Votre commande</h2>

	<table class="table">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nom</th>
				<th>Prix</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>C2</td>
				<td>Cle USB</td>
				<td>9.5</td>
			</tr>
			<tr>
				<td>S3</td>
				<td>Stylo</td>
				<td>3.7</td>
			</tr>
		</tbody>
	</table>
	<a href="#" class="btn btn-danger">Annuler la commande</a>
</div>
</html>