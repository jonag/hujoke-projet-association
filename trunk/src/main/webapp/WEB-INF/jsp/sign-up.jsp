<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Inscription</title>
<%@ include file="fragments/head.jspf"%>
</head>

<%@ include file="fragments/messages.jspf"%>

<div class="container container-signup">
	<form id="sign-up-form" class="form-horizontal" action="<c:url value="/sign-up"/>" method="POST">
		<h2>Inscription</h2>
		<div class="control-group">
			<label class="control-label" for="inputLogin">Identifiant *</label>
			<div class="controls">
				<input type="text" name="login" id="inputLogin" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">Mot de passe *</label>
			<div class="controls">
				<input type="password" name="password" id="inputPassword" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputConfirmPassword">Mot de passe (confirmation) *</label>
			<div class="controls">
				<input type="password" name="passwordConfirmation" id="inputConfirmPassword" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputLastName">Nom de famille *</label>
			<div class="controls">
				<input type="text" name="lastName" id="inputLastName" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputFirstName">Prénom *</label>
			<div class="controls">
				<input type="text" name="firstName" id="inputFirstName" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputStreet">Adresse (rue)</label>
			<div class="controls">
				<input type="text" name="street" id="inputStreet">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="intputZipCode">Code postal</label>
			<div class="controls">
				<input type="number" size="5" name="zipCode" id="intputZipCode">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="intputCity">Ville</label>
			<div class="controls">
				<input type="text" name="city" id="intputCity">
			</div>
		</div>
		<button class="btn btn-success btn-block" type="submit">S'enregistrer</button>
	</form>
</div>
</html>