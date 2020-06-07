package solution_naive;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Coplx {
	
		Codage_decodage codage = new Codage_decodage();
		Lettres lettres= new Lettres();
		ArbreN arbre = new ArbreN();
	
		//fonction qui génère un string de caractères aléatoire et de longueur 'taille' donnée en input
		String genere_text(int taille) {
			String text = "";
			while(text.length() < taille) {
				Random r = new Random();
				char c = (char)(r.nextInt(26) + 'a');
				text += c;
			}
			return text;
	    }
		
		//fonction qui return le temps moyen d'exécution du codage d'un String donné
		long temps(String text) {
			long moy = 0;
			for(int i=0;i<50;i++) {
				long start = System.nanoTime();
				char[] list = lettres.trouverLettres(text);
				ArrayList<ArbreN> alist = arbre.arbreInit(list);
				ArbreN arb = arbre.arbre_huffman(alist);
				arbre.parcourArbre(arb, "");
				codage.Codage(text, alist);
				long end = System.nanoTime();
				long temps = end - start;
				moy += temps;
	        }
			moy = moy/50;
	        return moy;
		}
		
		//fonction qui génère 50fois un string de longueur 'taille' donnée en input et qui calcule à chaque 
		//fois le temps d'exécution du codage de ces mots et retourn la moyenne
		long tempsfinal(int taille) {
			long t = 0;
			for(int i=0;i<50;i++) {
				t += temps(genere_text(taille));
			}
			t = t/50;
			System.out.println(t);
			return t;
		}
		
		//une fonction qui crée un fichier et le remplie avec des couples (longueur du text,temps d'exécution)
		void genere_fichier() throws Exception {
			
			File fichier = new File("c:\\Users\\dell\\Desktop\\outputN.txt");
			if (!fichier.isFile()) {
			    fichier.createNewFile();
			   }
			
			int taille = 5;
			for(int i=0;i<300;i++) {
				long temps = this.tempsfinal(taille);
				FileWriter f = new FileWriter("c:\\Users\\dell\\Desktop\\outputN.txt", true);
				PrintWriter writer = new PrintWriter(f);
				writer.write(taille + " " + temps + "\n");
				writer.close();
				taille += 10;
			}
		}

}
