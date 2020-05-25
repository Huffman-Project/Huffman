package solution_naive;

import java.util.ArrayList;

public class Codage_decodage {
	
	void Codage(String text, ArrayList<ArbreN> arb) {
		String code = "";
		for (int i=0; i<text.length();i++) {
			char lettre = text.charAt(i);
			for(int j=0; j<arb.size();j++) {
				if(lettre == (char)arb.get(j).valeur) {
					code = code + arb.get(j).codeBin;
				}
			}
		}
		System.out.println("le codage de cette phrase:'"+text+"' "+"est les suivant:\n"+code);
	}

}
