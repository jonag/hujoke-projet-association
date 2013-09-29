<%@ page pageEncoding="UTF-8"%>
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
			<tr>
				<td>T1</td>
				<td>Tee Shirt</td>
				<td>55.6</td>
				<td>12</td>
				<td><a href="#">Commander</a></td>
			</tr>
			<tr>
				<td>C2</td>
				<td>Cle USB</td>
				<td>9.5</td>
				<td>45</td>
				<td><a href="#">Commander</a></td>
			</tr>
			<tr>
				<td>S3</td>
				<td>Stylo</td>
				<td>3.7</td>
				<td>34</td>
				<td><a href="#">Commander</a></td>
			</tr>
			<tr>
				<td>C4</td>
				<td>Calculatrice</td>
				<td>20.0</td>
				<td>4</td>
				<td><a href="#">Commander</a></td>
			</tr>
		</tbody>
	</table>
</div>
</html>