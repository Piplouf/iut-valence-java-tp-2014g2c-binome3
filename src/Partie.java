/* TODO Javadoc ! */

public class Partie {
    /** Création de 4 piles qui seront les piles contenant les cartes définitives. */
    private Pile pileCouleur[] = new Pile[4];

    private Pile pilePaquet[] = new Pile[1];

    private Pile pileCourante[] = new Pile[7];

    /* TODO Pourquoi un attribut. */
    private JeuDeCarte jeuCourant = new JeuDeCarte();

    public Partie() {
        /* TODO Pourquoi ? */
        Carte[] carteVoulues;

        /* TODO Pourquoi des distributions de 0 cartes. */
        for (int i = 0; i < 4; i++) {
            this.pileCouleur[i] = new PileCouleur(this.jeuCourant.distribuerCartePile(0));
        }

        this.pilePaquet[0] = new PilePaquet(this.jeuCourant.distribuerCartePile(24));

        for (int i = 0; i < 7; i++) {
            this.pileCourante[i] = new PileCourante(this.jeuCourant.distribuerCartePile(i + 1));
        }
        /* TODO Normalement jeuCourant doit être vide. */
    }

    public void afficherEtatPartie() {
        /* TODO ??? */
        System.out.println(this.pileCourante[0]);
    }


}
