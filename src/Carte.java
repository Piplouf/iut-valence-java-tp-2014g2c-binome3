/* TODO Javadoc ! */

public class Carte {
    /* TODO Peut changer en cours de partie ? */
    private Couleur couleur;
    /* TODO Peut changer en cours de partie ? */
    private Numero  numero;
    private boolean etat;

    public Carte(Couleur coul, Numero num, boolean etat) {
        this.couleur = coul;
        this.numero = num;
        this.etat = etat;
    }
}
