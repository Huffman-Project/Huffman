package solution_naive;
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
		arbre.parcourArbre(arb, "");
		
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
	
	
	

}
