package fr.iutvalence.java.tp.g2c.binome3;
/* TODO Package. */

/**
 * Enumeration de couleur qui composeront les diff�rentes cartes
 *
 * @author TODO
 * @version TODO
 */
public enum Couleur {
    CARREAU(FamilleCouleur.ROUGE), PIQUE(FamilleCouleur.NOIR), TREFLE(FamilleCouleur.NOIR), COEUR(FamilleCouleur.ROUGE);
    
    /**
     * La famille de couleur de couleur, necessaire pour les comparaisons
     */
    private final FamilleCouleur familleDeCouleur;
    
    /**
     * Cr�er une couleur avec la famille de couleur du parametre
     * @param familleDeCouleur la famille de couleur voulu
     */
    private Couleur(FamilleCouleur familleDeCouleur)
    {
    	this.familleDeCouleur = familleDeCouleur;
    }
    
    /**
     * Permet d'obtenir la famille de couleur de la couleur
     * @return la famille de couleur de la couleur
     */
    public FamilleCouleur obtenirFamilleDeCouleur()
    {
    	return this.familleDeCouleur;
    }
}
