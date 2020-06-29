import java.util.ArrayList;
public class CodageDecod {
	
	//construit l'arbre et génère le tableau qui contient chque caractère et son code binaire
	ArrayList<Arbre> huffman(String text){
		Frequences frequence= new Frequences();
		double [] big_frq_table = frequence.frq();
		
		double [] frq_table = new double[255];
		for(int i=0; i<text.length(); i++) {
			char lettre = text.charAt(i);
			frq_table[(int)lettre] = big_frq_table[(int)lettre];
		}
		
		Arbre arbre = new Arbre();
		ArrayList<Arbre> arbre_init = arbre.arbre_init(frq_table);
		
		Arbre huffman_arbre = arbre.arbre_huffman(arbre_init);
		
		ArrayList<Arbre> tableauDesCodes = new ArrayList<Arbre>();
		tableauDesCodes = arbre.parcourArbre(huffman_arbre,"",tableauDesCodes);
		
		return tableauDesCodes;
	}
	
	//fonction récursive qui génère le code final du text donné en input
	String Codage(String text, ArrayList<Arbre> arb) {
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
		return code;
	}
	
	void Decodage(String code,String text_a_decoder) {
		ArrayList<Arbre> tableauDesCodes = huffman(text_a_decoder);
		
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
