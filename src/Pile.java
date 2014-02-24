/* TODO Javadoc ! */

public class Pile {

	private Carte[] carte;
	
	
	/**
	 * Créer une pile avec les cartes voulues
	 * en prenant les cartes voulues en paramétres
	 * @param carteVoulu
	 */
	public Pile(Carte[] cartesVoulu){
		this.carte = cartesVoulu;
	}
	
	public Carte afficherCarteTableau(){
		return this.carte[1];
	}
}
