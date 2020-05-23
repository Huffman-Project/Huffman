import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Codage {
	
	ArrayList<Noeud> noeuds;
	String texte;
	
	public Codage(ArrayList<Noeud> noeuds, String texte) {
		super();
		this.noeuds = noeuds;
		this.texte = texte;
	}



	public void texteEnBinaire() {
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
			System.out.println("code : " + code_binaire);
			System.out.println("fichier codeBinaire.txt est bien été creé");

		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
