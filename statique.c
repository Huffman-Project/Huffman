#include <stdio.h> 

int main() 
{ 
	double table[90][5] = {{(double)'e',12.10},{(double)'a',7.11},{(double)'i',6.59},
	{(double)'s',6.51},{(double)'n',6.39},{(double)'r',6.07},{(double)'t',5.92},
	{(double)'o',5.02},{(double)'l',4.96},{(double)'u',4.49},{(double)'d',3.67},
	{(double)'c',3.18},{(double)'m',2.62},{(double)'p',2.49},{(double)'�',1.94},
	{(double)'g',1.23},{(double)'b',1.14},{(double)'v',1.11},{(double)'h',1.11},
	{(double)'f',1.11},{(double)'q',0.65},{(double)'y',0.46},{(double)'x',0.38},
	{(double)'j',0.34},{(double)'�',0.31},{(double)'�',0.31},{(double)'k',0.29},
	{(double)'w',0.17},{(double)'z',0.15},{(double)'�',0.08},{(double)'�',0.06},
	{(double)'�',0.04},{(double)'�',0.03},{(double)'�',0.03},{(double)'�',0.02},
	{(double)'�',0.02},{(double)'�',0.01},{(double)'�',0.01},{(double)'�',0.01},
	{(double)'�',0.01},{(double)'�',0.01},{(double)'�',0.01},{(double)'�',0.01}};
	double a = table[0][0];
	double b = table[0][1];
	char c = a;
	printf("la frequence de %f qui repesente %c est %f", a, c, b );
	
	
	typedef struct Arbre {
		int valeur;
		struct Arbre *Agauche;
		struct Arbre *Adroite;
	}Arbre;
	
	return 0;
} 

