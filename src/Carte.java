/* TODO Javadoc ! */
/* TODO Package. */

public class Carte {
    private final Couleur couleur;
    
    private final Numero  numero;
    
	private boolean etat;
    
	public Numero getNumero() {
		return numero;
	}
	
    public Couleur getCouleur() {
		return couleur;
	}

    public boolean isEtat() {
		return etat;
	}

    /* TODO Peut-être pourriez-vous faire un constructeur avec un état "false" par défaut ? */
	public Carte(Couleur coul, Numero num, boolean etat) {
        this.couleur = coul;
        this.numero = num;
        this.etat = etat;
    }

    /* TODO Pourquoi mettre "Carte" c'est implicite par l'appartenance à la classe "Carte". */
    public void retournerCarte(){
    	this.etat = !(this.etat); 
    }
  
}
