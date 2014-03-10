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

    /**
     * M�thode renvoyant une pile de carte 
     * @param nombreCartesPile est le nombre de carte voulu dans la pile (doit �tre sup�rieur � 0 et inf�rieur au nombre de cartes restantes)
     * @return un paquet de carte al�atoire
     */
    public Carte[] distribuerCartePile(int nombreCartesPile) {
        assert (nombreCartesPile > 0 && nombreCartesPile < this.nombreCartesRestantes);

    	Carte[] carteARetourner = new Carte[nombreCartesPile];
            for (int i = 0; i < nombreCartesPile; i++) {
                int rand = (int) (Math.random() * ((nombreCartesRestantes)));
                carteARetourner[i] = this.carte[rand];
                for (int l = rand; l < nombreCartesRestantes-1; l++) {
                    this.carte[l] = this.carte[l + 1];
                }
                this.nombreCartesRestantes--;
            }
        
        return carteARetourner;
    }
}
