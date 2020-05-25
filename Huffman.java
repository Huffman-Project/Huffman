import java.util.ArrayList;
import java.util.Map;

public class Huffman {

	public void encodage(String texte) {
		//obtenir les elements avec leurs frequences
		Frequence  frequence= new Frequence();
		Map<Character,Integer> map = frequence.lettre_occ(texte) ;
		
		//trier les elements par frequence 
		SortByFreq sortByFreq = new SortByFreq(map);
		Map<Character,Integer> newMap = sortByFreq.sortByValue() ;
		//export liste des frequences
		frequence.ecrireFrequences(newMap);
		
		//cr�er une feuille pour chaque caract�re avec la fr�quence associ�e
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
		CodeBin code = new CodeBin();
		code.texteEnBinaire(noeuds,texte);
	}
	
	public void decodage(String binaire) {
		//obtenir les elements avec leurs frequences
		Frequence  frequence= new Frequence();
		Map<Character,Integer> map = frequence.lireFrequences("lettres.txt");
		
		//reconstruire l'arbre
		ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
		for ( Map.Entry<Character,Integer> entry : map.entrySet()) {
			Noeud noeud = new Noeud(entry.getValue(),null,null);
			noeud.lettre = entry.getKey();
			noeuds.add(noeud);
        }
		Arbre arbre = new Arbre(map);
		Noeud racine = arbre.construire(noeuds);
		arbre.parcArbre(racine, "");
		
		//decoder le code binaire et creer un fichier contenant le texte
		CodeBin code = new CodeBin();
		code.binaireEnTexte(noeuds,binaire);
	}
	
}



















