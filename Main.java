import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		
		
		String texte = "Huffman est un algorithme de compression de données";
		
		
		//obtenir les elements avec leurs frequences
		Frequence  frequence= new Frequence(texte);
		Map<Character,Integer> map = frequence.lettre_occ() ;
		
		//trier les elements par frequence 
		SortByFreq sortByFreq = new SortByFreq(map);
		Map<Character,Integer> newMap = sortByFreq.sortByValue() ;
		
		//créer une feuille pour chaque caractère avec la fréquence associée
		ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
		for ( Map.Entry<Character,Integer> entry : newMap.entrySet()) {
			Noeud noeud = new Noeud(entry.getValue(),null,null);
			noeud.lettre = entry.getKey();
			noeuds.add(noeud);
        }
		
		//construire l'arbre et retourne la racine
		Arbre arbre = new Arbre(map);
		Noeud racine = arbre.construire(noeuds);
		
		//parcourir l'arbre pour generer les codes pour chaque lettre
		arbre.parcArbre(racine, "");
		
		//coder le texte et creer un fichier contenant le code
		Codage codage = new Codage(noeuds,texte);
		codage.texteEnBinaire();
				
	}

}