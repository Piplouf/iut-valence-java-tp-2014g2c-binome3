/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Carte {
    /** TODO. */
    private final Couleur couleur;
    /** TODO. */
    private final Numero  numero;
    /** TODO. */
    private boolean estFaceCachee;

    
    /* TODO Peut-Ãªtre pourriez-vous faire un constructeur avec un Ã©tat "false" par dÃ©faut ? */
  	public Carte(Couleur coul, Numero num, boolean etat) {
          this.couleur = coul;
          this.numero = num;
          this.estFaceCachee = etat;
      }
  	
    public Numero numero() {
        return numero;
    }

    public Couleur couleur() {
        return couleur;
    }

    public boolean estFaceCachee() {
        return estFaceCachee;
    }

  

    public void retourner(){
    	this.estFaceCachee = !(this.estFaceCachee); 
    }
    
    public boolean estDeFamilleDeCouleurDifferente(Carte carte){
		
    	return !(this.couleur.obtenirFamilleDeCouleur().equals(carte.couleur.obtenirFamilleDeCouleur()));
    }

	public boolean estDeNumeroSuivant(Carte carte) {
		if(this.numero.obtenirNumeroSuivant() == carte.numero)
			return true;
		
		return false;
	}
	
	public boolean estDeNumeroPrecedent(Carte carte) {
		if(this.numero.obtenirNumeroPrecedent() == carte.numero)
			return true;
		return false;
	}
	
	public String toString() {
		return estFaceCachee() ? "Carte cachée.\n" 
				: String.format("Numéro : %s Couleur : %s.\n", numero, couleur);
	}

}
