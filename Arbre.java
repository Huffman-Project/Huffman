import java.util.ArrayList;
import java.util.Map;

public class Arbre {
	Map<Character,Integer> map ;
	String lettresCodes = "" ;

	public Arbre(Map<Character, Integer> map) {
		super();
		this.map = map;
	}
	
	public Noeud construire(ArrayList<Noeud> noeuds){
		
		//faire une copie pour ne pas changer la liste original
		ArrayList<Noeud> copie = (ArrayList<Noeud>) noeuds.clone();
		
		/*
		une simple recherche des deux fréquences les plus faibles parmi les noeuds .
		affecter les fils.
		Jusqu’à ce qu’il ne reste plus qu’un seul racine.
		*/
		while(copie.size() > 1){
			Noeud plus_faible1 = chercher_min(copie, null);
			Noeud plus_faible2 = chercher_min(copie, plus_faible1);
			Noeud pere = new Noeud( plus_faible1.frequence + plus_faible2.frequence, plus_faible1, plus_faible2); 
			copie.add(0, pere);
			copie.remove(plus_faible1);
			copie.remove(plus_faible2);
		}
		
		//Retourne la racine de l'arbre
		return copie.get(0); 
	}
	
	
	public Noeud chercher_min(ArrayList<Noeud> noeuds, Noeud plus_faible1){
		//si la premiere noeud est la noeud plus faible1 on affecte la noeud suivant
		Noeud plus_faible = (noeuds.get(0) != plus_faible1) ? noeuds.get(0) : noeuds.get(1);
		
		for (Noeud noeud : noeuds) {
			if(noeud != plus_faible1)
				//affecter le plus faible
				plus_faible = plus_faible.compare(noeud);
		}
		return plus_faible;
	}

	
	public void parcArbre(Noeud racine, String code_binaire){
		
		if( (racine.fils_gauche == null) && (racine.fils_droite == null) ) {
			racine.code_binaire = code_binaire;
			lettresCodes += racine.lettre + " " + code_binaire + "\n";
			//System.out.println(racine.lettre + " " + code_binaire);
		} else {
			parcArbre(racine.fils_gauche, code_binaire + "0");
			parcArbre(racine.fils_droite, code_binaire + "1");			
		}
		
	}
	
	
	
	
}
