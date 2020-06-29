# Huffman statique 

Dans le codage de Huffman statique, chaque octet a un code prédéfini par des statistiques faites préalablement sur des textes qui ont un nombre de caractères énormes. Le problème de ce type de codage est qu'il ne peut s'effectuer que sur un seul type de fichier (ex. : un texte en français, où les fréquences d'apparition du 'e' sont énormes ; celui-ci aura donc un code très court).
Le corpus de « Wikipédia en français », en 2008, a été segmenté en mots par le laboratoire CLLE-ERSS qui a ensuite recensé les occurrences de ces derniers (à peu près 900 000 000 caractère), permettant ainsi le calcul de la fréquence des caractères dont on va se servir dans notre code.
