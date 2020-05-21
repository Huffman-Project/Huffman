
public class Noeud {
	
	char lettre;
	int frequence;
	Noeud fils_gauche;
	Noeud fils_droite;
	
	public Noeud(char lettre, int frequence, Noeud fils_gauche, Noeud fils_droite) {
		super();
		this.lettre = lettre;
		this.frequence = frequence;
		this.fils_gauche = fils_gauche;
		this.fils_droite = fils_droite;
	}
}
