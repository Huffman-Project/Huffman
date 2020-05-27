import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

//class pour obtenire frequence de chaque lettre
public class Frequence {
	
	public Map<Character,Integer> lettre_occ(String chaine) {
		//map comme un dictionnaire pour stocker une clé et une valeur
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int i, j; 
		int occur;
		char lettre1, lettre2;
		int taille = chaine.length();
		
		//parcourir la chaine
		for(i=0; i<taille; i++ ){  
			lettre1 = chaine.charAt(i); 
			occur = 1;
			j = -1;
			
			
			do {
				j++;
				lettre2 = chaine.charAt(j); 
			} while( ( j<i ) && ( lettre1!=lettre2 ) );
			
			
			if( j==i ) {
				for(j=i+1; j<taille; j++) {
					lettre2 = chaine.charAt(j);
					if(lettre1 == lettre2)
						occur++;
				}
			
			//stocker
			 map.put(lettre1 , occur);
			}	
		}
		return map;
	}
	
	
	public void ecrireFrequences(Map<Character,Integer> map) {
		String fileName = "outputs\\lettres.txt";
		
		try {
			File fichier = new File("src\\" + fileName);
			PrintWriter writer = new PrintWriter(fichier);
			
			for ( Map.Entry<Character,Integer> entry : map.entrySet()) {
				writer.write(entry.getKey() + "" + entry.getValue() + "\n");
	        }
			
			writer.close();

			//System.out.println("fichier " + fileName + " est bien été creé");
			//System.out.println("--------------------------------------");

		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Map<Character,Integer> lireFrequences(String fileName) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		try {
			File fichier = new File("src\\" + fileName);
			Scanner scanner = new Scanner(fichier);
			
			while (scanner.hasNextLine()) {
				String ligne = scanner.nextLine();
				//stocker
				 map.put(ligne.charAt(0), (int) ligne.charAt(1) - 48);
			}
			scanner.close();
			
			//System.out.println("fichier " + fileName + " est bien été lit");
			//System.out.println("--------------------------------------");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return map;
	}

}

















