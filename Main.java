
public class Main {
	
	public static void main(String[] args) {
		
		
		String texte = "Huffman est un algorithme de compression de donn�es";
		String binaire = "110000100111111111111100011110001101011000100101011001100110111110010011110011110111101111001001011000110000111010101011101110010110110000100011101011000000111001101001101010101110101011101001001010010011000";
		
		Huffman huffman = new Huffman();
		
		//************** codage *************//
		huffman.encodage(texte);
		
		//************** decodage *************//
		huffman.decodage(binaire);
		
				
	}

}

















