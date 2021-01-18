package Part_1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class Control
 * Il s'agit du controleur
 */
public class Control {
    /**
     * Constructeur de la classe
     * @param affichage - la vue
     * @param etat - le modele
     */
    public Control(Affichage affichage, Etat etat){
        // Ajout d'un mouse listener
        affichage.addMouseListener(new MouseListener() {
            /**
             * Quand on clic sur la souris
             * @param e - le type de mouse event
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                // effectuer le saut
                etat.jump();
                // mettre a jour la vue
                affichage.repaint(new Rectangle(Affichage.x, etat.getHauteur(), Affichage.ovalWidth+1, Affichage.ovalHeight*2));
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
}
