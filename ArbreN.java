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
	//construction de l'arbre 
	ArbreN arbre (ArrayList<ArbreN> init) {
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
	void parcourArbre (ArbreN racine,String codeBin) {
		if(est_feuille(racine)) {
			//System.out.println("feuille: " + (char)racine.valeur + "  son code ascii est " + racine.valeur);
			String codBin = normaliser(codeBin);
			racine.codeBin = codBin;
			System.out.println((char)racine.valeur + " " + codBin);
		}
		else {
			//System.out.println("racine: " + racine.valeur + " fils gauche: " + racine.gauche.valeur + " fils droit: " + racine.droit.valeur);
			parcourArbre(racine.gauche, codeBin + "0");
			parcourArbre(racine.droit, codeBin + "1");
		}
	}
		
		
	//cette fonction ajoute des 0 à droite du code binaire pour que l'ensembre des lettres seront codées sur
	//le même nombre de bits
	String normaliser (String s) {
		int diff = 8-s.length()%8;
		for (int i = 0; i < diff; i++) {
			s+="0";	
		}
		return s;
	}


}
