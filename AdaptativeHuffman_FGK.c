#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define symbolesPossibles 256 /* nombre des symboles possibles */
#define a -1

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
typedef struct symbole Symbole;
/*Creation de l'arbre*/
Node* creerArbre(){
    Node* arbre = malloc(sizeof(Node))
    arbre->sZero = 1;
    arbre->sRacine = 1;
    arbre->sFeuille = 1;

    arbre->parent = NULL;
    arbre->filsGauche = NULL;
    arbre->filsDroit = NULL;

    arbre->symbole = a
    arbre->val = 0
    arbre->ord = symbolesPossibles * 2 
    return arbre;
}
/*Obtient un noeud de l'arbre en se basant sur son symbole et retourne son pointeur
  symbole: celui qu'on veut obtenir
  symboles: vecteur de tous les symboles*/
Node* obtNoeud(unsigned char symbole, Symbole **symboles){
    Symbole *pointeur = symboles[(unsigned int)symbole],
    if(!pointeur){
        return NULL;
    }
    return pointeur->arbre
}
/* Fonction qui renverse un tableau d'entiers
   code: le tableau d'entiers (contiendera des o et 1s)
   longueurDuCode: la longueur du tableau*/
void renverserCode(int *code, int longueurDuCode){
    if(code == NULL){
        printf("le code est NULL");
        return;
    }
    int *start = code;
    int *end = code+(longueurDuCode-1);
    while(start < end){
        int temp = *start;
        *start = *end;
        *end = temp;
        start++;
        end--;
    }

}
/* Fonction qui retourne un tableau de 0 et 1s qui contient le code qui correspond à un noeud particulier */
int* codeDuNoeud(Node *node, int *n){
    Node *noeudActuel = node; 
    int *code = malloc(sizeof(int) * symbolesPossibles * 2); /*le pire des cas*/
    int i = 0;
    while (!noeudActuel->sRacine) {
        Node *parent = noeudActuel->parent;
        code[i] = (parent->filsGauche == noeudActuel) ? 0 : 1;
        noeudActuel = noeudActuel->parent;
        i++;
    }
    renverserCode(code, i);
    *n = i;
    return code;
}
/*Fonction qui cherche un noeud qui a la même valeur que le noeud d'entrée
  nEntrée: noeud d'entrée */ 
Node* trouveNoeud(Node *nEntrée, Node *racine){
    Node *résultat = nEntrée;
    if(racine->val > résultat->val && !racine->sfeuille){
        Node *gauche = trouveNoeud(résultat, racine->filsGauche);
        if (gauche) résultat = gauche;
        Node *droit = trouveNoeud(résultat, racine->filsDroit);
        if (droit) résultat = droit;
    }
    else if(racine->val == résultat->val && racine->ord > résultat->ord){
        résultat=racine;
    }
    return (résultat != nEntrée) ? résultat : NULL;
}



