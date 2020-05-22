#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define symbolesPossibles 256 /* nombre des symboles possibles */

enum { CODER, DECODER }; /* les options du programme */

/* Déscription de chaque noeud de l'arbre */
struct node {
    int sZero;
    int sRacine;
    int sFeuille;
    
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
Node* creerArbre(){
    Node* arbre = malloc(sizeof(Node))
    arbre->sZero = 1;
    arbre->sRacine = 1;
    arbre->sFeuille = 1;

    arbre->parent = NULL;
    arbre->filsGauche = NULL;
    arbre->filsDroit = NULL;

    arbre->symbol = 1
    arbre->val = 0
    arbre->ord = symbolesPossibles * 2 
    return arbre;
}

void renverserCode(int *code){
    if(code == NULL){
        printf("le code est NULL");
        return;
    }
    
}
/* Fonction qui retourne un tableau de 0 et 1s qui contient le code qui correspond à un noeud particulier */
int codeDuNoeud(Node *node){
    Node *noeudActuel = node; 
    int i = 0;
    while (!noeudActuel->sRacine) {
        Node *parent = noeudActuel->parent;
        code[i] = (parent->filsGauche == noeudActuel) ? 0 : 1;
        noeudActuel = noeudActuel->parent;
        i++;
    }
    return code
}