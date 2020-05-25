
public class Main {
	
	public static void main(String[] args) {
		
		String texte = "Huffman est un algorithme de compression de données";
		
		Huffman huffman = new Huffman();

		//************** codage ***************//
		
		//String texte = huffman.lireFichier("texte.txt");
		huffman.encodage(texte);
		
		//************** decodage *************//
		
		String binaire = huffman.lireFichier("codeBinaire.txt");
		huffman.decodage(binaire);
		
		
		
				
	}

}

















