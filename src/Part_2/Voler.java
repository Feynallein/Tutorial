package Part_2;

import Part_1.*;

import javax.swing.*;

public class Voler implements Runnable {
    Etat modele;
    Affichage vue;
    Control controleur;

    @Override
    public void run(){
        while(true){
            controleur.moveDown();
            try {
                Thread.sleep(25);
            } catch (Exception e) { e.printStackTrace();}
        }
    }

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
