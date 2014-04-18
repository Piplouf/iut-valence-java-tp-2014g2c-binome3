package fr.iutvalence.java.tp.g2c.binome3;
import java.util.Scanner;

/**
 * La classe partie contient tous les éléments du solitaire.
 * 
 * @author TODO
 * @version TODO
 */
public class Partie {
	
	/**
	 * Constante qui définit le nombre de cartes contenus dans la pioche au depart
	 */
	private static final int NOMBRE_DE_CARTES_DE_LA_PIOCHE = 24;
	/**
	 * Constante qui définit le nombre de piles courantes dans une partie
	 */
	private static final int NOMBRE_DE_PILES_TEMPORAIRES = 7;
	/**
	 * Constante qui définit le nombre de piles finales dans une partie
	 */
	private static final int NOMBRE_DE_COULEURS = 4;
	/** Piles contenant les cartes dÃ©finitives. */
	private PileCouleur[] couleurs;
	/** Paquet. */
	private Pile pioche;
	/** TODO. */
	private Pile[] temporaires;

	/**
	 * Créer une partie avec 7 piles courantes, 4 piles finales et une pioche toute
	 * initialisé avec le nombre exact de cartes selon les régles du solitaire
	 */
	public Partie() {
		this.couleurs = new PileCouleur[NOMBRE_DE_COULEURS];
		this.temporaires = new Pile[NOMBRE_DE_PILES_TEMPORAIRES];

		JeuDeCartes jeu = new JeuDeCartes();

		// CrÃ©er 4 piles vides
		for (int numeroDeCouleur = 0; numeroDeCouleur < NOMBRE_DE_COULEURS; numeroDeCouleur++) {
			this.couleurs[numeroDeCouleur] = new PileCouleur();
		}

		// Boucle qui crÃ©er les piles courante contenant 1,2,3..7 cartes
		for (int numeroDePileTemporaire = 0; numeroDePileTemporaire < NOMBRE_DE_PILES_TEMPORAIRES; numeroDePileTemporaire++) {
			this.temporaires[numeroDePileTemporaire] = new Pile(
					jeu.distribuer(numeroDePileTemporaire + 1));
			this.temporaires[numeroDePileTemporaire].retournerDerniereCarte();
		}

		// CrÃ©er une pile paquet de 24 cartes face cachÃ©es
		this.pioche = new Pile(jeu.distribuer(NOMBRE_DE_CARTES_DE_LA_PIOCHE));
		this.pioche.retournerToutesLesCartes();
	}

	/**
	 * Méthode qui gére la gestion d'une partie, en prenant en compte
	 * les entrée claviers du joueurs
	 */
	public void jouer() {
		
		Scanner sc = new Scanner(System.in);
		
		int choixAction;
		while (this.partieEstEnCours()) {
			this.afficherEtatPartie();
			do {
				System.out.println("1. Déplacer pile à pile\n2. Utiliser la pioche");
				choixAction = sc.nextInt();
			} while (choixAction != 1 && choixAction != 2);

		switch(choixAction){	
		case 1:{
			System.out.println("Entrer la pile à déplacer !");
			Pile pileDepart = this.choixPile();
			System.out.println("Entrer la pile d'arrivée !");
			Pile pileArrivee = this.choixPile();
			pileDepart.deplacerCarte(pileArrivee);
			this.afficherEtatPartie();
			break;
			}
			
		case 2:{
			System.out.println("Entrer la pile de destination");
			Pile pileArrivee = this.choixPile();
			System.out.println("Entrer la carte à déplacer");
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
			System.out.println("Pile courante n°" + (i + 1));
			System.out.println(temporaires[i].toString());
		}
		for (int i = 0; i < NOMBRE_DE_COULEURS; i++) {
			System.out.println("Pile de couleur n°" + (i + 1));
			System.out.println(couleurs[i].toString());
		}
	}

	/**
	 * Méthode qui demande les entrées claviers à l'utilisateur pour le deplacement des 
	 * piles
	 * @return la pile selectionner
	 */
	public Pile choixPile() {
		int choixPile, choixNumeroPile;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Pile de couleur\n2. Pile courante");
			choixPile = sc.nextInt();
		} while (choixPile != 1 && choixPile != 2);

		switch (choixPile) {
		case 1: {
			System.out.println("Entrer le numéro de la pile");
		do{
			choixNumeroPile = sc.nextInt();
		}while(choixNumeroPile > 0 && choixNumeroPile < 5);
			return this.couleurs[choixNumeroPile - 1];
		}
		case 2: {
			System.out.println("Entrer le numéro de la pile");
		do{
			choixNumeroPile = sc.nextInt();
		}while(choixNumeroPile > 0 && choixNumeroPile < 8);
			return this.temporaires[choixNumeroPile - 1];
		}
		}
		return new Pile();
	}
	
	/**
	 * Méthode qui permet de choisir une carte parmi celle de la pioche pour 
	 * pouvoir la déplacer ensuite
	 * @return la carte choisie
	 */
	public Carte choixCarte(){
		Scanner sc = new Scanner(System.in);
		int choixCarte;
		do{
		choixCarte = sc.nextInt();
		}while(choixCarte > 0 && choixCarte < this.pioche.cartes.size());
		return this.pioche.cartes.get(choixCarte - 1);
	}
	
	/**
	 * Verifie si la partie est en cours et n'est donc pas terminée
	 * @return true si le partie est en cours
	 * 			false si le jouer a fini
	 */
	public boolean partieEstEnCours(){
		return (!(this.couleurs[0].cartes.size() == 13 && this.couleurs[1].cartes.size() == 13 && 
				this.couleurs[2].cartes.size() == 13 && this.couleurs[3].cartes.size() == 13));
	}
}
