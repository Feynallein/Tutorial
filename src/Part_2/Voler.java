package Part_2;

import Part_1.*;

import javax.swing.*;

/**
 * Permet de faire descendre l'ovale
 */
public class Voler implements Runnable {
    /**
     * Constante : Vitesse de ce thread
     */
    public static final int SPEED = 25;

    /**
     * Le modele
     */
    private Etat modele;

    /**
     * La vue
     */
    private Affichage vue;

    /**
     * Le controleur
     */
    private Control controleur;

    /**
     * Fait descendre l'ovale a chaque tick
     */
    @Override
    public void run(){
        while(true){
            controleur.moveDown();
            try {
                Thread.sleep(SPEED);
            } catch (Exception e) { e.printStackTrace();}
        }
    }

    /**
     * Creation de la fenetre, de la vue, du modele, du controleur et execution du thread
     */
    public void start(){
        // Creation du modele, de la vue, et du controleur
        modele = new Etat();
        vue = new Affichage(modele);
        controleur = new Control(vue, modele);

        // Creation de la fenetre
        JFrame display = new JFrame("Bootleg Flappy Bird");
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.add(vue);
        display.pack();
        display.setVisible(true);

        // Exectuer le thread
        run();
    }
}
