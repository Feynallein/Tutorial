import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Permet de creer la ligne brisee et de la faire "reculer" afin de donner l'impression de defilement
 */
public class Parcours {
    /**
     * Constante : Nombre de pixel dont on avance par tick
     */
    public static final int AVANCER = 2;

    /**
     * Constante : Longueur maximale d'une ligne
     */
    public static final int MAX_LENGTH = Affichage.OVAL_WIDTH*20;

    /**
     * Constante : Longueur minimale d'une ligne
     */
    public static final int MIN_LENGTH = Affichage.OVAL_WIDTH*4;

    /**
     * Constante : Angle maximal entre deux lignes
     */
    public static final int MAX_ANGLE = 45;

    /**
     * Liste des points qui forment les lignes
     */
    private final ArrayList<Point> points = new ArrayList<>();

    /**
     * Score du joueur
     */
    public int position;

    private final Random r = new Random();

    /**
     * Constructeur de la classe Parcours
     */
    public Parcours() {
        initParcours();
        position = 0;
    }

    /**
     * Initialise la liste de points quand le jeu se lance pour la premiere fois
     */
    private void initParcours(){
        // On cree le premier point au centre de l'ovale
        int x = Affichage.X + Affichage.OVAL_WIDTH/2, y = Affichage.Y + Affichage.OVAL_HEIGHT;
        Point p = new Point(x, y);
        points.add(p);
        p = new Point(p.x + MAX_LENGTH, p.y);
        points.add(p);
        // Tant qu'on ne sort pas du cadre
        while(x <= Affichage.WIDTH){
            // Creation du nouveau point en x
            x = r.nextInt((MAX_LENGTH + p.x) - (p.x + MIN_LENGTH)) + p.x + MIN_LENGTH;

            // Creation du nouveau point en y, en verifiant qu'on ne sort pas de la fenetre
            y = createNewY(x, p.x, p.y);

            // Creation et ajout du point a la liste
            p = new Point(x, y);
            points.add(p);
        }
    }

    /**
     * Permet de créer un nouveau Y
     * @param x La nouvelle coordonnée x
     * @param oldX L'ancienne coordonnée x
     * @param oldY L'ancienne coordonnée y
     * @return la nouvelle coordonnée y
     */
    private int createNewY(int x, int oldX, int oldY) {
        int y;
        do{
            int hypotenuse = Math.abs(x - oldX);
            double sinus = Math.sin(r.nextInt(MAX_ANGLE));
            int hauteur = (int) (hypotenuse * sinus) * (r.nextInt(2) == 0 ? -1 : 1);
            y = Math.abs(hauteur + oldY);
        }while((y < Affichage.OVAL_HEIGHT || y > Affichage.HEIGHT - Affichage.OVAL_HEIGHT));
        return y;
    }

    /**
     * Permet de rajouter des points quand il n'y en a plus assez
     * @param x Coordonnee x du dernier point
     * @param y Coordonnee y du dernier point
     */
    private void add(int x, int y){
        // Calcul de la coordonnee x
        int newX = r.nextInt((MAX_LENGTH + x) - (x + MIN_LENGTH)) + x + MIN_LENGTH;

        // Calcul de la coordonnee y et verification qu'on ne sort pas de la fenetre
        int newY = createNewY(x, newX, y);

        // Ajout du nouveau point
        points.add(new Point(newX, newY));
    }

    /**
     * Change la position de tout les points et supprimment ceux qu'on ne voit plus.
     * Gere aussi quand il faut ajouter un nouveau point
     * @return Une liste contenant tout les points a afficher
     */
    public ArrayList<Point> getParcours() {
        ArrayList<Point> res = new ArrayList<>();
        if(points.get(points.size() - 2).x < Affichage.WIDTH) add(points.get((points.size() - 1)).x, points.get((points.size() -1)).y);
        if(points.get(2).x <= 1) points.remove(0);
        for(Point p : points){
            p.x -= AVANCER;
            res.add(p);
        }
        return res;
    }

    /**
     * Increment de la position a chaque tick
     */
    public void setPosition() {
        position += AVANCER;
    }

    /**
     * Getter du score
     * @return le score du joueur
     */
    public int getScore(){
        return position/2;
    }
}
