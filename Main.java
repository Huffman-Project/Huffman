package huff;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		String text = "j aime gamoussa";
		
		Frequences frequence= new Frequences();
		double [] frq_table = frequence.frq();
		
		Arbre arbre = new Arbre();
		ArrayList<Arbre> arbre_init = arbre.arbre_init(frq_table);
		
		Arbre huffman_arbre = arbre.arbre_huffman(arbre_init);
		
		ArrayList<Arbre> tableauDesCodes = new ArrayList<Arbre>();
		tableauDesCodes = arbre.parcourArbre(huffman_arbre, "",tableauDesCodes);
		
		CodageDecod codage = new CodageDecod();
		codage.Codage(text,tableauDesCodes);
	}

}
