# Eclipse #
  * Récupérer Eclipse Kepler http://www.eclipse.org/downloads/packages/node/1081
  * Installer le plugin Subclipse (via le marketplace ou http://subclipse.tigris.org/update_1.10.x)
  * Faire un checkout du tronc du projet

On ne commit pas les fichiers relatifs à la configuration d'Eclipse (.project, .classpath, .settings) il faut donc la première fois faire un clic droit sur le projet puis Configure -> Convert to Maven project. Eclipse va trouver le fichier pom.xml et configurer le projet pour qu'il fonctionne correctement.
Attention, bien vérifier que l'encodage du projet est en UTF-8 et le délimiteur de fin de ligne en style "Unix".