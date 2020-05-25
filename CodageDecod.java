package huff;

import java.util.ArrayList;

public class CodageDecod {
	
	ArrayList<Arbre> huffman(){
		Frequences frequence= new Frequences();
		double [] frq_table = frequence.frq();
		
		Arbre arbre = new Arbre();
		ArrayList<Arbre> arbre_init = arbre.arbre_init(frq_table);
		
		Arbre huffman_arbre = arbre.arbre_huffman(arbre_init);
		
		ArrayList<Arbre> tableauDesCodes = new ArrayList<Arbre>();
		tableauDesCodes = arbre.parcourArbre(huffman_arbre,"",tableauDesCodes);
		
		return tableauDesCodes;
	}
	
	void Codage(String text, ArrayList<Arbre> arb) {
		String code = "";
		for (int i=0; i<text.length();i++) {
			char lettre = text.charAt(i);
			for(int j=0; j<arb.size();j++) {
				if(lettre == (char)arb.get(j).valeur) {
					code = code + arb.get(j).codeBin +" ";
				}
			}
		}
		System.out.println("le codage de cette phrase:'"+text+"' "+"est les suivant:\n"+code);
	}
	
	void Decodage(String code) {
		ArrayList<Arbre> tableauDesCodes = huffman();
		
		String buffer = "";
		String text = "";
		for(int i=0; i<code.length();i++) {
			buffer += String.valueOf(code.charAt(i));
			for(Arbre arb : tableauDesCodes) {
				if(arb.codeBin.equals(buffer)) {
					text += (char)arb.valeur;
					buffer = "";
				}
			}
		}
		System.out.println("ce code s'interprète comme suit : "+text);
	}

}
