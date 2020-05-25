import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CodeBin {
	
	public void texteEnBinaire(ArrayList<Noeud> noeuds, String texte) {
		String code_binaire = "";
		
		for (int i=0; i<texte.length(); i++) {
			char letter = texte.charAt(i);
			for (Noeud noeud : noeuds) {
				if(letter == noeud.lettre)
					code_binaire += noeud.code_binaire;
			}
		}
		
		try {
			File fichier = new File("C:\\Users\\Etudiant\\eclipse-workspace\\HuffmanSemiAdaptatif\\src\\codeBinaire.txt");
			PrintWriter writer = new PrintWriter(fichier);
			writer.write(code_binaire);
			writer.close();
			
			System.out.println("--------------------------------------");
			System.out.println("fichier codeBinaire.txt est bien été creé");
			System.out.println("code : " + code_binaire);
			System.out.println("--------------------------------------");

		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void binaireEnTexte(ArrayList<Noeud> noeuds, String binaire) {
		String texte = "";
		String lettre_code = "";
		
		for (int i=0; i<binaire.length(); i++) {
			String caractere = String.valueOf(binaire.charAt(i));
			lettre_code += caractere;
			
			for (Noeud noeud : noeuds) {
				if( (noeud.code_binaire).equals(lettre_code) ) {
					texte += noeud.lettre;
					lettre_code = "";
				}
			}
		}
		
		try {
			File fichier = new File("C:\\Users\\Etudiant\\eclipse-workspace\\HuffmanSemiAdaptatif\\src\\texte.txt");
			PrintWriter writer = new PrintWriter(fichier);
			writer.write(texte);
			writer.close();
			
			System.out.println("--------------------------------------");
			System.out.println("fichier texte.txt est bien été creé");
			System.out.println("--------------------------------------");
			System.out.println("texte : " + texte);
			

		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
