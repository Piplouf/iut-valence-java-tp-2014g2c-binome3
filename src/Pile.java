import java.util.Arrays;
import java.util.Stack;

/* TODO Package. */

/**
 * Pile contentant les cartes consitués d'une pile
 * 
 * @author Florian Maruejol
 * @version 1.1
 */
public class Pile {
	
	/**
	 * Les cartes composants une pile
	 */
	protected final Stack<Carte> cartes;

	/**
	 * Crée une pile vide ne contenant aucune carte
	 */
	public Pile() {
		cartes = new Stack<Carte>();
	}

	/**
	 * Constructeur créant une pile avec les cartes désirés
	 * @param cartesVoulu cartes qui composeront la pile
	 */
	public Pile(Carte[] cartesVoulu) {
		cartes = new Stack<Carte>();
		cartes.addAll(Arrays.asList(cartesVoulu));
	}

	/**
	 * Change l'état de la carte au sommet de la pile
	 */
	public void retournerDerniereCarte() {
		this.cartes.peek().retourner();
	}

	/**
	 * Retourne toutes les cartes d'une pile de carte
	 */
	public void retournerToutesLesCartes() {
		for (Carte carte : cartes) {
			carte.retourner();
		}
	}

	@Override
	public String toString() {
		String etatPaquet = "";
		int compteur = 1;
		for (Carte carte : cartes) {
			etatPaquet += compteur + ". ";
			etatPaquet += carte.toString();
			compteur++;
		}
		return etatPaquet;
	}

	/**
	 * Methode qui deplacer une carte d'une pile à une autre
	 * @param pile sur laquelle on veut deplacer notre carte
	 * @return true si le deplacement est reussi
	 *
	 */
	public boolean deplacerCarte(Pile pile) {
		boolean AMarche = false;
		if (!(this.cartes.isEmpty()))
			if (pile.deplacementEstPossible(this)) {
				Stack<Carte> cartesAStockes = new Stack<Carte>();
				for (int i =0; i < this.cartes.size();i++) {
					if (this.cartes.get(i).estFaceCachee()) { 
						
					}
					else
						cartesAStockes.push(this.cartes.pop());
				}
				if (!(this.cartes.isEmpty()))
					this.cartes.peek().retourner();
				
				for (Carte carte : cartesAStockes) {
					pile.cartes.push(carte);
				}
			AMarche = true;
			}
		return AMarche;
	}
	
	/**
	 * Méthode qui deplace une carte de la pioche sur une autre pile du jeu
	 * @param carte carte que l'on veut déplacer
	 * @param pileArrivee pile sur laquelle on veut deplacer la carte
	 */
	public void deplacerCarte(Carte carte, Pile pileArrivee) {
		
		/*
		if(!pileArrivee.cartes.isEmpty()){
			if(carte.estDeNumeroSuivant(pileArrivee.cartes.peek()) &&
				carte.estDeFamilleDeCouleurDifferente(pileArrivee.cartes.peek())){
				pileArrivee.cartes.push(carte);
				this.cartes.removeElement(carte);
			}
		}
		if(pileArrivee.cartes.isEmpty() && carte.numero() == Numero.ROI){
				pileArrivee.cartes.push(carte);
				this.cartes.removeElement(carte);
		}
		*/
		
		Pile transition = new Pile();
		transition.cartes.add(carte);
		if(transition.deplacerCarte(pileArrivee))
			this.cartes.remove(carte);
	}

	/**
	 * Renvoi un booléen pour savoir si le deplacement est possible
	 * @param pile pile d'arrivée du deplacement
	 * @return true si le deplacement est possible
	 */
	protected boolean deplacementEstPossible(Pile pile) {
		return (couleurEstDifferente(pile) && carteEstLaPrecedente(pile));
	}

	/**
	 * Verifie si les cartes sont de types de couleurs differentes
	 * @param pile pile sur laquelle on veut déplacer la carte
	 * @return true si les cartes sont de couleurs differentes
	 */
	protected boolean couleurEstDifferente(Pile pile) {
		Carte carteAVerifier = null;
		for (int i = 0; i < this.cartes.size(); i++)
			if (!(this.cartes.get(i).estFaceCachee()))
				carteAVerifier = this.cartes.get(i);
		if (!pile.cartes.isEmpty() && carteAVerifier != null)
			if (carteAVerifier.estDeFamilleDeCouleurDifferente(pile.cartes.peek()))
				return true;
		if(carteAVerifier == null && pile.cartes.peek().numero() == Numero.ROI)
			return true;
		return false;
	}

	/**
	 * Verifie si la carte au sommet de la pile est la precedente de la pile d'arrivee
	 * @param pile pile sur laquelle on veut deplacer notre carte
	 * @return true si c'est la carte précédente
	 */
	private boolean carteEstLaPrecedente(Pile pile) {
		Carte carteAVerifier = null;
		for (int i = 0; i < this.cartes.size(); i++)
			if (!(this.cartes.get(i).estFaceCachee()))
				carteAVerifier = this.cartes.get(i);
		if (!pile.cartes.isEmpty() && carteAVerifier != null)
			if (carteAVerifier.estDeNumeroSuivant(pile.cartes.peek()))
				return true;
		if(carteAVerifier == null && pile.cartes.peek().numero() == Numero.ROI)
			return true;
		return false;
	}

}
