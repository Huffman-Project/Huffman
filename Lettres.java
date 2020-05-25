package solution_naive;

public class Lettres {

	//retourne la liste de toutes les lettres existantes dans le text
	char[] trouverLettres(String text) {
		char[] lettres = new char[text.length()];
		for (int i=0; i<text.length();i++) {
			char lettre = text.charAt(i);	
			boolean flag = false;
			while(!flag) {
				for (int j=0; j<=i;j++) {
					if(lettre == lettres[j]) {
						flag= true;
						break;
					}
				}
				break;
			}
			if(!flag) {
				lettres[i] = lettre;
			}
		}
		return lettres;
	}
	
}
