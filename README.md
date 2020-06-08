# Solution Naive

Le problème qui se pose est de pouvoir transformer un texte donné en une série de 0 et 1 que l’ordinateur peut comprendre. La première solution qui saute aux yeux est d’associer à chaque caractère un code binaire de 8bits (avec 8bits on peut coder 28 = 256 qui est un nombre suffisant pour représenter les caractères spéciaux de plusieurs langues).
Pour que l’ordinateur nous génère une liste des lettres qui existent dans le texte donné en input et les codes binaires correspondants, on va créer un arbre binaire parfait de profondeur = 8 ie un arbre binaire strict (dont tous les nœuds possèdent zéro ou deux fils) dans lequel toutes les feuilles sont à la même profondeur.

