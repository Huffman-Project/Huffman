
public class Main {

	public static void main(String[] args) throws Exception {
		
        	CodageDecod codage = new CodageDecod();
		
		//encodage
		String text = "cette phrase est un test";
		codage.Codage(text,codage.huffman());
		
		//décodage
		String code = "010100010101111101110000111011010111000001110100111001011111101010101101";
		codage.Decodage(code);
		
		
		//pour génerer le fichier qui nous permet de tracer la courbe de complexité
		
		/*Complexity comp = new Complexity();
		comp.genere_fichier();*/
		
	}

}
