package Part_1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class Control
 * Il s'agit du controleur
 */
public class Control {
    public static final int DOWN = 2;
    Affichage affichage;
    Etat etat;

    /**
     * Constructeur de la classe
     * @param affichage - la vue
     * @param etat - le modele
     */
    public Control(Affichage affichage, Etat etat){
        this.affichage = affichage;
        this.etat = etat;
        // Ajout d'un mouse listener
        affichage.addMouseListener(new MouseListener() {
            /**
             * Quand on clic sur la souris
             * @param e - le type de mouse event
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                // Effectuer le saut
                etat.jump();

                // Mettre a jour la vue
                affichage.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
    }

    public void moveDown(){
        if(etat.hauteur + DOWN  + Affichage.OVAL_HEIGHT <= Affichage.HEIGHT) {
            etat.hauteur += DOWN ;
            affichage.repaint();
        }
    }
}
