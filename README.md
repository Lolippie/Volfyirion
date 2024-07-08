# Volfyrion



## L'origine

Ce code avait pour but de mettre en situation les cours appris en deuxième année de Licence Informatique. 
Il s'agissait donc d'appliquer des classes, de l'héritage, des interfaces et d'utiliser les fonctions/procédures pour relier le tout. 
Pour ce faire, le groupe dont j'étais la cheffe de projet a pris la décision de développer un jeu de société et d'utiliser JavaFX comme interface graphique pour présenter notre code et nos connaissances en Java.


## Les règles du jeu

[Les règles du jeu officielles](https://www.play-in.com/pdf/rules_games/volfyirion_regles_fr.pdf)

Notre projet avait pour but de se rapprocher le plus possible des règles actuelles, à quelques détails près (nous ne pouvons pas réparer les villes, par exemple).

Pour un rapide résumé du jeu :
C'est un deck-building dont le but est de tuer son adversaire en détruisant ses villes.

- Des cartes de base vous sont mises en main, ces dernières vous donnent des ressources :
    - de l'argent qui permet d'acheter des cartes,
    - de l'attaque qui permet d'acheter des merveilles, d'attaquer l'adversaire (ses villes) et de tuer Volfyrion,
    - de l'intelligence qui permet de renouveler les cartes achetables, de désactiver les cartes de son adversaire et de déplacer Volfyrion.
- Lors de l'achat de cartes et de merveilles, ces dernières sont mises dans votre deck.
- L'achat de merveilles permet de detruire une carte de votre main
- Votre main vient de ce deck.
- Plusieurs classes de cartes sont présentes :
    - les normales,
    - les protecteurs,
    - les bâtiments.
- Il existe aussi des "combos" qui consistent à prendre les autres cartes et voir si les couleurs correspondent aux bonus donnés. Si oui, vous les appliquez.
- Les protecteurs peuvent être mis sur vos villes pour les protéger. Les points de défense de la ville s'additionnent à ceux du protecteur, et seul le protecteur meurt si la ville est attaquée.
- Les bâtiments sont principalement pour faire les combos et donner de grosses ressources.

Avec les ressources totales, vous devez vous constituer un deck permettant de tuer votre adversaire !
