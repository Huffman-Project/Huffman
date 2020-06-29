
public class Main {

	public static void main(String[] args) throws Exception {
		
        	CodageDecod codage = new CodageDecod();
		
		//encodage
		String text = "cette phrase est un test";
		codage.Codage(text,codage.huffman(text));
		
		//décodage
		String code = "1100001111111100111011111001110100101011000011101100100111111101111010111110111111001001111";
		codage.Decodage(code,text);
		
		
		//pour génerer le fichier qui nous permet de tracer la courbe de complexité
		
		/*Complexity comp = new Complexity();
		comp.genere_fichier();*/
		
	}

}
