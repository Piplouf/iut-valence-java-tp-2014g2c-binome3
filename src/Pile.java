/* TODO Javadoc ! */

public class Pile {

	private Carte[] carte;
	
	
	/**
	 * Cr�er une pile avec les cartes voulues
	 * en prenant les cartes voulues en param�tres
	 * @param carteVoulu
	 */
	public Pile(Carte[] cartesVoulu){
		this.carte = cartesVoulu;
	}
	
	public Carte afficherCarteTableau(){
		return this.carte[1];
	}
}
