package fr.iutvalence.ardechois.anerouge;

/**
 * Représentation de la grille du jeu.
 *
 * @author chayc & moutona
 * @version 1.0
 */
public class Grille {
    /**
     * Nombre de colonnes de la grille <b>par défaut</b>.
     */
    public static final int NOMBRE_COLONNES_DEFAUT = 10;
    /**
     * Nombre de lignes de la grille <b>par défaut</b>.
     */
    public static final int NOMBRE_LIGNES_DEFAUT   = 10;
    
    /* TODO JAVADOC. */
    /* TODO final ? */
    private Case[][] grille;
    /* TODO JAVADOC. */
    /* TODO Utilité ? */
    private int      nombreColonnes;
    /* TODO Utilité ? */
    /* TODO JAVADOC. */
    private int      nombreLignes;

    /** Initialise une grille <b>vide</b>. */
    public Grille() {
        this(Grille.NOMBRE_COLONNES_DEFAUT, Grille.NOMBRE_LIGNES_DEFAUT);
    }

    /** Initialise une grille avec un nombre de colonnes et de lignes. */
    public Grille(int nombreColonnes, int nombreLignes) {
        this.nombreColonnes = nombreColonnes;
        this.nombreLignes = nombreLignes;
        grille = new Case[this.nombreColonnes][this.nombreLignes];
    }
}
