Yacine MAGHEZZI 			  			*	
Stage à Westminster University		  	*
Création du fichier : Mardi 14 Mars 2012*
==========================================*

A mettre toute les remarques et choses faites en plus :

14/03/2012 
Création du Repo git hub
Premier fichier index.html
Fichier note.txt

15/03/2102

Utilisation de git hub sous Windows

19/03/2012
Git hub fonctionnel
Nouvelles directives : 
	- Utiliser un Servlet PHP qui nous permettra d'accéder au WEB service et les renvoyer les informations 
	à l'application.
	- Pareil pour les flux RSS fonctionnalité à venir.

21/03/2012	
Accès au Web service de test, il est à présent possible de récupérer la réponse de celui-ci.
Enregistrement l'enveloppe SOAP sous un fichier .XML avec la date de reçu de la requête.
Affichage de cette réponse au format HMTL.

26/03/2012
Abandon du servlet PHP, après beaucoup d'essai infructueux, je suis finalement passé à un Servlet JSP beaucoup simple et efficace a créé via Netbeans.
Je récupère la réponse du Web service sécurisé via SSL facilement, avec un affichage explicite parsable par la suite.
Afin qu'il soit fonctionnel il suffisait d'ajouter un certificat auto signé dans le dossier .netbeans.

27/03/2012

29/03/2012
Premiere infrastructure de l'application via JSF et JSP
Ajout des librairies tel que phonegap + Jquery mobile

10/04/2012
Remaniement total de l'application, avec creation de classe Room Et RoomList afin d'avoir une structure plus elaborée
Application a laquelle nous avons ajouté le framework JQuery mobile
Appel aussi de la methode getSitesInfo pour avoir plus de précisions sur l'endroit ou se trouve les salles.
Prendre en charge la conversion de bytes en photo de getSitesInfos
