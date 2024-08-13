package fr.diginamic.immobilier.entites;
/** Représente une maison avec toutes ses pièces
 * @author DIGINAMIC
 *
 */
public class Maison {
	
	/** pieces : tableau de pièces de la maison */
	private Piece[] pieces;
	
	/**
	 * Constructeur
	 */
	public Maison(){
		// Initialisation du tableau de pièces
		pieces = new Piece[0];
	}

	/** Ajoute une pièce à la maison
	 * @param nvPiece nouvelle pièce à ajouter
	 */
	public void ajouterPiece(Piece nvPiece) {

		if (nvPiece == null) {
			return;
		}

		// Check if the superficie is 0 or less, and skip adding if true
		if (nvPiece.getSuperficie() <= 0) {
			System.out.println("Il faut que la superficie soit supérieure à 0");
			return;  // Skip adding this piece
		}
		
		// On est obligé d'agrandir le tableau initial de 1 à chaque ajout
		// d'une nouvelle pièce
		
		// On commence donc par créer un tableau temporaire appelé newTab
		// qui a une taille égale au tableau du tableau pieces+1
		Piece[] newTab = new Piece[pieces.length+1];
		
		// On déverse toutes les pièces du tableau pieces dans newTab
		for (int i=0; i<pieces.length; i++) {
			newTab[i]=pieces[i];
		}
		
		// On place en dernière position dans le nouveau tableau la nouvelle
		// pièce
		newTab[newTab.length-1]=nvPiece;
		
		// Enfin on affecte newTab à pieces
		this.pieces=newTab;
	}
	
	public int nbPieces() {
		return pieces.length;
	}

	/** Retourne la superficie d'un étage
	 * @param choixEtage choix de l'étage
	 * @return double
	 */
	public double superficieEtage(int choixEtage) {
		double superficieEtage = 0;

		for (int i = 0; i < pieces.length; i++) {
			if (choixEtage == this.pieces[i].getNumEtage()) {
				superficieEtage = this.pieces[i].getSuperficie() + superficieEtage;
			}
		}

		return superficieEtage;
	}
	
	/** Retourne la superficie total pour un type de pièce donné
	 * @param typePiece type de pièce
	 * @return double
	 */
	public double superficieTypePiece(String typePiece) {
		double superficie = 0;

		String nomalizedTypePiece = typePiece.toUpperCase();

		for (int i = 0; i < pieces.length; i++) {
			if (nomalizedTypePiece!=null && nomalizedTypePiece.equals(this.pieces[i].getType().toUpperCase())) {
				superficie = superficie + this.pieces[i].getSuperficie();
			}
		}

		return superficie;
	}

	/** Retourne la surface totale
	 * @return double
	 */
	public double calculerSurface() {
		double superficieTot = 0;

		for (int i = 0; i < pieces.length; i++) {
			superficieTot = superficieTot + this.pieces[i].getSuperficie();
		}

		return superficieTot;
	}

	/** Getter pour l'attribut pieces
	 * @return the pieces
	 */
	public Piece[] getPieces() {
		return pieces;
	}

}