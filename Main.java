import java.util.*;

public class Main {

	public static void main(String[] args) {
		String text = "cette phrase est un test";
		
		Lettres lettres= new Lettres();
		char[] list = lettres.trouverLettres(text);
		ArbreN arbre = new ArbreN();
		ArrayList<ArbreN> alist = arbre.arbreInit(list);
		
		ArbreN arb = arbre.arbre_huffman(alist);
		System.out.println(arb.valeur);
	}

}
