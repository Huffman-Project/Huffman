import java.util.ArrayList;

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
		int i=0;
		while(arbre_final.size() > 1) {
			ArbreN arb = new ArbreN(init.get(i).valeur + init.get(i+1).valeur,init.get(i),init.get(i+1));
			arbre_final.add(0,arb);
			arbre_final.remove(init.get(i));
			arbre_final.remove(init.get(i+1));
			i++;
		}
		return arbre_final.get(0);
	}

}
