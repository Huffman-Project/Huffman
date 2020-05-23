package huff;

import java.util.*;

public class Arbre {
	
	double valeur;
	//valeur == frequence
	char poid;
	//poid == la lettre
	String codeBin;
	Arbre gauche;
	Arbre droit;
	
	Arbre() {};
	Arbre(double valeur,Arbre gauche, Arbre droit) {
		this.valeur = valeur;
		this.codeBin = "-1";
		this.gauche = gauche;
		this.droit = droit;
	};
	
	//initialiser tous les lettres qu'on a à des feuilles
	//cette methode return un tableau des arbres qui ont comme valeur les fréquences et comme poids les lettres
	//et qui n'ont ni fils gauche ni fils droit i.e ce sont des feuilles
	ArrayList<Arbre> arbre_init (double [] frq_table) {
		ArrayList<Arbre> init = new ArrayList<Arbre>();
		int j=0;
		for (int i=0; i<frq_table.length; i++) {
			if(frq_table[i]!=0) {
				Arbre feuille = new Arbre(frq_table[i],null,null);
				feuille.poid = (char)i;
				init.add(j, feuille);
				j++;
			}
		}
		return init;
	}
	
	// une fonction qui trouve la fréquence minimale 
	Arbre trouveMin(ArrayList<Arbre> arb, Arbre arbreAeffacer) {
		Arbre min = arb.get(0) != arbreAeffacer ? arb.get(0) : arb.get(1);
		
		for(Arbre i : arb) {
			if(i != arbreAeffacer) {
				min = i.valeur < min.valeur ? i : min;
			}
		}
		return min;
	}
	
	@SuppressWarnings("unchecked")
	//construction de l'arbre de huffman
	Arbre arbre_huffman (ArrayList<Arbre> init) {
		ArrayList<Arbre> arbre_final = (ArrayList<Arbre>)init.clone();
		while(arbre_final.size() > 1) {
			Arbre min1 = trouveMin(arbre_final,null);
			Arbre min2 = trouveMin(arbre_final,min1);
			Arbre sup = new Arbre(min1.valeur + min2.valeur,min1,min2);
			arbre_final.add(0,sup);
			arbre_final.remove(min1);
			arbre_final.remove(min2);
		}
		return arbre_final.get(0);
	}
	
	//vérifier si l'arbre est une feuille
	boolean est_feuille (Arbre arb) {
		if(arb.gauche == null && arb.droit == null) {
			return true;
		}
		else return false;
	}
	
	//parcourt l'arbre et attribue 0 pour le fils gauche et 1 pour le fils droit
	void parcourArbre (Arbre racine,String codeBin) {
		if(est_feuille(racine)) {
			racine.codeBin = codeBin;
			System.out.println(racine.poid + " " + codeBin);
		}
		else {
			parcourArbre(racine.gauche, codeBin + "0");
			parcourArbre(racine.droit, codeBin + "1");
		}
		
	}
}
