#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define symbolesPossibles 256 /* nombre des symboles possibles */
#define a -1

enum { CODER, DECODER }; /* options du programme */

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
        printf("Le code est NULL");
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
/*Fonction qui ajoute un fils à l'arbre*/
Node* ajoutefils(Node *parent, int sZero, int sRacine, unsigned char symbole, int val, int ord) {
    Node *noeud = malloc(sizeof(Node));
    node->sZero = sZero;
    node->sRacine = sRacine;
    node->sfeuille = 1;
    node->parent = parent;
    node->filsGauche = NULL;
    node->filsDroit = NULL;
    node->symbole = symbole;
    node->val = val;
    node->ord = ord;
    return noeud;
}
/*Fonction qui ajoute un symbole à l'arbre*/
Node* ajouteSymbole(unsigned char symbole, Node **zeroNoeud, Symbole **symboles) {
    Node *noeudGauche = ajoutefils(*zeroNoeud, 1, 0, a, 0, (*zeroNoeud)->ord - 2);
    Node *noeudDroit = ajoutefils(*zeroNoeud, 0, 0, symbole, 1, (*zeroNode)->ord - 1);
    
    Node *zNprecedent = *zeroNoeud;
    (*zeroNoeud)->sZero = 0;
    (*zeroNoeud)->sFeuille = 0;
    (*zeroNoeud)->filsGauche = noeudGauche;
    (*zeroNoeud)->filsDroit = noeudDroit;
    
    unsigned int indiceSymbole = (unsigned int)symbole;
    symboles[indiceSymbole] = malloc(sizeof(Symbole));
    symboles[indiceSymbole]->symbole = symbole;
    symboles[indiceSymbole]->arbre = noeudDroit;
    
    *zeroNoeud = noeudGauche;
    
    return zNpredendent;
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

/*Fonction qui permute deux noeuds*/
void permuteNoeuds(Node *n1, Node *n2) {
    int tempOrd = n1->ord;
    n1->ord = n2->ord;
    n2->ord = tempOrd;
    
    if (n1->parent->filsGauche == n1) {
        n1->parent->filsGauche = n2;
    } else {
        n1->parent->filsDroit = n2;
    }
    
    if (n2->parent->filsGauche == n2) {
        n2->parent->filsGauche = n1;
    } else {
        n2->parent->filsDroit = n1;
    }
    
    Node *temp = n1->parent;
    n1->parent = n2->parent;
    n2->parent = temp;
}
/*Fonction qui met à jour l'arbre*/
void actualise(Node *noeudActuel, Node *racine) {
    while (!noeudActuel->sRacine) {
        Node *remplaceNoeud = trouveNoeud(noeudActuel, racine);
        
        if (remplaceNoeud && noeudActuel->parent != remplaceNoeud) {
            permuteNoeuds(noeudActuel, remplaceNoeud);
        }
        
        (noeudActuel->val)++;
        noeudActuel = noeudActuel->parent;
    }
    
    (noeudActuel->val)++;
}
/*Ajoute un code au Buffer*/
unsigned char ajouteAuBuffer(int *code, int longeurDuCode, FILE *fp, unsigned char buffer, int *bufferSize) {
    unsigned char bufferActuel = buffer;
    
    int i;
    for (i = 0; i < longueurDuCode; i++) {
        unsigned char bit = ((unsigned char) code[i]) << (*bufferSize - 1);
        bufferActuel = bufferActuel | bit;
        
        (*bufferSize)--;
        
        if (*bufferSize == 0) {
            fwrite(&bufferActuel, sizeof(unsigned char), 1, fp);
            bufferActuel = 0;
            *bufferSize = 8;
        }
    }
    
    return bufferActuel;
}
/*Ajoute un octet au buffer*/
unsigned char ajouteOctet(char octet, FILE *fp, unsigned char buffer, int *bufferSize) {
    unsigned char bufferActuel = buffer;
    
    int bitsEcrites = *bufferSize;
    int change = 8 - bitsEcrites;
    unsigned char tempoctet = ((unsigned char) octet) >> change;
    currBuffer = currBuffer | tempoctet;
    
    fwrite(&bufferActuel, sizeof(unsigned char), 1, fp);
    
    bufferActuel = octet << bitsEcrites;
    
    return (*bufferSize == 8) ? 0 : bufferActuel;
}

void ecritAuBuffer(FILE *fp, unsigned char buffer, int bufferSize) {
    if (bufferSize < 8) {
        fwrite(&buffer, sizeof(unsigned char), 1, fp);
    }
    buffer = (bufferSize == 8) ? 8 : 8 - bufferSize;
    fwrite(&buffer, sizeof(unsigned char), 1, fp);
}

/*Fonction qui code le fichier d'entrée*/
void code(FILE *fp_in, FILE *fp_out) {
    unsigned char buffer = 0;
    int bufferSize = 8;
    Node *racine = creerArbre();
    Node *zeroNoeud = racine;
    Symbole **symboles = calloc(symbolesPossibles, sizeof(Symbole*)); 
    
        unsigned char octetActuel;
        while (fread(&octetActuel, sizeof(unsigned char), 1, fp_in) > 0) {
            Node *symboleArbre = obtNoeud(octetActuel, symboles);
        
            if (symboleArbre) {
                int longueurDuCode;
                int *symboleCode = codeDuNoeud(symboleArbre, &longueurDuCode);
                buffer = ajouteAuBuffer(symboleCode, longueurDuCode, fp_out, buffer, &bufferSize);
            
                actualise(symboleArbre, racine);
                free(symboleCode);
            } else {
                int longueurDuCode;
            
                int *zeroCode = codeDuNoeud(zeroNoeud, &longueurDuCode);
                buffer = ajouteAuBuffer(zeroCode, longueurDuCode, fp_out, buffer, &bufferSize);
                buffer = ajouteAuBuffer(octetActuel, fp_out, buffer, &bufferSize);
            
                Node *nouveauNoeud = ajouteSymbole(octetActuel, &zeroNoeud, symboles);
                actualise(nouveauNoeud, racine);
                free(zeroCode);
            }
        }
    
    ecritAuBuffer(fp_out, buffer, bufferSize);
}
/*Fonction qui lit le bit suivant à être lu dans le buffer et le retourner
  buffer: le buffer d'entrée qui peut être mis à jour au cas d'une lecture du fichier d'entrée
  buffersize: le nombre de bits qui restent à lire dans le buffer
  l: le nombre de bits qui doivent être lus jusqu'au dernier octet  */
int lireBit(FILE *fp, unsigned char *buffer, int *bufferSize, long int fileSize, int l) {
    if (*bufferSize == 0) {
        *bufferSize = 8;
        fread(buffer, sizeof(unsigned char), 1, fp);
    }
    
    if (l != 8) {
        if (ftell(fp) == fileSize && l <= (8 - *bufferSize)) return -1;
    }
    
    if (ftell(fp) > fileSize || feof(fp)) return -1;
    
    (*bufferSize)--;
    
    return (*buffer >> *bufferSize) & 1;
}
/*Fonction qui lit les 8 bits et les retourne comme un char*/
char lireOctet(FILE *fp, unsigned char *buffer, int *bufferSize, long int fileSize, int l) {
    char result = 0;
    
    int i, bit;
    for (i = 0; i < 8; i++) {
        bit = lireBit(fp, buffer, bufferSize, fileSize, l);
        bit = bit << (7-i);
        résultat |= bit;
    }
    
    return résultat;
}
/*Fonction qui décode le fichier */
void decode(FILE *fp_in, FILE *fp_out) {
    Node *racine = creerArbre();
    Node *zeroNoeud = racine;
    unsigned char buffer = 0;
    int bufferSize = 0;
    Symbole **symboles = calloc(symbolesPossibles, sizeof(Symbole*)); 
    
    fseek(fp_in, -1, SEEK_END);
    long int fileSize = ftell(fp_in);
    
  
    unsigned char l;
    fread(&l, sizeof(unsigned char), 1, fp_in);
    rewind(fp_in);
    
    while (!feof(fp_in)) {
        Node *noeudActuel = racine;
        
        int finDuFichier = 0;
        while (!noeudActuel->sFeuille && !finDuFichier) {
            int bit = readBit(fp_in, &buffer, &bufferSize, fileSize, l);
            if (bit == 0) {
                noeudActuel = noeudActuel->filsGauche;
            } else if (bit == 1) {
                noeudActuel = noeudActuel->filsDroit;
            } else {
                finDuFichier = 1;
            }
        }
        
        if (finDuFichier) break;
        
        unsigned char c;
        if (noeudActuele->sZero) {
            c = lireOctet(fp_in, &buffer, &bufferSize, fileSize, l);
            noeudActuel = ajouteSymbole(c, &zeroNoeud, symboles);
        } else {
            c = noeudActuel->symbole;
        }
        
        fwrite(&c, sizeof(unsigned char), 1, fp_out);
        actualise(noeudActuel, racine);
    }
}

int main(int argc, char *argv[]) {
	if (argc != 4) {
        printf("Usage:\n");
		printf("\t./fgk  -c (pour coder)\n");
		printf("\t./fgk  -d (pour decoder)\n");
		exit(1);
	}
	
    FILE *fp_in;
    FILE *fp_out;
    int option;
    
    /* fichier d'entrée */
    fp_in = fopen(argv[1], "rb");
    while (fp_in == NULL) {
        char in_file[100];
        printf("Le fichier %s ne peut pas être ouvert. Essayer une autre fois: ", argv[1]);
        scanf("%s", in_file);
        fp_in = fopen(in_file, "rb");
    }

    /* fichier de sortie */
    fp_out = fopen(argv[2], "wb");

    
    if (strcmp(argv[3], "-c") == 0 || strcmp(argv[3], "-C") == 0) {
        option = CODER;
    } else if (strcmp(argv[3], "-d") == 0 || strcmp(argv[3], "-D") == 0) {
        option = DECODER;
    } else {
        char opt;
        do {
            printf("Saisir 'c' pour coder ou 'd' pour decoder: ");
            scanf("%c", &opt);
            getchar();
        } while (opt != 'c' && opt != 'C' && opt != 'd' && opt != 'D');
        option = (opt == 'c' || opt == 'C') ? CODER : DECODER;
    }
    
    if (option == CODER) {
        code(fp_in, fp_out);
        printf("Le fichier a été codé.\n");
    } else {
        decode(fp_in, fp_out);
        printf("Le fichier a été décodé.\n");
    }
    
    fclose(fp_in);
    fclose(fp_out);
    
    return 0;
}



