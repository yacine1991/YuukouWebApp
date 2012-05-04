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

11/04/2012
Recupération des bytes en les convertisssant dans un array pui plusieurs cast afin de pouvoir l'interpreter comme il se doit.
Le fait est que il m'est impossible d'afficher l'image dans un absolute path ou relatif.
Mais l'image est bien enregistrée.
Enregistrée au format jpg, tout le traitement se fera sur le serveur, cela sera plus couteut en ressources, mais 
forcement plus rapide a faire sur un PC que sur telephone protable.
L'image est donc après chargée, le téléphone aura juste a faire le chargement comme une image banale.

12/04/2012
Ajout de methodes getImagePath pour recuperer plus facilement le chemin de l'image, et debut de test sur les statistiques
de l'appli.

12/04/2012
Ajout des librairies JFreeChart permettant de creer un graphique.
J'ai reussi a créer un graphique lambda qui s'enregistre directement sans s'afficher.
Le graphique a l'air plutot pas mal. 

16/04/2012
Creation des fonction necessaires a la generation de graphiques, qui rendent plutot pas mal.
4 graphique différents, mais toujours pas possible de les afficher.
Résolution du probleme concernant le request dipacher, en demander un paramatere ne fonction de la page appellée.

17/04/2012
Ajout de fonction de recupération des données en mettant un String en parametre.
Ainsi que l'ajout de diagramme pour tous les autre campus.
Probleme avec l'iterateur a regler.

18/04/2012

je dois separer la partie manager de la partie client, ce qui donnera naissance a 2 applications différentes mais faisant appel aux meme classes.
Pour l'une certaines seront bridée quand a l'autre, tout est libre.
A voir aussi l'utilisation de l'API de Google Map si j'ai le temps.
Amélioration des fonctions roomStatus et RoomsStatus, le chargement etait ong car je me devais de creer un jpg pour chaque salle existante,
alors elle n'est pas forcement utilisée.
J'ai donc séparée le traitement dans 2 JSP différentes.
La premiere va permettre de remplir l'objet Room sans photos, afin de pouvoir l'afficher sous forme de liste, quand a la deuxieme, rappelle une focntion du servlet qui Parse
une methode que j'apelle du Webservice, mais cette fois ci avec la photo, donc cela me permet d'enregistrer la photo que i j'ai l'identifiant de la room actuelle.

20/04/2012
Application premiere version commence a ressembler a quelque chose.
A rajouter dans une page de JSP les graphiques avec Google Chart API.
<%= %>
Affichage des images reussies, mais probleme dans l'afficahge des infos des salles dans la page roomInfos

23/04/2013
Ajout des statstique pour google map.
Nouvelles consignes : 
	- A faire, utiliser getGraph renvoyée par le webservice pour faire le graphique ac GoogleChart
	- Affichage des graphs divers faits precedemment mais avec google jChart.

24/04/2012
Ajout de la fonction GetGraphRequest permettant de parser la reponse JSON du webService

25/04/2012
Ajout des methode restriction + url de la salle dans room suite a la modification du WS.
Debut d'utlisation de AJAX pour java.

26/04/2012
Ajour des parsage de getGraph, et maj des parsage des fonction modifiée par Benoit
Rectification du beug des image de s'affichant pas dans les salles occupées
Affichages des timetable + Creation de la classe TimeTable.

27/04/2012
Probleme des statistiques réglé + ajotu de l'auto refresh( remplacant probablement l'AJAX)

01/05/2012
location remarche, ainsi que le parsage de WHo, et healthforRoom.

04/05/2012
Reogranisation en packages + Allegement des fichiers non utilisés dans les bibilio

