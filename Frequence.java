import java.util.*;

//class pour obtenire frequence de chaque lettre
public class Frequence {
	

	
	String chaine;
	//map comme un dictionnaire pour stocker une clé et une valeur
	Map<Character,Float> map = new HashMap<Character,Float>();
	
	//constructor 
	Frequence(String chaine) {
		this.chaine = chaine;
	}
	
	
	public Map<Character,Float> lettre_occ() {
		int i, j; 
		float occur;
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
			float freq = (occur/taille) * 100;
			
			//stocker
			 map.put(lettre1 , freq);
			}	
		}
		return map;
	}

}
