/* TODO Package. */

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class JeuDeCarte {

    /* TODO 52 : constante ? Calcul ? */
    /** TODO. */
    private final Carte[] cartes = new Carte[52];
    /** TODO. */
    private int nombreCartesRestantes;

    /** TODO. */
    public JeuDeCarte() {
        nombreCartesRestantes = 0;
        for (Couleur coul : Couleur.values()) {
            for (Numero num : Numero.values()) {
                cartes[nombreCartesRestantes++] = new Carte(coul, num, true);
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
                carteARetourner[i] = this.cartes[rand];
                for (int r = rand; r < (nombreCartesRestantes - 1); r++) {
                    this.cartes[r] = this.cartes[r + 1];
                }
                this.nombreCartesRestantes--;
            }
        
        return carteARetourner;
    }
}
