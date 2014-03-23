/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Partie {
    /** Piles contenant les cartes définitives. */
    private Pile pileCouleur[] = new Pile[4];
    /** Paquet. */
    private Pile pilePaquet;
    /** TODO. */
    private Pile pileCourante[] = new Pile[7];

    public Partie() {
    	JeuDeCarte jeu = new JeuDeCarte();

        // Créer 4 piles vides
    	for (int i = 0; i < 4; i++) {
            this.pileCouleur[i] = new Pile(0,13);
        }

        // Boucle qui créer les piles courante contenant 1,2,3..7 cartes
        for (int i = 0; i < 7; i++) {
            this.pileCourante[i] = new Pile(jeu.distribuer(i + 1), i + 1 , 13 + i);
            this.pileCourante[i].retournerDerniereCarte();
        }
        
        // Créer une pile paquet de 24 cartes face cachées
        this.pilePaquet = new Pile(jeu.distribuer(24),24,24);
        
        // Boucle qui retourne toutes les cartes du paquet
        /* TODO Fonctionnement discutable. */
        for(int i = 0; i < 24; i++){
        	this.pilePaquet.retournerCarteVoulu(i);
        }
    }
    
    public void jouer() {
    	this.afficherEtatPartie();
    	pileCourante[3].deplacerCarte(pileCourante[4]);
    	this.afficherEtatPartie();
    }

    public void afficherEtatPartie() {
    	System.out.println(pilePaquet.afficherPaquet());
    	for(int i = 0; i < 7; i++){
    		System.out.println(pileCourante[i].afficherPaquet());
    	}
    	for(int i = 0; i < 4; i++){
    		System.out.println(pileCouleur[i].afficherPaquet());
    	}
    }
}
