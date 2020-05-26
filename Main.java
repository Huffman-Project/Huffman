package solution_naive;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		String text = "cette phrase est un test";
		
		//la liste qu'on a utilisé pour générer la courbe de la complexité
		/*String[] lignes = {"cadeaux","ciments","marbres","garants","terreur","soprano","inculpe","croyant",
				"rajoute","portent","jugeant","campent","anthony","cadeaux","cadeaux","cadeaux","cadeaux",
				"cadeaux","cadeaux","cadeaux","cadeaux","cadeaux","cadeaux","cadeaux","cadeaux","cadeaux",
				"cadeaux","mwxcvbn","fghjklm","azertyu","uiopqsd"};
		String text=" ";
		for(String ligne : lignes) {
			text += ligne;
		}*/
		
		Lettres lettres= new Lettres();
		char[] list = lettres.trouverLettres(text);
		ArbreN arbre = new ArbreN();
		ArrayList<ArbreN> alist = arbre.arbreInit(list);
		
		ArbreN arb = arbre.arbre_huffman(alist);
		arbre.parcourArbre(arb, "",arb.profondeur(arb));
		
		Codage_decodage codage = new Codage_decodage();
		codage.Codage(text, alist);				
		
		String code = "101000101100110000110000101100110100111000111100000000001000010000101100110100101100010000110000110100011000100000110100110000101100010000110000";
		codage.Decodage(code, list);
		
		//pour generer un fichier qui contient une liste des longueurs de textes et les longueurs de leurs codes
		/*	
		codage.Performance(lignes, alist);*/

	}

}
