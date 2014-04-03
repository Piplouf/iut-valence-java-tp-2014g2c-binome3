import java.util.Arrays;
import java.util.Stack;
import java.util.Iterator;

/* TODO Package. */

/**
 * Pile contentant les cartes consitués d'une pile
 * 
 * @author Florian Maruejol
 * @version 1.1
 */
public class Pile {
	protected final Stack<Carte> cartes;

	public Pile() {
		cartes = new Stack<Carte>();
	}

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

	public void retournerToutesLesCartes() {
		for (Carte carte : cartes) {
			carte.retourner();
		}
	}

	/**
	 * Change l'état de la carte voulue
	 * 
	 * @param nombreCarteVoulu
	 *            carte voulue
	 */

	/* TODO Utilisez un StringBuilder. */
	/* TODO Est-ce que le nom est bien choisi ? */
	public String afficherEtatPartie() {
		String etatPaquet = "";
		for (Carte carte : cartes) {
			etatPaquet += carte.toString();
		}
		return etatPaquet;
	}

	/* TODO Ã€ discuter en TP. */
	/** MÃ©thode pour dÃ©placer les cartes d'une pile Ã  une autre. */
	public void deplacerCarte(Pile pile) {
		if (!(this.cartes.isEmpty()))
			if (pile.deplacementEstPossible(this)) {
				Stack<Carte> cartesAStockes = new Stack<Carte>();
				for (Carte carte : pile.cartes) {
					if (carte.estFaceCachee()) {
						return;
					}
					cartesAStockes.push(this.cartes.pop());
				}
				if (!(this.cartes.isEmpty()))
					this.cartes.peek().retourner();
				
				for (Carte carte : cartesAStockes) {
					pile.cartes.push(carte);
				}
			}
	}

	private boolean deplacementEstPossible(Pile pile) {
		if (couleurEstDifferente(pile) && carteEstLaPrecedente(pile))
				return true;
		return false;
	}

	private boolean couleurEstDifferente(Pile pile) {
		Carte carteAVerifier = null;
		for (int i = 0; i < this.cartes.size(); i++)
			if (!(this.cartes.get(i).estFaceCachee()))
				carteAVerifier = this.cartes.get(i);
		if (!pile.cartes.isEmpty())
			if (carteAVerifier.estDeFamilleDeCouleurDifferente(pile.cartes.peek()))
				return true;
			else
				return false;
		return false;
	}

	private boolean carteEstLaPrecedente(Pile pile) {
		Carte carteAVerifier = null;
		for (int i = 0; i < this.cartes.size(); i++)
			if (!(this.cartes.get(i).estFaceCachee()))
				carteAVerifier = this.cartes.get(i);
		if (!pile.cartes.isEmpty())
			if (carteAVerifier.estDeNumeroSuivant(pile.cartes.peek()))
				return true;
			else
				return true;
		return false;
	}

}
