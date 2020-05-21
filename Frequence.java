import java.util.*;

//class pour obtenire frequence de chaque lettre
public class Frequence {
	

	
	String chaine;
	//map comme un dictionnaire pour stocker une clé et une valeur
	Map<Character,Integer> map = new HashMap<Character,Integer>();
	
	//constructor 
	Frequence(String chaine) {
		this.chaine = chaine;
	}
	
	
	public Map<Character,Integer> lettre_occ() {
		int i, j; 
		int occur;
		char lettre1, lettre2;
		int taille = chaine.length();
		
		//parcourir la chaine
		for(i=0; i<taille; i++ ){  
			lettre1 = (chaine.toLowerCase()).charAt(i); 
			occur = 1;
			j = -1;
			
			
			do {
				j++;
				lettre2 = (chaine.toLowerCase()).charAt(j); 
			} while( ( j<i ) && ( lettre1!=lettre2 ) );
			
			
			if( j==i ) {
				for(j=i+1; j<taille; j++) {
					lettre2 = (chaine.toLowerCase()).charAt(j);
					if(lettre1 == lettre2)
						occur++;
				}
			
			//stocker
			 map.put(lettre1 , occur);
			}	
		}
		return map;
	}

}
