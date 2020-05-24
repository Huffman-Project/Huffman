# Huffman

Le codage de Huffman est un algorithme de compression de données, il utilise un code à longueur variable pour représenter un symbole de la source. Il existe trois variantes de l'algorithme de Huffman (statique, semi-adaptatif, adaptatif), chacune d'elles définissant une méthode pour la création de l'arbre, pour le moment on s’interesse par la méthode semi-adaptatif.
L’encodage de Huffman semi-adaptatif nécessite une connaissance à priori de la probabilité d’apparition des symboles. Un texte par exemple à coder est tout d’abord lu intégralement de façon à construire l’alphabet et les fréquences d’apparition des éléments de l’alphabet. Le principe repose sur la création d'une structure d'arbre composée de nœuds à partir des poids de chaque alphabet.

# Etapes

Etap1 : Détermination de l’alphabet et des fréquences.

Etape2 : Trier les éléments par fréquence .

Etape3 : Créer une feuille pour chaque caractère avec la fréquence associée.

Etape4 : Construire l'arbre et retourne la racine.

Etape5 : Parcourir l'arbre pour générer le code pour chaque lettre.

Etape6 : parcourir le texte pour créer code binaire.
