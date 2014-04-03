/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public enum Couleur {
    CARREAU(FamilleCouleur.ROUGE), PIQUE(FamilleCouleur.NOIR), TREFLE(FamilleCouleur.NOIR), COEUR(FamilleCouleur.ROUGE);
    
    private final FamilleCouleur familleDeCouleur;
    
    private Couleur(FamilleCouleur familleDeCouleur)
    {
    	this.familleDeCouleur = familleDeCouleur;
    }
    
    public FamilleCouleur obtenirFamilleDeCouleur()
    {
    	return this.familleDeCouleur;
    }
}
