
public class Main {
	
	public static void main(String[] args) {
		
		
		Huffman huffman = new Huffman();

		
		
		//************** codage ***************//
		//String texte = huffman.lireFichier("inputs\\texte.txt");
		//huffman.encodage(texte);
		
		
		//************** decodage *************//
		
		//String binaire = huffman.lireFichier("outputs\\codeBinaire.txt");
		//huffman.decodage(binaire);
		
		
		//******** mesurer la compléxité ********//

		
		
		int taille = 100;
		int max_taille = 5000;
		
		
		
		while(taille <= max_taille) {
			
			long somme = 0;
			int max_iter = 100;
			
			for (int i=0 ; i<max_iter; i++) {
			
				String texte = huffman.genererTexte(taille);
				long temps = huffman.temps(texte);
				somme += temps;
				
			}
			
			huffman.ecrirePoints(taille, somme/max_iter);
			
			taille += 100;
		}
		
		System.out.println("\n----------------       ok         ---------------------"); 
		
	}

}

















