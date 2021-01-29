import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Permet d'afficher les differentes composantes a l'ecran en fonction de l'etat
 */
public class Affichage extends JPanel {
    /**
     * Constante : Largeur de la fenetre
     */
    public final static int WIDTH = 600;

    /**
     * Constante : Hauteur de la fenetre
     */
    public final static int HEIGHT = 400;

    /**
     * Constante : Hauteur de l'ovale
     */
    public final static int OVAL_HEIGHT = 70;

    /**
     * Constante : Largeur de l'ovale
     */
    public final static int OVAL_WIDTH = 10;

    /**
     * Constante : Coordonnee x d'origine de l'ovale
     */
    public final static int X = WIDTH/2;

    /**
     * Constante : Coordonnee y d'origine de l'ovale
     */
    public final static int Y = HEIGHT/2;

    /**
     * Modele de cette vue
     */
    private final Etat etat;

    /**
     * Constructeur de l'affichage
     * @param etat Il s'agit du modele
     */
    public Affichage(Etat etat){
        // Defini la taille de ce JPanel
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.etat = etat;
    }

    /**
     * Affiche les differentes composantes a l'ecran
     * @param g Graphics sur lequel on doit afficher ce JPanel
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Affiche un oval qui correspond au joueur
        g.setColor(Color.BLACK);
        g.drawOval(X, etat.getHauteur(), OVAL_WIDTH, OVAL_HEIGHT);

        // Afficher la ligne brisee
        ArrayList<Point> ligne = etat.parcours.getParcours();
        for(int i = 0; i < ligne.size() - 1; i++){
            g.setColor(Color.RED);
            g.drawLine(ligne.get(i).x, ligne.get(i).y, ligne.get(i+1).x, ligne.get(i+1).y);
        }

        // Affichage du score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospaced", Font.PLAIN, 50));
        g.drawString("Score : " + etat.parcours.getScore(), 50, 50);
    }
}
