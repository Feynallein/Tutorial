package Part_1;

import Part_2.Avancer;
import Part_2.Parcours;

/**
 * Class etat
 * Il s'agit du modele
 */
public class Etat {
    public int hauteur;
    public static final int JUMP_HEIGHT = 30;
    public Parcours parcours;
    public Avancer avancer;

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
     * @return - renvoit la hauteur
     */
    public int getHauteur(){
        return hauteur;
    }
}
