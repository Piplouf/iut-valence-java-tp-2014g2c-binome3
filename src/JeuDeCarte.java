/* TODO Javadoc ! */

public class JeuDeCarte {

    private Carte carte[] = new Carte[52];

    private int nombreCartesRestantes;

    public JeuDeCarte() {
        nombreCartesRestantes = 0;
        for (Couleur coul : Couleur.values()) {
            for (Numero num : Numero.values()) {
                carte[nombreCartesRestantes++] = new Carte(coul, num, false);
            }
        }
    }

    public Carte[] distribuerCartePile(int nombreCartesPile) {
        /* Pr�-condition sur la taille de la demande */

        Carte[] carteARetourner = new Carte[nombreCartesPile];
        /* TODO Votre choix d'implémentation est (très) discutable. */
        if (nombreCartesPile < 0 || nombreCartesPile <= this.nombreCartesRestantes) {

        }
        else {
            for (int i = 0; i < nombreCartesPile; i++) {
                /* XXX Pourquoi 51 ? */
                /* XXX Pourquoi 0+ ? */
                int rand = 0 + (int) (Math.random() * ((51) + 1));
                carteARetourner[i] = this.carte[rand];
                /* XXX Pourquoi i ? */
                for (i = rand; i < nombreCartesRestantes; i++) {
                    this.carte[rand] = this.carte[rand + 1];
                }
                this.nombreCartesRestantes--;
            }
        }
        return carteARetourner;
    }
}
