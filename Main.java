package huff;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Frequences frequence= new Frequences();
		double [] frq_table = frequence.frq();
		
		Arbre arbre = new Arbre();
		ArrayList<Arbre> arbre_init = arbre.arbre_init(frq_table);
		
		Arbre huffman_arbre = arbre.arbre_huffman(arbre_init);
		
		arbre.parcourArbre(huffman_arbre, "");
	}

}
