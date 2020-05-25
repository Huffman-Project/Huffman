package huff;

public class Main {
	
	public static void main(String[] args) {
						
		CodageDecod codage = new CodageDecod();
		
		String text = "cette phrase est un test";
		codage.Codage(text,codage.huffman());
		
		String code = "010100010101111101110000111011010111000001110100111001011111101010101101";
		codage.Decodage(code);
	}

}
