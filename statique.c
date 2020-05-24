#include <stdio.h> 
#include <stdlib.h>
#include <string.h>


int main() 
{ 
	typedef struct lettre {
		char c;
		double f;
	}lettre;
		
	
	lettre frequence[50] = {{'e',12.10},{'a',7.11},{'i',6.59},
	{'s',6.51},{'n',6.39},{'r',6.07},{'t',5.92},
	{'o',5.02},{'l',4.96},{'u',4.49},{'d',3.67},
	{'c',3.18},{'m',2.62},{'p',2.49},{'é',1.94},
	{'g',1.23},{'b',1.14},{'v',1.11},{'h',1.11},
	{'f',1.11},{'q',0.65},{'y',0.46},{'x',0.38},
	{'j',0.34},{'è',0.31},{'à',0.31},{'k',0.29},
	{'w',0.17},{'z',0.15},{'ê',0.08},{'ç',0.06},
	{'ô',0.04},{'â',0.03},{'î',0.03},{'û',0.02},
	{'ù',0.02},{'ï',0.01},{'á',0.01},{'ü',0.01},
	{'ë',0.01},{'ö',0.01},{'á',0.01},{'í',0.01}};
	
	
	
	typedef struct arbre {
		double valeur;
		//valeur de l'arbre est la frequence 
		char poid;
		//poid de l'arbre est la lettre
		struct arbre *gauche;
		struct arbre *droit;
	}arbre;
	
	struct arbre arbres[50];
	int i;
	
	//on initialise tout les lettres qu'on a sous forme d'arbres qui n'ont pas de fils i.e des feuilles
	//ensuite on les ajoute dans une liste arbres
	for (i=0; i < 43; i++) {
		arbre noeud;
		noeud.valeur = frequence[i].f;
		noeud.poid = frequence[i].c;
		noeud.gauche = NULL;
		noeud.droit = NULL;
		arbres[i] = noeud;
	}
	
	//maintenant on va parcourir la liste arbres, on va prendre les 2 premièrs sous arbres, sommer leurs 
	//poids, creer un nouveau arbre, son poid et la somme calculée, son arbre gauche et droit sont les 
	// deux sous arbres.
	
		arbre findMin (arbre arbre0[100], arbre arbreAeffacer) {
		bool a = memcmp(&arbre0[0], &arbreAeffacer, sizeof(arbre0[0]));
		
		//arbre min = arbre0[0] != arbreAeffacer ? arbre0[0] : arbre0[1];
		arbre min = a ? arbre0[1] : arbre0[0];
		int i;
		for (i=0;i<100;i++) {
			bool b = memcmp(&arbre0[i], &arbreAeffacer, sizeof(arbre0[0]));
			if(b && arbre0[i].valeur != 0) {
				min = arbre0[i].valeur > min.valeur ? min : arbre0[i];
			}
		}
		return min;
	}
	
	//definir un arbre null
	arbre arbre_null;
	arbre_null.valeur = -1;
	arbre_null.gauche = NULL;
	arbre_null.droit = NULL;
	
	
	arbre* supprimeNoeud (arbre arbre0[100],arbre noeudAsupp) {
		int i;
		for (i=0;i<100;i++) {
			bool a = memcmp(&arbre0[i], &noeudAsupp, sizeof(arbre0[i]));
			if(a) {
				int j;
				arbre0[100] = arbre_null;
				for (j=i;j<100;j++) {
					arbre0[j] = arbre0[j+1];
				}
			}
		}
		return arbre0;
	}
	
	bool feuille(arbre arb) {
		bool a = memcmp(&arb.droit,&arbre_null, sizeof(arb.droit));
		bool b = memcmp(&arb.gauche,&arbre_null, sizeof(arb.gauche));
		return (a && b);
	}
	
	
	//algo de huffman retourne l'arbre final
	arbre huffman(arbre arbre0[100]) {
		arbre arbre_final;
		bool flag = true;
		int i;
		while (flag){
			flag = false;
			for(i=0;i<100;i++) {
				if(arbre0[i].valeur != -1) {
					flag = true;
				}
			}
			arbre min1 = findMin(arbre0,arbre_null);
			arbre min2 = findMin(arbre0,min1);
			arbre_final.valeur = min1.valeur + min2.valeur;
			arbre_final.gauche = &min1;
			arbre_final.droit = &min2;
			supprimeNoeud(arbre0,min1);
			supprimeNoeud(arbre0,min2);	
		}
		return arbre_final;
	}
	
	
	
	void parcourir_arb (arbre racine, char codeBin[8]) {
		if (feuille(racine)) {
			strcpy(racine.bin,codeBin) ;
			printf("%c : %s",racine.poid, codeBin);
		}
		else {
			char buff0[8];
			char buff1[8];
			strcpy(buff0,codeBin);
			strcpy(buff1,codeBin);
			parcourir_arb(*racine.gauche,strcat(buff0,"0"));
			parcourir_arb(*racine.droit, strcat(buff1,"1"));
		}
	}
	
    
	arbre racine = huffman(arbres);
	printf("fuck u\n");
	parcourir_arb(racine,"");
	
	
	
	
	
	return 0;
} 
