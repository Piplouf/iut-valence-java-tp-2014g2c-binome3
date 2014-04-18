package fr.iutvalence.java.tp.g2c.binome3;
/* TODO Package. */

/**
 * Enumeration contenant tout les numeros possible pour les cartes
 *
 * @author Maruejol Florian
 * @version 1.0
 */
public enum Numero {
    AS(1), DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(9), DIX(10), VALET(11), DAME(12), ROI(13);
    
    /**
     * Numero correspondant au numero de la carte, necessaire pour obtenir les numeros
     * suivants et precedents de cartes
     */
    private final int numeroDOrdre;
    
    /**
     * Constructeur priv�e permettant de cr�er le numero souhait�
     * @param numeroDOrdre
     */
    private Numero(int numeroDOrdre)
    {this.numeroDOrdre = numeroDOrdre;}
    
    /**
     * Permet d'obtenir le num�ro suivant le numero actuel
     * @return le numero suivant
     */
    public Numero obtenirNumeroSuivant()
    {
    	return Numero.obtenirNumeroParNumeroDOrdre(this.numeroDOrdre+1);
    }
    
    /**
     * Permet d'obtenir le num�ro pr�c�dent le numero actuel
     * @return le num�ro pr�c�dent
     */
    public Numero obtenirNumeroPrecedent()
    {
    	return Numero.obtenirNumeroParNumeroDOrdre(this.numeroDOrdre-1);   	
    }
    
    /**
     * Permet d'obtenir le numero de la carte
     * @param numeroDOrdre
     * @return le numero de la carte
     */
    private static Numero obtenirNumeroParNumeroDOrdre(int numeroDOrdre)
    {
    	for (Numero numero: Numero.values())
    		if (numero.numeroDOrdre == numeroDOrdre) return numero;
    	return null;
    }
   
}
