/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Pile {
    /** TODO. */
    private final Carte[] cartes;
    /** TODO. */
    private int taille;
    /* TODO Redondant avec cartes.length, non ? */
    /** TODO. */
    private final int capacite;

    public Pile(int taille, int capacite) {
        this.cartes = new Carte[capacite];
        this.taille = taille;
        this.capacite = capacite;
    }

    /* TODO Pourquoi le second paramètre ? */
    public Pile(Carte[] cartesVoulu, int taille, int capacite) {
    	this.cartes =cartesVoulu;
        this.taille = taille;
        this.capacite = capacite;
    }
    
    public void retournerDerniereCarte() {
    	this.cartes[this.taille - 1].retournerCarte();
    }
    
    public void retournerCarteVoulu(int nombreCarteVoulu) {
    	this.cartes[nombreCarteVoulu].retournerCarte();
    }

    /* TODO Utilisez un StringBuilder. */
    /* TODO Est-ce que le nom est bien choisi ? */
    public String afficherPaquet(){
    	String etatPaquet = "";
    	for(int i = 0; i < this.taille; i++)
            etatPaquet += this.cartes[i].isEtat() ? "Carte cachée.%n" : String.format("Numéro : %s Couleur : %s.%n", this.cartes[i].getNumero(), this.cartes[i].getCouleur());
    	
    	return etatPaquet;
    }

    /* TODO À discuter en TP. */
    /** Méthode pour déplacer les cartes d'une pile à une autre. */
    public void deplacerCarte(Pile pile){
        int i = 0;

        while(!this.cartes[i].isEtat()){
    		i++;
    	}

        Carte[] carteADeplacer = new Carte[30];
        int indice = 0;
        for(int j = i; j < this.taille;j++){
    		carteADeplacer[indice++] = this.cartes[j];
    	}
    	
    	for(int j = 0; j < (indice - 1); j++)
    	{
    		pile.cartes[pile.taille++] = carteADeplacer[j];
    		this.taille--;
    	}
    	
    	
    }
}
