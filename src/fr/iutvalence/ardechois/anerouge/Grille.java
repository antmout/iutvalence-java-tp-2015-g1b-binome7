package fr.iutvalence.ardechois.anerouge;

/**
 * Représentation de la grille du jeu.
 *
 * @author chayc et moutona
 * @version 0.1
 */
public class Grille
{
	/**
	 * Nombre de colonnes de la grille <b>par défaut</b>.
	 */
	public static final int NOMBRE_COLONNES_DEFAUT = 10;
	/**
	 * Nombre de lignes de la grille <b>par défaut</b>.
	 */
	public static final int NOMBRE_LIGNES_DEFAUT = 10;

	/**
	 * Ensemble de cases, correspondant à la grille du jeu.
	 */
	private final Case[][] grille;

	/** Initialise une grille <b>vide</b>. */
	public Grille()
	{
		this(Grille.NOMBRE_COLONNES_DEFAUT, Grille.NOMBRE_LIGNES_DEFAUT);
	}

	/** Initialise une grille avec un nombre de colonnes et de lignes. */
	public Grille(int nombreColonnes, int nombreLignes)
	{
		grille = new Case[nombreColonnes][nombreLignes];
		for(int numeroLigne=0; numeroLigne<nombreLignes; numeroLigne++)
		{
			for(int numeroColonne=0; numeroColonne<nombreColonnes; numeroColonne++)
			{
				grille[numeroColonne][numeroLigne] = new Case();
			}
		}
	}
}
