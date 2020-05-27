
public class Main {
	
	public static void main(String[] args) {
		
		
		Huffman huffman = new Huffman();

		
		
		//************** codage ***************//
		String texte = huffman.lireFichier("inputs\\texte.txt");
		huffman.encodage(texte);
		
		
		//************** decodage *************//
		
		String binaire = huffman.lireFichier("outputs\\codeBinaire.txt");
		huffman.decodage(binaire);
		
		
		//******** mesurer la compléxité ********//

		//huffman.performance();
	}

}

















