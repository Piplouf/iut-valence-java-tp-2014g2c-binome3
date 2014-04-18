package fr.iutvalence.java.tp.g2c.binome3;


/**
 * Pile couleur qui h�rite de Pile
 * Pile couleur sont les piles qui contiendront les cartes finales. Elles sont 
 * r�gies par des r�gles diff�rentes que les piles courrantes
 * @author maruejof
 *
 */
public class PileCouleur extends Pile{
	
	/**
	 * Cr�e une pile vide ne contenant aucune carte
	 */
	PileCouleur(){
		super();
	}
	
	/**
	 * Verifie si le deplacement est possible pour une pile de couleur
	 * @param pile pile sur laquelle on souhaite deplacer notre pile
	 * @return true si le deplacement est possible
	 */
	protected boolean deplacementEstPossible(Pile pile){
    	if(couleurEstIdentique(pile) && carteEstLaSuivante(pile))
    		return true;
    	return false;
    }
 
    /**
     * Verifie si la carte au sommet de la pile est identique � celle en bas de la pile d'arriv�e
     * @param pile pile sur laquelle on souhaite deplacer notre pile
     * @return true si elles sont de couleur identique
     */
    private boolean couleurEstIdentique(Pile pile) {
    	Carte carteAVerifier = null;
		for (int i = 0; i < this.cartes.size(); i++)
			if (!(this.cartes.get(i).estFaceCachee()))
				carteAVerifier = this.cartes.get(i);
		if (!pile.cartes.isEmpty() && carteAVerifier != null)
			if (carteAVerifier.estDeCouleurIdentique(pile.cartes.peek()))
				return true;
		if(carteAVerifier == null && pile.cartes.peek().numero() == Numero.AS)
			return true;
		return false;
	}

	/**
	 * Verifie si le carte est la suivante par rapport � la pile d'arrivee
	 * @param pile pile sur laquelle on veut deplacer notre pile
	 * @return true si la carte est la suivante
	 */
    private boolean carteEstLaSuivante(Pile pile) {
		Carte carteAVerifier = null;
		for (int i = 0; i < this.cartes.size(); i++)
			if (!(this.cartes.get(i).estFaceCachee()))
				carteAVerifier = this.cartes.get(i);
		if (!pile.cartes.isEmpty() && carteAVerifier != null)
			if (carteAVerifier.estDeNumeroPrecedent(pile.cartes.peek()))
				return true;
		if(carteAVerifier == null && pile.cartes.peek().numero() == Numero.AS)
			return true;
		return false;
	}

}
