import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Complexity {
	
    Frequences frq = new Frequences();
    CodageDecod codage = new CodageDecod();
	
    
    //fonction qui g�n�re un string de caract�res al�atoire et de longueur 'taille' donn�e en input
	String genere_text(int taille) {
		String text = "";
		while(text.length() < taille) {
			Random randomNbr = new Random();
			int maxLenght = frq.lettres.length;
			char caractere = frq.lettres[(randomNbr.nextInt(maxLenght))];
			text += caractere;
		}
		return text;
    }
	
	//fonction qui return le temps moyen d'ex�cution du codage d'un String donn�
	long temps(String text) {
		long moy = 0;
		for(int i=0;i<50;i++) {
		long start = System.nanoTime();
		codage.Codage(text, codage.huffman());
		long end = System.nanoTime();
        long temps = end - start;
        moy += temps;
        }
		moy = moy/50;
        return moy;
	}
	
	//fonction qui g�n�re 50fois un string de longueur 'taille' donn�e en input et qui calcule � chaque 
	//fois le temps d'ex�cution du codage de ces mots et retourn la moyenne
	long tempsfinal(int taille) {
		long t = 0;
		for(int i=0;i<50;i++) {
			double buff = temps(genere_text(taille));
			
			t += buff;
		}
		t = t/50;
		System.out.println(t);
		return t;
	}
	
	//une fonction qui cr�e un fichier et le remplie avec des couples (longueur du text,temps d'ex�cution)
	void genere_fichier() throws Exception {
		
		File fichier = new File("c:\\Users\\dell\\Desktop\\output.txt");
		if (!fichier.isFile()) {
		    fichier.createNewFile();
		   }
		
		int taille = 5;
		for(int i=0;i<500;i++) {
			long temps = this.tempsfinal(taille);
			FileWriter f = new FileWriter("c:\\Users\\dell\\Desktop\\output.txt", true);
			PrintWriter writer = new PrintWriter(f);
			writer.write(taille + " " + temps + "\n");
			writer.close();
			taille += 10;
		}
	}
	
}
