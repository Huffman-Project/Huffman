import java.util.*;
;

public class Main {
	
	

	public static void main(String[] args) {
		
		Map<Character,Float> map ;
		
		String texte = "est natus enim nihil est dolore omnis voluptatem numquam "
				+ "et omnis occaecati quod ullam at voluptatem error expedita pariatur"
				+ " nihil sint nostrum voluptatem reiciendis et est natus enim nihil est"
				+ " dolore omnis voluptatem numquam et omnis occaecati quod ullam at voluptatem "
				+ "error expedita pariatur nihil sint nostrum voluptatem reiciendis et est natus ";
		
		
		
		// creer l'objet frequence
		Frequence  frequence= new Frequence(texte);
		map = frequence.lettre_occ() ;
		
		System.out.println(map);
				
	}

}