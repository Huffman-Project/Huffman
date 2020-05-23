package huff;



public class Frequences {
	
	
	char [] lettres = {'e','a','i','s','n','r','t','o','l','u','d','c','m','p','é','g','b','v','h',
			'f','q','y','x','j','è','à','k','w','z','ê','ç','ô','â','î','û','ù','ï','á','ü',
			'ë','ö','á','í'};
	
	double [] frequences = {12.10,7.11,6.59,6.51,6.39,6.07,5.92,4.96,4.49,3.67,3.18,2.62,2.49,1.94,
			1.23,1.14,1.11,1.11,1.11,0.65,0.46,0.38,0.34,0.31,0.31,0.29,0.17,0.15,0.08,0.06,
			0.04,0.03,0.03,0.02,0.02,0.01,0.01,0.01,0.01,0.01,0.01,0.01};
	
	
	double frq_table[] = new double[255];
	double [] frq () {
		for (int i=0; i<lettres.length-1; i++) {
			int indice = (int)lettres[i];
			frq_table[indice] = frequences[i];
		}
		return frq_table;
	}
	
	
}
