package fr.diginamic.enumerations;
/**
 * Représente une saison et fournit les 4 instances de saisons.
 * 
 * @author DIGINAMIC
 *
 */
public enum Saison {

	/** Les 4 instances de Saison */
	PRINTEMPS("printemps", 1), ETE("été", 2), AUTOMNE("automne", 3), HIVER("hiver", 4);

	/** libelle */
	private String libelle;
	/** ordre */
	private int ordre;

	/**
	 * Constructeur
	 * 
	 * @param libelle libellé
	 * @param ordre   ordre
	 */
	private Saison(String libelle, int ordre) {
		this.libelle = libelle;
		this.ordre = ordre;
	}

	/**
	 * Permet de rechercher une Saison à partir de son libellé\
	 * Commentaire par Filip: il faut supprimer le premier "return null", sinon le test échoue
	 * Le deuxième "retour null" doit être en dehors de la boucle for
	 * J'ai également ajouté un test pour normaliser les cas, il renverra désormais le cas quel que soit le cas.
	 * Je voulais faire la même chose avec les accents mais c'est trop difficile pour le moment et sort du cadre de cet exercice.
	 * 
	 * @param libelle libellé
	 * @return {@link Saison}
	 */
	public static Saison valueOfLibelle(String libelle) {

		String normalizedLibelle = libelle.toLowerCase();

		Saison[] saisons = Saison.values();
		for (Saison saison : saisons) {
			if (normalizedLibelle.equals(saison.getLibelle())) {
				return saison;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return ordre + ". " + libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the ordre
	 */
	public int getOrdre() {
		return ordre;
	}
}