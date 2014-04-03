import java.util.Scanner;

/* TODO Package. */

/**
 * TODO.
 * 
 * @author TODO
 * @version TODO
 */
public class Partie {
	private static final int NOMBRE_DE_CARTES_DE_LA_PIOCHE = 24;
	private static final int NOMBRE_DE_PILES_TEMPORAIRES = 7;
	private static final int NOMBRE_DE_COULEURS = 4;
	/** Piles contenant les cartes d√©finitives. */
	private PileCouleur[] couleurs;
	/** Paquet. */
	private Pile pioche;
	/** TODO. */
	private Pile[] temporaires;

	public Partie() {
		this.couleurs = new PileCouleur[NOMBRE_DE_COULEURS];
		this.temporaires = new Pile[NOMBRE_DE_PILES_TEMPORAIRES];

		JeuDeCartes jeu = new JeuDeCartes();

		// Cr√©er 4 piles vides
		for (int numeroDeCouleur = 0; numeroDeCouleur < NOMBRE_DE_COULEURS; numeroDeCouleur++) {
			this.couleurs[numeroDeCouleur] = new PileCouleur();
		}

		// Boucle qui cr√©er les piles courante contenant 1,2,3..7 cartes
		for (int numeroDePileTemporaire = 0; numeroDePileTemporaire < NOMBRE_DE_PILES_TEMPORAIRES; numeroDePileTemporaire++) {
			this.temporaires[numeroDePileTemporaire] = new Pile(
					jeu.distribuer(numeroDePileTemporaire + 1));
			this.temporaires[numeroDePileTemporaire].retournerDerniereCarte();
		}

		// Cr√©er une pile paquet de 24 cartes face cach√©es
		this.pioche = new Pile(jeu.distribuer(NOMBRE_DE_CARTES_DE_LA_PIOCHE));
		this.pioche.retournerToutesLesCartes();
	}

	public void jouer() {
		this.afficherEtatPartie();
		while (true) {
			System.out.println("Entrer la pile ‡ dÈplacer !");
			Pile pileDepart = this.choixPile();
			System.out.println("Entrer la pile d'arrivÈe !");
			Pile pileArrivee = this.choixPile();
			/* Verifier la semantique du choix. */
			pileDepart.deplacerCarte(pileArrivee);
			this.afficherEtatPartie();
		}
	}

	public void afficherEtatPartie() {
		System.out.println(pioche.afficherEtatPartie());
		for (int i = 0; i < NOMBRE_DE_PILES_TEMPORAIRES; i++) {
			System.out.println("Pile courante n∞" + (i + 1));
			System.out.println(temporaires[i].afficherEtatPartie());
		}
		for (int i = 0; i < NOMBRE_DE_COULEURS; i++) {
			System.out.println("Pile de couleur n∞" + (i + 1));
			System.out.println(couleurs[i].afficherEtatPartie());
		}
	}

	public Pile choixPile() {
		int choixPile;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Pile de couleur\n2. Pile courante");
			choixPile = sc.nextInt();
		} while (choixPile != 1 && choixPile != 2);

		switch (choixPile) {
		case 1: {
			System.out.println("Entrer le numÈro de la pile");
			int choixNumeroPile = sc.nextInt();
			return this.couleurs[choixNumeroPile - 1];
		}
		case 2: {
			System.out.println("Entrer le numÈro de la pile");
			int choixNumeroPile = sc.nextInt();
			return this.temporaires[choixNumeroPile - 1];
		}
		}
		return new Pile();
	}
}
