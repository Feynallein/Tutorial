package Part_1;

import Part_2.Avancer;
import Part_2.Parcours;

/**
 * Il s'agit du modele
 */
public class Etat {
    /**
     * Constante : Taille du saut de l'ovale
     */
    public static final int JUMP_HEIGHT = Affichage.OVAL_HEIGHT/2;

    /**
     * Coordonnee selon y de l'ovale a un instant T
     */
    public int hauteur;

    /**
     * La ligne brisee
     */
    public Parcours parcours;

    /**
     * Constructeur de la classe
     */
    public Etat(){
        this.hauteur = Affichage.Y;
        this.parcours = new Parcours();
        (new Avancer(this.parcours)).start();
    }

    /**
     * Permet d'effectuer un saut
     */
    public void jump(){
        if(hauteur - JUMP_HEIGHT >= 0) hauteur -= JUMP_HEIGHT ;
    }

    /**
     * Getter de hauteur
     * @return Renvoit la hauteur
     */
    public int getHauteur(){
        return hauteur;
    }
}
