import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Huffman {
	
	public String lireFichier(String fileName) {
		String texte = "";
		
		try {
			File fichier = new File("src\\" + fileName);
			Scanner scanner = new Scanner(fichier);
			
			while (scanner.hasNextLine()) {
				String ligne = scanner.nextLine()  ;
				texte += ligne;
			}
			scanner.close();
			
			//System.out.println("fichier " + fileName + " est bien été lit");
			
			return texte;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void encodage(String texte) {
		//obtenir les elements avec leurs frequences
		Frequence  frequence= new Frequence();
		Map<Character,Integer> newMap = frequence.lettre_occ(texte) ;
		
		//trier les elements par frequence 
		//SortByFreq sortByFreq = new SortByFreq(map);
		//Map<Character,Integer> newMap = sortByFreq.sortByValue() ;
		//export liste des frequences
		frequence.ecrireFrequences(newMap);
		
		//créer une feuille pour chaque caractère avec la fréquence associée
		ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
		for ( Map.Entry<Character,Integer> entry : newMap.entrySet()) {
			Noeud noeud = new Noeud(entry.getValue(),null,null);
			noeud.lettre = entry.getKey();
			noeuds.add(noeud);
        }
		
		//construire l'arbre et retourne la racine
		Arbre arbre = new Arbre();
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
		Map<Character,Integer> map = frequence.lireFrequences("outputs\\lettres.txt");
		
		//reconstruire l'arbre
		ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
		for ( Map.Entry<Character,Integer> entry : map.entrySet()) {
			Noeud noeud = new Noeud(entry.getValue(),null,null);
			noeud.lettre = entry.getKey();
			noeuds.add(noeud);
        }
		Arbre arbre = new Arbre();
		Noeud racine = arbre.construire(noeuds);
		arbre.parcArbre(racine, "");
		
		//decoder le code binaire et creer un fichier contenant le texte
		CodeBin code = new CodeBin();
		code.binaireEnTexte(noeuds,binaire);
	}
	
	
	
	
	
	
	/******************************** performance **************************/
	
	
	public void ecrirePoints(int taille, long temps) {
		String fileName = "charts\\points.txt";
		try {
			FileWriter fichier = new FileWriter("src\\" + fileName, true);
			PrintWriter writer = new PrintWriter(fichier);
			writer.write(taille + " " + temps + "\n");
			writer.close();


		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public long temps(int taille) {
		
		long somme = 0;
		int iter = 0;
		int max_iter = 100;
		
		while(iter < max_iter) {
			
			//generer un texte
			String texte = "";
			while(texte.length() < taille) {
				Random randomNbr = new Random();
				char caractere = (char)(randomNbr.nextInt(25) + 'A');
				texte += caractere;
			}
			
			//mesurer le temps
			long start = System.nanoTime();
			this.encodage(texte);
	        long end = System.nanoTime();
	        long temps = end - start;
	        System.out.println("------ iter est : " + iter);
	        System.out.println("------ temps est : " + temps);

	        
        	somme += temps;
	        
	        
	        iter++;
			

		}
		long moyenne = somme/max_iter;
		return moyenne;
	}
	
	
}



















