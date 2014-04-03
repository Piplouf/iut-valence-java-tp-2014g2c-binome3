import java.util.Stack;

/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class JeuDeCartes {

    /* TODO 52 : constante ? Calcul ? */
    /** TODO. */
    private final Stack<Carte> cartes = new Stack<Carte>();
    /** TODO. */
    private int nombreCartesRestantes;

    /** TODO. */
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
     * Méthode renvoyant une pile de carte.
     *
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
