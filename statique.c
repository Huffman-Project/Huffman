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
		lettre valeur;
		//valeur de l'arbre est la lettre 
		lettre poid;
		//poid de l'arbre est la frequence
		struct arbre *gauche;
		struct arbre *droite;
	}arbre;
	
	arbre arbres[50];
	int i;
	
	//on initialise tout les lettres qu'on a sous forme d'arbres qui n'ont pas de fils i.e des feuilles
	//ensuite on les ajoute dans une liste arbres
	for (i=0; i < 43; i++) {
		arbre noeud;
		noeud.valeur = frequence[i].c;
		noeud.poid = frequence[i].f;
		noeud.gauche = NULL;
		noeud.droite = NULL;
		arbres[i] = noeud;
	}
	
	return 0;
} 
