# Huffman
# Huffman Dynamique
L'algorithme de Huffman dynamique construit un arbre de Huffman adaptatif qui évolue au fur et à mesure de la lecture et du traitement (compression ou d´ecompression) des symboles.
L'algorithme de compression (compresseur) et l'algorithme de décompression (décompresseur) modifient
l'arbre de la même facon, de telle sorte qu' à chaque instant ils utilisent les mêmes codes (mais ces codes
changent au cours du temps).
Le codage d'Huffman adaptatif a été concu indépendamment par Faller (1973) et Gallager (1978).
Knuth a contribué à des améliorations à l'algorithme original (1985), d'ou l'appellation "FGK" (Faller Gallager Knuth).
*Codage:

L'arbre initial est constitué d'une unique feuille, celle de la lettre vide. A
chaque fois qu'une lettre x est lue dans le texte source.

— si elle est déjà apparue
— on imprime son mot de code,
— on met à jour l'arbre,

— sinon, on imprime le mot de code de la lettre vide suivi de x non
codé (son code ascii en base 2 par exemple),
— on ajoute une feuille dans l'arbre,

— on met à jour l'arbre.

*Décodage:

L'arbre initial est constitué d'une unique feuille, celle de la lettre vide.
Jusqu'à épuisement, on parcourt l'arbre en lisant les bits du texte codé
('0' à gauche, '1' à droite) jusqu'à arriver à une feuille

— s'il s'agit d'une lettre non vide
— on imprime la lettre,
— on met à jour l'arbre,

— sinon, il s'agit de la lettre vide
— on lit les 8 bits suivants pour obtenir le code ascii d'une lettre
que l'on imprime,
— on ajoute une feuille dans l'arbre,

— on met à jour l'arbre.
