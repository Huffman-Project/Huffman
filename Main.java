
public class Main {
	
	public static void main(String[] args) {
		
		
		//Huffman huffman = new Huffman();

		
		
		//************** codage ***************//
		//String texte = huffman.lireFichier("inputs\\texte.txt");
		//huffman.encodage(texte);
		
		
		//************** decodage *************//
		
		//String binaire = huffman.lireFichier("outputs\\codeBinaire.txt");
		//huffman.decodage(binaire);
		
		
		//******** mesurer la compléxité ********//

		
		
		
		int taille = 10;
		int max_taille = 50000;
		
		while(taille <= max_taille) {
			Huffman huffman = new Huffman();
			long temps = huffman.temps(taille);
			huffman.ecrirePoints(taille,temps);
			taille += 10;
			
		}
		
		System.out.println("\n----------------       ok         ---------------------");
		
	}

}

















