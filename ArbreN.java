package solution_naive;
import java.util.*;

public class ArbreN {
	

	int valeur;
	//valeur == la lettre
	String codeBin;
	ArbreN gauche;
	ArbreN droit;
	
	ArbreN() {};
	//constructeur de l'arbre
		ArbreN(int valeur,ArbreN gauche, ArbreN droit) {
			this.valeur = valeur;
			this.codeBin = "-1";
			this.gauche = gauche;
			this.droit = droit;
		};
	
	/*int ListLenght (char[] list) {
		int nbr=0;
		for(int i=0; i<list.length; i++) {
			if(list[i] != Character.MIN_VALUE) {
				nbr++;
			}
		}
		return nbr;
	}*/
	
		
	//initialiser tous les lettres qu'on a à des feuilles
	//cette methode return un tableau des arbres qui ont comme valeur le code Ascii de la lettre
	//et qui n'ont ni fils gauche ni fils droit i.e ce sont des feuilles	
	ArrayList<ArbreN> arbreInit (char[] list) {
		ArrayList<ArbreN> initArbre = new ArrayList<ArbreN>();
		for(int i=0; i<list.length; i++) {
			if(list[i] != Character.MIN_VALUE) {
				ArbreN arb = new ArbreN((int)list[i],null,null);
				initArbre.add(arb);
			}
		}
		return initArbre;		
	}
	
	
	
	@SuppressWarnings("unchecked")
	//construction de l'arbre de huffman
	ArbreN arbre_huffman (ArrayList<ArbreN> init) {
		ArrayList<ArbreN> arbre_final = (ArrayList<ArbreN>)init.clone();
		while(arbre_final.size() > 1) {
			ArbreN arb1 = arbre_final.get(0);
			ArbreN arb2 = arbre_final.get(1);
			ArbreN arb = new ArbreN(arb1.valeur + arb2.valeur,arb1,arb2);
			arbre_final.add(arbre_final.size(),arb);
			arbre_final.remove(arb1);
			arbre_final.remove(arb2);
		}
		return arbre_final.get(0);
	}
	
	//vérifier si l'arbre est une feuille
		boolean est_feuille (ArbreN arb) {
			if(arb.gauche == null && arb.droit == null) {
				return true;
			}
			else return false;
		}
		
	//parcourt l'arbre et attribue 0 pour le fils gauche et 1 pour le fils droit
	void parcourArbre (ArbreN racine,String codeBin,int prof) {
		if(est_feuille(racine)) {
			String codBin = normaliser(codeBin,prof);
			racine.codeBin = codBin;
			System.out.println((char)racine.valeur + " " + codBin);
		}
		else {
			parcourArbre(racine.gauche, codeBin + "0",prof);
			parcourArbre(racine.droit, codeBin + "1",prof);
		}
			
	}
		
	//calcule la profondeur de l'arbre
	int profondeur(ArbreN arb) {
		int i=0;
		while(!est_feuille(arb)) {
			i++;
			arb = arb.gauche;
		}
		return i;
	}
		
	//cette fonction ajoute des 0 à droite du code binaire pour que l'ensembre des lettres seront codées sur
	//le même nombre de bits
	String normaliser (String s,int prof) {
		int diff = prof-s.length()%prof;
		for (int i = 0; i < diff; i++) {
			s+="0";	
		}
		return s;
	}


}
