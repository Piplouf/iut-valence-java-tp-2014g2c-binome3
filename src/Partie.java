/* TODO Javadoc ! */
/* TODO Package. */

public class Partie {
    /** Création de 4 piles qui seront les piles contenant les cartes définitives. */
    private Pile pileCouleur[] = new Pile[4];
    /* TODO Pourquoi faire un tableau de 1 pile ? */
    private Pile pilePaquet[] = new Pile[1];

    private Pile pileCourante[] = new Pile[7];

    public Partie() {
    	
    	JeuDeCarte jeuADistribuer = new JeuDeCarte();

        //Créer 4 piles vides
    	for (int i = 0; i < 4; i++) {
            this.pileCouleur[i] = new Pile(0,13);
        }

        //Boucle qui créer les piles courante contenant 1,2,3..7 cartes
        for (int i = 0; i < 7; i++) {
            /* TODO Je ne suis pas d'accord sur la valeur du troisième paramètre. */
            this.pileCourante[i] = new Pile(jeuADistribuer.distribuerCartePile(i + 1), i + 1 , 13 + (i + 1));
            this.pileCourante[i].retournerDerniereCarte();
        }
        
        // Créer une pile paquet de 24 cartes face cach�es
        this.pilePaquet[0] = new Pile(jeuADistribuer.distribuerCartePile(24),24,24);
        
        // Boucle qui retourne toutes les cartes du paquet
        for(int i = 0; i < 24; i++){
        	this.pilePaquet[0].retournerCarteVoulu(i);
        }
    }

    
    public void jouer(){
    	System.out.println(pilePaquet[0].afficherPile());
    	for(int i = 0; i < 7; i++){
    		System.out.println(pileCourante[i].afficherPile());
    	}
    	for(int i = 0; i < 4; i++){
    		System.out.println(pileCouleur[i].afficherPile());
    	}
    	
    }
    
    
    public void afficherEtatPartie() {
        /* TODO ??? */
    }


}
