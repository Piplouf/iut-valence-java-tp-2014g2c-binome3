/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public enum Numero {
    AS(1), DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(9), DIX(10), VALET(11), DAME(12), ROI(13);
    
    private final int numeroDOrdre;
    
    private Numero(int numeroDOrdre)
    {this.numeroDOrdre = numeroDOrdre;}
    
    public Numero obtenirNumeroSuivant()
    {
    	return Numero.obtenirNumeroParNumeroDOrdre(this.numeroDOrdre+1);
    }
    
    public Numero obtenirNumeroPrecedent()
    {
    	return Numero.obtenirNumeroParNumeroDOrdre(this.numeroDOrdre-1);   	
    }
    
    private static Numero obtenirNumeroParNumeroDOrdre(int numeroDOrdre)
    {
    	for (Numero numero: Numero.values())
    		if (numero.numeroDOrdre == numeroDOrdre) return numero;
    	return null;
    }
   
}
