#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define a -1 
#define symbolesPossibles 256 /* nombre des symboles possibles */

enum { CODER, DECODER }; /* les options du programme */

/* Déscription de chaque noeud de l'arbre */
struct node {
    int sZero;
    int sRacine;
    int sfeuille;
    
    struct node *parent;
    struct node *filsGauche;
    struct node *filsDroit;
    
    unsigned char symbole;
    int val;
    int ord;
};
typedef struct node Node;

/* Décrit chaque symbole, contient un pointeur vers son noeud de l'arbre */
struct symbole {
    char symbole;
    Node *arbre;
};