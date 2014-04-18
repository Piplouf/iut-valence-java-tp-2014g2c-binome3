package fr.iutvalence.java.tp.g2c.binome3;
import java.util.Stack;

/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class JeuDeCartes {

    /** Pile contenant toutes les cartes du jeu de carte */
    private final Stack<Carte> cartes = new Stack<Carte>();
    /** Le nombre de cartes restant � notre jeu de cartes */
    private int nombreCartesRestantes;

    /** Cr�er un jeu de carte contenant toutes les cartes possible
     * sans doublons
    */
    public JeuDeCartes() {
        nombreCartesRestantes = 0;
        for (Couleur coul : Couleur.values()) {
            for (Numero num : Numero.values()) {
                this.cartes.push(new Carte(coul,num,true));
                nombreCartesRestantes++;
            }
        }
    }

    /**
     * Méthode permettant de distribuer des cartes de leurs piles
     * @param nombre Nombre de carte voulu dans la pile (doit être supérieur à 0 et inférieur au nombre de cartes restantes)
     * @return Un paquet de carte aléatoire
     */
    public Carte[] distribuer(int nombre) {
        assert (nombre > 0) && (nombre < this.nombreCartesRestantes);

    	Carte[] carteARetourner = new Carte[nombre];
            for (int i = 0; i < nombre; i++) {
                /* TODO Préférer SecureRadom à Random. */
                int rand = (int) (Math.random() * nombreCartesRestantes);
                carteARetourner[i] = this.cartes.get(rand);
                this.cartes.remove(rand);
                this.nombreCartesRestantes--;
            }
        
        return carteARetourner;
    }
}
