import java.awt.*;
import java.util.ArrayList;

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
     * Test si le joueur a perdu
     * @return vrai si le joueur a perdu
     */
    public boolean testPerdu(){
        // On trouve les points dont l'ovale est entre
        ArrayList<Point> points = parcours.getParcours();
        Point avant = new Point(), apres = new Point();
        boolean founded = false;
        int i = 0;
        do{
            if(points.get(i+1).x > Affichage.X){
                avant = points.get(i);
                apres = points.get(i+1);
                founded = true;
            }
            i++;
        }while(!founded);


        // On calcule le coefficient directeur de la droite (Avant Apres)
        float coef = (float) (apres.y - avant.y)/(apres.x - avant.x);

        // On calcule l'ordonnée à l'origine de la droite (Avant Apres)
        float ordo_origine = avant.y - coef * avant.x;

        // On calcule la coordonnée y qui correspond à la coordonnée x de l'ovale grace à l'équation de droite
        int y = (int) (ordo_origine + coef * Affichage.X);

        // On renvoit vrai si le joueur N'A PAS perdu
        return hauteur <= y && hauteur + Affichage.OVAL_HEIGHT >= y;
    }

    /**
     * Getter de hauteur
     * @return Renvoit la hauteur
     */
    public int getHauteur(){
        return hauteur;
    }
}
