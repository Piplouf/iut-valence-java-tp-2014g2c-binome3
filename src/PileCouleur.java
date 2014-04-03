import java.util.Stack;


public class PileCouleur extends Pile{
	
	PileCouleur(){
		super();
	}
	
    
	public void deplacerCarte(Pile pile){
		  
        Stack<Carte> cartesAStockes = new Stack<Carte>();
    	
        if(!(this.cartes.isEmpty()))
        	if(deplacementEstPossible(pile)){
    	//Stock les cartes à déplacer dans une pile intermediaire
        for(int i = 0; i < this.cartes.size(); i++){
    		if(!(this.cartes.get(i).estFaceCachee()))
    			cartesAStockes.push(this.cartes.pop());
    	}
        if(!(this.cartes.isEmpty()))
        	this.cartes.peek().retourner();
        
        for(int i = 0; i<cartesAStockes.size();i++)
        	pile.cartes.push(cartesAStockes.pop());
        }
	}
	
	private boolean deplacementEstPossible(Pile pile){
    	if(!couleurEstDifferente(pile) && carteEstLaSuivante(pile))
    		return true;
    	return false;
    }
    
    private boolean couleurEstDifferente(Pile pile){
    	Carte carteAVerifier = null;
    	for(int i = 0; i < this.cartes.size();i++)
    		if(!(this.cartes.get(i).estFaceCachee()))
    			carteAVerifier = this.cartes.get(i);
    	if(!this.cartes.isEmpty())
    		if(!carteAVerifier.estDeFamilleDeCouleurDifferente(pile.cartes.peek()))
    			return true;
    	else
    		return false;
    	return false;
    }
    
    private boolean carteEstLaSuivante(Pile pile) {
		Carte carteAVerifier = null;
		for (int i = 0; i < this.cartes.size(); i++)
			if (!(this.cartes.get(i).estFaceCachee()))
				carteAVerifier = this.cartes.get(i);
		if (!pile.cartes.isEmpty())
			if (carteAVerifier.estDeNumeroPrecedent(pile.cartes.peek()))
				return true;
			else if (carteAVerifier.numero() == Numero.AS)
				return true;
		return false;
	}

}
