package Part_1;

import javax.swing.*;

/**
 * Class main
 * Sert a lancer le programme
 */
public class Main {
    public static void main(String[] args) {
        // Creation du modele, de la vue, et du controleur
        Etat modele = new Etat();
        Affichage vue = new Affichage(modele);
        Control controleur = new Control(vue, modele);

        // Creation de la fenetre
        JFrame display = new JFrame("Test");
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.add(vue);
        display.pack();
        display.setVisible(true);
    }
}
