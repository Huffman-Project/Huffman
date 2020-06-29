package solution_naive;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		String text = "cette phrase est un test!";
		
		Lettres lettres= new Lettres();
		char[] list = lettres.trouverLettres(text);
		ArbreN arbre = new ArbreN();
		ArrayList<ArbreN> alist = arbre.arbreInit(list);
		
		ArbreN arb = arbre.arbre(alist);
		arbre.parcourArbre(arb, "");
		
		
		Codage_decodage codage = new Codage_decodage();
		codage.Codage(text, alist);	
		
		
		String code = "10000000100100001010000010100000100100001011000011000000110100001110000011110000000000001001000010110000100100000000000010100000101100000010000001000000101100001010000010010000000000001010000001100000";
		codage.Decodage(code, list);
		
		/*
		Coplx complexite = new Coplx();
		complexite.genere_fichier();*/
		
		
	}

}
