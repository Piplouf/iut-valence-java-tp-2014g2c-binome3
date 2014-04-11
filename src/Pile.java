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
			etatPaquet += compteur+". ";
			etatPaquet += carte.toString();
			compteur++;
		}
		return etatPaquet;
	}

	/** MÃ©thode pour dÃ©placer les cartes d'une pile Ã  une autre. */
	public void deplacerCarte(Pile pile) {
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
			}
	}
	
	public void deplacerCarte(Carte carte, Pile pileArrivee) {
		
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
	}

	protected boolean deplacementEstPossible(Pile pile) {
		return (couleurEstDifferente(pile) && carteEstLaPrecedente(pile));
	}

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
