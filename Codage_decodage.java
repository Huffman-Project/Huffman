package solution_naive;
import java.io.*;
import java.util.ArrayList;

public class Codage_decodage {
	
	
	String Codage(String text, ArrayList<ArbreN> arb) {
		String code = "";
		for (int i=0; i<text.length();i++) {
			char lettre = text.charAt(i);
			for(int j=0; j<arb.size();j++) {
				if(lettre == (char)arb.get(j).valeur) {
					code = code + arb.get(j).codeBin;
				}
			}
		}
		System.out.println("le codage de cette phrase:'"+text+"' "+"est les suivant:\n"+code);
		return code;
	}
	
	void Decodage(String code,char[] lettres) {
		ArbreN arbre = new ArbreN();
		ArrayList<ArbreN> alist = arbre.arbreInit(lettres);
		
		ArbreN arb = arbre.arbre_huffman(alist);
		int prof = arb.profondeur(arb);
		arbre.parcourArbre(arb, "",prof);
		
		int longueur = alist.get(0).codeBin.length();
		
		String text ="";
		String buffer = "";
		for(int i=0; i<code.length();i+=longueur) {
			buffer = code.substring(i,i+longueur);
			for(ArbreN noeud : alist) {
				if(noeud.codeBin.equals(buffer)) {
					text += (char)noeud.valeur;
				}
			}
		}
		System.out.println(text);
	}
	
	
	//pour generer un fichier qui contient une liste des longueurs de textes et les longueurs de leurs codes
	void Performance (String[] lignes,ArrayList<ArbreN> arb) throws Exception{
		File fichier = new File("c:\\Users\\dell\\Desktop\\output.txt");
		if (!fichier.isFile()) {
		    fichier.createNewFile();
		   }
		
		String text = "";
		
		for (String ligne : lignes) {
			text +=ligne;
			String code = Codage(text,arb);
			
			FileWriter f = new FileWriter("c:\\Users\\dell\\Desktop\\output.txt", true);
			PrintWriter writer = new PrintWriter(f);
			writer.write(text.length() + " " + code.length() + "\n");
			writer.close();
			
			}
	}

}
