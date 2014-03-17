/* TODO Javadoc ! */
/* TODO Package. */

public class Pile {
    /* TODO Change en cours de partie ? */
    private final Carte[] carte;
    
    private int taille;

    private final int capacite;

    public Pile(int taille, int capacite){
    	this.carte = new Carte[capacite];
    	this.taille = taille;
    	this.capacite = capacite;
    }

    /* TODO Pourquoi le second param√®tre ? */
    public Pile(Carte[] cartesVoulu, int taille, int capacite) {
        /* TODO Pourquoi cette premi√®re affectation ? */
    	this.carte =cartesVoulu;
        this.taille = taille;
        this.capacite = capacite;
    }
    
    
    public void retournerDerniereCarte(){
    	this.carte[this.taille - 1].retournerCarte();
    }
    
    public void retournerCarteVoulu(int nombreCarteVoulu){
    	this.carte[nombreCarteVoulu].retournerCarte();
    }

    /* TODO Est-ce que le nom est bien choisi ? */
    public String afficherPaquet(){
    	String etatPaquet = "";
    	for(int i = 0; i < this.taille; i++)
            etatPaquet += this.carte[i].isEtat() ? "Carte cachÈe \n" : String.format("NumÈro : %s Couleur : %s\n", this.carte[i].getNumero(), this.carte[i].getCouleur());
    	
    	return etatPaquet;
    }
    
    /**
     * MÈthode pour dÈplacer les cartes d'une pile ‡ une autre
     * @param pile
     */
    
    public void deplacerCarte(Pile pile){
    	Carte[] carteADeplacer = new Carte[30];
    	int i = 0, indice = 0;
    	
    	while(!(this.carte[i].isEtat())){
    		i++;
    	}
    	
    	for(int j = i; j < this.taille;j++){
    		carteADeplacer[indice++] = this.carte[j];
    	}
    	
    	for(int j = 0; j < indice - 1; j++)
    	{
    		pile.carte[pile.taille++] = carteADeplacer[j];
    		this.taille--;
    	}
    	
    	
    }
}
