/* TODO Javadoc ! */

public class Pile {

    private Carte[] carte;
    
    private int taille;
    
    private int capacite;

    /**
     * Cr�er une pile avec les cartes voulues 
     * @param carte[]  carte voulues
     */
    
    public Pile(int taille, int capacite){
    	this.carte = new Carte[capacite];
    	this.taille = taille;
    }
    
    public Pile(Carte[] cartesVoulu, int taille, int capacite) {
    	this.carte = new Carte[capacite];
        this.carte = cartesVoulu;
        this.taille = taille;
    }
    
    
    public void retournerDerniereCarte(){
    	this.carte[this.taille - 1].retournerCarte();
    }
    
    public void retournerCarteVoulu(int nombreCarteVoulu){
    	this.carte[nombreCarteVoulu].retournerCarte();
    }
    
    public String afficherPile(){
    	String etatPaquet = "";
    	for(int i = 0; i < this.taille; i++)
            etatPaquet += this.carte[i].isEtat() ? "Carte cachée \n" : String.format("Numéro : %s Couleur : %s\n", this.carte[i].getNumero(), this.carte[i].getCouleur());
    	
    	return etatPaquet;
    }
}
