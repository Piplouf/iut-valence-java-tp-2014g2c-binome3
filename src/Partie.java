import java.util.Scanner;

/* TODO Package. */

/**
 * TODO.
 * 
 * @author TODO
 * @version TODO
 */
public class Partie {
	
	/**
	 * Constante qui d�finit le nombre de cartes contenus dans la pioche au depart
	 */
	private static final int NOMBRE_DE_CARTES_DE_LA_PIOCHE = 24;
	/**
	 * Constante qui d�finit le nombre de piles courantes dans une partie
	 */
	private static final int NOMBRE_DE_PILES_TEMPORAIRES = 7;
	/**
	 * Constante qui d�finit le nombre de piles finales dans une partie
	 */
	private static final int NOMBRE_DE_COULEURS = 4;
	/** Piles contenant les cartes définitives. */
	private PileCouleur[] couleurs;
	/** Paquet. */
	private Pile pioche;
	/** TODO. */
	private Pile[] temporaires;

	/**
	 * Cr�er une partie avec 7 piles courantes, 4 piles finales et une pioche toute
	 * initialis� avec le nombre exact de cartes selon les r�gles du solitaire
	 */
	public Partie() {
		this.couleurs = new PileCouleur[NOMBRE_DE_COULEURS];
		this.temporaires = new Pile[NOMBRE_DE_PILES_TEMPORAIRES];

		JeuDeCartes jeu = new JeuDeCartes();

		// Créer 4 piles vides
		for (int numeroDeCouleur = 0; numeroDeCouleur < NOMBRE_DE_COULEURS; numeroDeCouleur++) {
			this.couleurs[numeroDeCouleur] = new PileCouleur();
		}

		// Boucle qui créer les piles courante contenant 1,2,3..7 cartes
		for (int numeroDePileTemporaire = 0; numeroDePileTemporaire < NOMBRE_DE_PILES_TEMPORAIRES; numeroDePileTemporaire++) {
			this.temporaires[numeroDePileTemporaire] = new Pile(
					jeu.distribuer(numeroDePileTemporaire + 1));
			this.temporaires[numeroDePileTemporaire].retournerDerniereCarte();
		}

		// Créer une pile paquet de 24 cartes face cachées
		this.pioche = new Pile(jeu.distribuer(NOMBRE_DE_CARTES_DE_LA_PIOCHE));
		this.pioche.retournerToutesLesCartes();
	}

	/**
	 * M�thode qui g�re la gestion d'une partie, en prenant en compte
	 * les entr�e claviers du joueurs
	 */
	public void jouer() {
		
		Scanner sc = new Scanner(System.in);
		
		int choixAction;
		while (true) {
			this.afficherEtatPartie();
			do {
				System.out.println("1. D�placer pile � pile\n2. Utiliser la pioche");
				choixAction = sc.nextInt();
			} while (choixAction != 1 && choixAction != 2);

		switch(choixAction){	
		case 1:{
			System.out.println("Entrer la pile � d�placer !");
			Pile pileDepart = this.choixPile();
			System.out.println("Entrer la pile d'arriv�e !");
			Pile pileArrivee = this.choixPile();
			pileDepart.deplacerCarte(pileArrivee);
			this.afficherEtatPartie();
			break;
			}
			
		case 2:{
			System.out.println("Entrer la pile de destination");
			Pile pileArrivee = this.choixPile();
			System.out.println("Entrer la carte � d�placer");
			this.pioche.deplacerCarte(choixCarte(),pileArrivee);
			break;
			}
		}
		}
	}

	/**
	 * Affiche l'etat de la partie, en affichant toutes les piles et leurs contenus
	 */
	public void afficherEtatPartie() {
		System.out.println(pioche.toString());
		for (int i = 0; i < NOMBRE_DE_PILES_TEMPORAIRES; i++) {
			System.out.println("Pile courante n�" + (i + 1));
			System.out.println(temporaires[i].toString());
		}
		for (int i = 0; i < NOMBRE_DE_COULEURS; i++) {
			System.out.println("Pile de couleur n�" + (i + 1));
			System.out.println(couleurs[i].toString());
		}
	}

	/**
	 * M�thode qui demande les entr�es claviers � l'utilisateur pour le deplacement des 
	 * piles
	 * @return la pile selectionner
	 */
	public Pile choixPile() {
		int choixPile;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Pile de couleur\n2. Pile courante");
			choixPile = sc.nextInt();
		} while (choixPile != 1 && choixPile != 2);

		switch (choixPile) {
		case 1: {
			System.out.println("Entrer le num�ro de la pile");
			int choixNumeroPile = sc.nextInt();
			return this.couleurs[choixNumeroPile - 1];
		}
		case 2: {
			System.out.println("Entrer le num�ro de la pile");
			int choixNumeroPile = sc.nextInt();
			return this.temporaires[choixNumeroPile - 1];
		}
		}
		return new Pile();
	}
	
	/**
	 * M�thode qui permet de choisir une carte parmi celle de la pioche pour 
	 * pouvoir la d�placer ensuite
	 * @return la carte choisie
	 */
	public Carte choixCarte(){
		Scanner sc = new Scanner(System.in);		
		int choixCarte = sc.nextInt();
		return this.pioche.cartes.get(choixCarte - 1);
	}
}
