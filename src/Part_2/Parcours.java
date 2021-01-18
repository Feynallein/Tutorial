package Part_2;

import Part_1.Affichage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    private final ArrayList<Point> points = new ArrayList<>();
    private final Random r = new Random();
    public static final int AVANCER = 1;
    public static final int MAX_LENGTH = Affichage.OVAL_WIDTH*15;
    public static final int MIN_LENGTH = Affichage.OVAL_WIDTH*3;
    public static final float MAX_ANGLE = 90;
    private int position;

    public Parcours() {
        initParcours();
        position = 0;
    }

    private void initParcours(){
        int hypotenuse, max_y, min_y;

        // On cree le premier point au centre de l'ovale
        int x = Affichage.X + Affichage.OVAL_WIDTH/2, y = Affichage.Y + Affichage.OVAL_HEIGHT/2;
        Point p = new Point(x, y);
        points.add(p);

        // Tant qu'on ne sort pas du cadre
        while(x <= Affichage.WIDTH){
            // Creation du nouveau point en x
            x = r.nextInt((MAX_LENGTH + p.x) - (p.x + MIN_LENGTH)) + p.x + MIN_LENGTH;

            // Creation du nouveau point en y, en verifiant qu'on ne sort pas de la fenetre
            hypotenuse = (int) (Math.sin(MAX_ANGLE) * x);
            max_y = Math.min(p.y + hypotenuse, Affichage.HEIGHT - Affichage.OVAL_HEIGHT);
            min_y = Math.max(p.y - hypotenuse, Affichage.OVAL_HEIGHT);
            y = r.nextInt(max_y - min_y) + min_y;

            // Creation et ajout du point a la liste
            p = new Point(x, y);
            points.add(p);
        }
    }

    private void add(int x, int y){
        // Calcul de la coordonnee x
        int newX = r.nextInt((MAX_LENGTH + x) - (x + MIN_LENGTH)) + x + MIN_LENGTH;

        // Calcul de la coordonnee y
        int hypotenuse = (int) (Math.sin(MAX_ANGLE) * x);
        int max_y = Math.min(y + hypotenuse, Affichage.HEIGHT - Affichage.OVAL_HEIGHT);
        int min_y = Math.max(y - hypotenuse, Affichage.OVAL_HEIGHT);
        int newY = r.nextInt(max_y - min_y) + min_y;

        // Ajout du nouveau point
        points.add(new Point(newX, newY));
    }

    public ArrayList<Point> getPoints() {
        if(points.get(points.size() - 2).x < Affichage.WIDTH) add(points.get((points.size() - 1)).x, points.get((points.size() - 1)).y);
        if(points.get(2).x <= 1) points.remove(0);
        ArrayList<Point> res = new ArrayList<>();
        for(Point p : points){
            p.x -= position;
            res.add(p);
        }
        return res;
    }

    public void setPosition() {
        this.position += AVANCER;
    }
}
