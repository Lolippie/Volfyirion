# Volfyrion



## L'origine

Ce code avait pour but de mettre en situation les cours appris en deuxième année de Licence Informatique. Il s'agissait donc d'appliquer des classes, l'héritage, les interfaces 
et utiliser les fonctions/procédures pour relier le tout.
Pour ce faire, le groupe dont j'étais la chef de projet a pris la décision de développer un jeu de société et d'utiliser le javaFX comme interface graphique pour mettre présenter
 notre code et nos connaissances en java.


## Les règles du jeu

[Les règles du jeu officielles](https://www.play-in.com/pdf/rules_games/volfyirion_regles_fr.pdf)

Notre projet avait pour but de se rapprocher le plus possible des règles actuelles, à quelques details prêt (nous ne pouvons pas réparer les villes par exemple). 

Pour rapide résumé du jeu :
C'est un deck-building dont le but est de tuer son adversaire en detruisant ses villes

- Des cartes de base vous sont mise dans la main, ces dernieres vous donnent des ressources 
    - de l'argent qui permet d'acheter les cartes 
    - de l'attaque qui permet d'acheter des merveilles, d'attaquer l'adversaire (ses villes) et de tuer Volfyrion
    - de l'intelligence qui permet de renouveler les cartes achetables, désactiver les cartes de son adversaire, et déplacer Volfyrion
- Lors de l'achat de cartes et de merveilles, ces dernieres sont mises dans votre deck
- Votre main vient de se deck
- Plusieurs classes de cartes sont présentes
    - les normales
    - les protecteurs
    - les batiments
- Il existe aussi des "combos" qui consiste à prendre les autres cartes et voir si les couleurs correspondent aux bonus donnés. Si oui, vous les appliquer
- Les protecteurs peuvent etre mis sur vos villes, pour les proteger. Les points de defense de vie de la ville s'additionnent à ceux du protecteur, et seul le protecteur meurt si la ville est attaquée.
- Les batiments sont principalement pour faire les combos et donnés de grosses ressources
Avec les ressources totales, vous devez vous consituer un deck permettant de tuer votre adversaire !
