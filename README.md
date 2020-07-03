# Huffman

   Le codage de Huffman est un algorithme de compression de données, il utilise un code à longueur variable pour représenter un symbole de la source. Il existe trois variantes de l'algorithme de Huffman (statique, semi-adaptatif, adaptatif), chacune d'elles définissant une méthode pour la création de l'arbre, pour le moment on s’intéresse par la méthode semi-adaptatif.

   L’algorithme de Huffman a pour but la transformation d’un message en un mot codé (ou message codé) composé d’un ensemble de codes binaires tel que le mot codé soit composé du moins de bits possibles. Pour ce faire, il convient d’attribuer à chaque caractère distinct du message un code binaire qui le représentera de façon à ce que les caractères les plus fréquents soient remplacés par les codes les plus courts.

   Alors, l’encodage de Huffman semi-adaptatif nécessite une connaissance à priori de la probabilité d’apparition des symboles. Un texte par exemple à coder est tout d’abord lu intégralement de façon à construire l’alphabet et les fréquences d’apparition des éléments de l’alphabet. Le principe repose sur la création d'une structure d'arbre composée de nœuds à partir des poids de chaque alphabet.

   Cela doit également se faire en évitant d’introduire des « préfixes » dans nos codes, ce qui signifie qu’il ne doit jamais y avoir d’ambiguïté lors du décodage. Si un ensemble de bits correspond à un code binaire connu, alors aucun autre code ne devrait commencer par ce même ensemble. Par exemple, si « 110 » est présent alors cela rend impossible l’utilisation d’un code binaire qui commencerait par ce préfixe, comme « 1101 », il serait impossible de savoir où s’arrêter lors du décodage si je reçois « 1101101... ».


# Etapes

Etap1 : Détermination de l’alphabet et des fréquences.

Etape2 : Trier les éléments par fréquence .

Etape3 : Créer une feuille pour chaque caractère avec la fréquence associée.

Etape4 : Construire l'arbre et retourne la racine.

Etape5 : Parcourir l'arbre pour générer le code pour chaque lettre.

Etape6 : parcourir le texte pour créer code binaire.









Le lien de notre rapport en Latex sur Overleaf: https://www.overleaf.com/read/rydynbjkxjjv
