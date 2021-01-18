package Part_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe affichage
 * Permet d'afficher les differentes composantes a l'ecran en fonction de l'etat
 */
public class Affichage extends JPanel {
    /**
     * Constantes : width = largeur, height = hauteur, ovalHeight = hauteur de l'oval, ovalWidth = largeur de l'oval, x = coordonee x de départ de l'oval
     *              y = coordonee y de départ de l'oval
     */
    public final static int WIDTH = 600, HEIGHT = 400, OVAL_HEIGHT = 70, OVAL_WIDTH = 10, X = 10, Y = (HEIGHT-OVAL_HEIGHT)/2;
    private final Etat etat;

    /**
     * Constructeur de l'affichage
     * @param etat - Il s'agit du modele
     */
    public Affichage(Etat etat){
        // Defini la taille de ce JPanel
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.etat = etat;
    }

    /**
     * Affichage
     * @param g - Graphics sur lequel on doit afficher ce JPanel
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Affiche un oval qui correspond au joueur
        g.setColor(Color.BLACK);
        g.drawOval(X, etat.getHauteur(), OVAL_WIDTH, OVAL_HEIGHT);

        // Afficher la ligne brisee
        ArrayList<Point> ligne = etat.parcours.getPoints();
        for(int i = 0; i < ligne.size() - 1; i++){
            g.setColor(Color.RED);
            g.drawLine(ligne.get(i).x, ligne.get(i).y, ligne.get(i+1).x, ligne.get(i+1).y);
        }
    }
}
