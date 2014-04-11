import java.util.Stack;


public class PileCouleur extends Pile{
	
	PileCouleur(){
		super();
	}
	
	@Override
	protected boolean deplacementEstPossible(Pile pile){
    	if(couleurEstIdentique(pile) && carteEstLaSuivante(pile))
    		return true;
    	return false;
    }
 
    
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
