import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		
		Map<Character,Integer> map ;
		
		String texte = "est natus enim nihil est dolore omnis voluptatem numquam "
				+ "et omnis occaecati quod ullam at voluptatem error expedita pariatur"
				+ " nihil sint nostrum voluptatem reiciendis et est natus enim nihil est"
				+ " dolore omnis voluptatem numquam et omnis occaecati quod ullam at voluptatem "
				+ "error expedita pariatur nihil sint nostrum voluptatem reiciendis et est natus ";
		
		
		
		//obtenir les elements avec leurs frequences
		Frequence  frequence= new Frequence(texte);
		map = frequence.lettre_occ() ;
		
		//trier les elements par frequence 
		SortByFreq sortByFreq = new SortByFreq(map);
		Map<Character,Integer> newMap = sortByFreq.sortByValue() ;
		
		//créer une feuille pour chaque caractère avec la fréquence associée
		ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
		for ( Map.Entry<Character,Integer> entry : newMap.entrySet()) {
			Noeud noeud = new Noeud(entry.getKey(),entry.getValue(),null,null);
			noeuds.add(noeud);
        }
		
		
		
		
				
	}

}