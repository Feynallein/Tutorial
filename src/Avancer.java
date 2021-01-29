import java.util.concurrent.TimeUnit;

/**
 * Permet de faire defiler la ligne brisee
 */
public class Avancer extends Thread {
    /**
     * La ligne brisee
     */
    private final Parcours parcours;

    /**
     * Fait defiler la ligne brisee
     */
    @Override
    public void run() {
        while(true) {
            parcours.setPosition();
            try {
                TimeUnit.MILLISECONDS.sleep(Voler.SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Constructeur de la classe
     * @param parcours Un parcours a faire defiler
     */
    public Avancer(Parcours parcours){
        this.parcours = parcours;
    }
}
