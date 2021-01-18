package Part_1;

import javax.swing.*;
import java.awt.*;

/**
 * Classe affichage
 * Permet d'afficher les differentes composantes a l'ecran en fonction de l'etat
 */
public class Affichage extends JPanel {
    /**
     * Constantes : width = largeur, height = hauteur, ovalHeight = hauteur de l'oval, ovalWidth = largeur de l'oval, x = coordonee x de départ de l'oval
     *              y = coordonee y de départ de l'oval
     */
    public final static int width = 600, height = 400, ovalHeight = 50, ovalWidth = 10, x = ovalWidth * 3, y = height - ovalHeight - 1;
    private final Etat etat;

    /**
     * Constructeur de l'affichage
     * @param etat - Il s'agit du modele
     */
    public Affichage(Etat etat){
        // Defini la taille de ce JPanel
        setPreferredSize(new Dimension(width, height));
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
        g.drawOval(x, etat.getHauteur(), ovalWidth, ovalHeight);
    }
}
