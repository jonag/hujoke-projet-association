<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Accueil</title>
<%@ include file="fragments/head.jspf"%>
</head>

<%@ include file="fragments/messages.jspf"%>

<div class="container container-signin">
	<form class="form-horizontal" action="<c:url value="/sign-in"/>" method="POST">
		<h2>Veuillez vous connecter</h2>
		<div class="control-group">
			<label class="control-label" for="inputLogin">Identifiant</label>
			<div class="controls">
				<input type="text" name="login" id="inputLogin" placeholder="Identifiant" autofocus required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">Mot de passe</label>
			<div class="controls">
				<input type="password" name="password" id="inputPassword" placeholder="Mot de passe" required>
			</div>
		</div>
		<button class="btn btn-success btn-block" type="submit">Se connecter</button>
	</form>
	<a class="btn btn-primary btn-block" href="<c:url value="/sign-up"/>">Créer votre compte</a>
</div>
</html>