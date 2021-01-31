import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Permet de faire descendre l'ovale
 */
public class Voler implements Runnable {
    /**
     * Constante : Vitesse de ce thread
     */
    public static final int SPEED = 25;

    /**
     * La vue
     */
    private Affichage vue;

    /**
     * Le modele
     */
    private Etat modele;

    /**
     * Le controleur
     */
    private Control controleur;

    /**
     * La frame
     */
    private JFrame display;

    /**
     * Fait descendre l'ovale a chaque tick
     */
    @Override
    public void run(){
        // On laisse un peu de temps au jour pour qu'il voit la ligne
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Boucle du jeu
        while(!controleur.perdu){
            controleur.moveDown();
            try {
                TimeUnit.MILLISECONDS.sleep(SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lose();
    }

    /**
     * Est appellée quand le joueur a perdu
     */
    private void lose(){
        modele.avancer.stopped();
        // Creation du pop-up
        JOptionPane.showMessageDialog(display, "Perdu!\nScore : " + modele.parcours.getScore(), "Fin de jeu", JOptionPane.ERROR_MESSAGE);
        // Quitter
        System.exit(0);

    }

    /**
     * Création du modèle, de la vue et du controlleur
     */
    private void initGame(){
        // Creation du modele, de la vue, et du controleur
        modele = new Etat();
        vue = new Affichage(modele);
        controleur = new Control(vue, modele);

        // Ajout de la vue à la fenêtre
        display.add(vue);
        display.pack();

        // Execution du thread
        this.run();
    }

    /**
     * Creation de la fenêtre et execution du thread
     */
    public void start(){
        // Creation de la fenetre
        display = new JFrame("Bootleg Flappy Bird");
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);

        // Initialisation du jeu
        initGame();
    }
}
