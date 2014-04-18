/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Carte {
    /**
     * Couleur de le carte (CARREAU,COEUR,PIQUE,TREFLE)
     */
    private final Couleur couleur;
    /** Numero de la carte (As,Deux,...) */
    private final Numero  numero;
    /** Etat de la carte, true si la carte est face cachée */
    private boolean estFaceCachee;

    
    /**
     * Créer une carte définit par une couleur, un numero et un etat
     * @param coul La couleur de la carte
     * @param num Le numero de la carte
     * @param etat L'etat de la carte
     */
  	public Carte(Couleur coul, Numero num, boolean etat) {
          this.couleur = coul;
          this.numero = num;
          this.estFaceCachee = etat;
      }
  	
    /**
     * Renvoi le numero de l'attribut numero de la carte
     * @return  numero de la carte
     */
  	public Numero numero() {
        return this.numero;
    }

  	 /**
     * Renvoi la couleur de l'attribut couleur de la carte
     * @return  numero de la carte
     */
    public Couleur couleur() {
        return this.couleur;
    }

    /**
     * Renvoi le booleen de l'attribut etat de la carte
     * @return  l'etat de la carte
     */
    public boolean estFaceCachee() {
        return this.estFaceCachee;
    }

  
    /**
     * Retourne la carte (inverse l'etat)
     */
    public void retourner(){
    	this.estFaceCachee = !(this.estFaceCachee); 
    }
    
    /**
     * Verifie si deux cartes sont de famille de couleurs differentes
     * @param carte Carte a comparé
     * @return true si elles sont de famille de couleurs differents
     */
    public boolean estDeFamilleDeCouleurDifferente(Carte carte){
		
    	return !(this.couleur.obtenirFamilleDeCouleur().equals(carte.couleur.obtenirFamilleDeCouleur()));
    }
    
    /**
     * Verifie si deux cartes sont de couleurs identiques
     * @param carte carte a comparé
     * @return true si elles sont de couleurs identiques
     */
    public boolean estDeCouleurIdentique(Carte carte){
    	return (this.couleur == carte.couleur);
    }

	/**
	 * Verifie si la carte est de numero suivant à la carte en parametre
	 * @param carte carte que l'on veut comparer
	 * @return true si la carte est de numero suivant
	 */
    public boolean estDeNumeroSuivant(Carte carte) {
		if(this.numero == carte.numero.obtenirNumeroSuivant())
			return true;
		
		return false;
	}
	
    /**
     * Verifie si la carte est de numero precedent à la carte en parametre
     * @param carte carte que l'on veut comparer
     * @return true si la carte est de numéro précedent
     */
	public boolean estDeNumeroPrecedent(Carte carte) {
		if(this.numero == carte.numero.obtenirNumeroPrecedent())
			return true;
		return false;
	}
	
	public String toString() {
		return estFaceCachee() ? "Carte cachée.\n" 
				: String.format("Numéro : %s Couleur : %s.\n", numero, couleur);
	}

}
