package fr.iutvalence.ardechois.anerouge;

/**
 * Représentation de la grille du jeu.
 * 
 * @author chayc
 */

public class Grille
{
	public static final int NOMBRE_COLONNES_DEFAUT = 10;
	public static final int NOMBRE_LIGNES_DEFAUT = 10;
	
	private Case[][] grille;
	private int nombreColonnes;
	private int nombreLignes;
	
	/**
	 * Initialise une grille <b>vide</b>.
	 */
	public Grille()
	{
		this(Grille.NOMBRE_COLONNES_DEFAUT, Grille.NOMBRE_LIGNES_DEFAUT);
	}

	/**
	 * Initialise une grille avec un nombre de colonnes et de lignes.
	 * 
	 * @param nombreColonnes
	 * @param nombreLignes
	 */
	public Grille(int nombreColonnes, int nombreLignes)
	{
		super();
		this.nombreColonnes = nombreColonnes;
		this.nombreLignes = nombreLignes;
		grille = new Case[this.nombreColonnes][this.nombreLignes];
	}
}
