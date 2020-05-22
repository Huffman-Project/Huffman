
public class Noeud {
	
	char lettre;
	int frequence;
	Noeud fils_gauche;
	Noeud fils_droite;
	String code_binaire;
	
	public Noeud(int frequence, Noeud fils_gauche, Noeud fils_droite) {
		super();
		this.frequence = frequence;
		this.fils_gauche = fils_gauche;
		this.fils_droite = fils_droite;
		this.code_binaire = "-1";
	}
	
	public Noeud compare(Noeud noeud){
		return this.frequence<=noeud.frequence ? this : noeud; 
	}
	
	
	
}
