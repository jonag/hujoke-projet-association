jQuery.extend(jQuery.validator.messages, {
	required: "Ce champ est requis.",
	email: "Veuillez saisir une adresse mail valide.",
	alphabetic: "Veuillez ne saisir que des lettres.",
	alphanumeric: "Veuillez ne saisir que des lettres, souligné et chiffres.",
	number: "Veuillez saisir un nombre.(ex.: 12,-12.5,-1.3e-2)",
	integer: "Veuillez saisir un nombre sans decimales.",
	zipcode: "Veuillez saisir un code postal valide.",
	minlength: "Veuillez saisir au moins {0} caractères.",
	maxlength: "Veuillez ne pas saisir plus de {0} caractères.",
	min: "Veuillez saisir une valeur supérieure ou égale à {0}.",
	max: "Veuillez saisir une valeur inférieure ou égale à {0}.",
	equalTo: "Veuillez saisir la même valeur.",
});

$(document).ready(function() {

	$('#sign-up-form').validate(
			{
				rules : {
					passwordConfirmation : {
						equalTo : '#password'
					}
				},
				errorClass: 'error help-inline',
				highlight: function (element) {
					$(element).closest('.control-group').addClass('error');
				},
				unhighlight: function (element) {
					$(element).closest('.control-group').removeClass('error');
				}
			}
		);

});