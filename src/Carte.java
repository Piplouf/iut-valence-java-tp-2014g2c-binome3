/* TODO Javadoc ! */

public class Carte {
    /* TODO Peut changer en cours de partie ? */
    private final Couleur couleur;
    /* TODO Peut changer en cours de partie ? */
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

	public Carte(Couleur coul, Numero num, boolean etat) {
        this.couleur = coul;
        this.numero = num;
        this.etat = etat;
    }
    
    public void retournerCarte(){
    	if(this.etat = true)
    		this.etat = false;
    	else
    		this.etat = true;
    }
}
