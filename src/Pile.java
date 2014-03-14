/* TODO Javadoc ! */
/* TODO Package. */

public class Pile {
    /* TODO Change en cours de partie ? */
    private Carte[] carte;
    private int taille;
    /* TODO Est-ce que cela change en cours de partie ? */
    private int capacite;

    public Pile(int taille, int capacite){
    	this.carte = new Carte[capacite];
    	this.taille = taille;
    }

    /* TODO Pourquoi le second paramètre ? */
    public Pile(Carte[] cartesVoulu, int taille, int capacite) {
        /* TODO Pourquoi cette première affectation ? */
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

    /* TODO Est-ce que le nom est bien choisi ? */
    public String afficherPile(){
    	String etatPaquet = "";
    	for(int i = 0; i < this.taille; i++)
            etatPaquet += this.carte[i].isEtat() ? "Carte cachée \n" : String.format("Numéro : %s Couleur : %s\n", this.carte[i].getNumero(), this.carte[i].getCouleur());
    	
    	return etatPaquet;
    }
}
