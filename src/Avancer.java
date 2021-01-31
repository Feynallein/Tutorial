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
     * Savoir si on stop
     */
    private boolean stop = false;

    /**
     * Fait defiler la ligne brisee
     */
    @Override
    public void run() {
        while(!stop) {
            parcours.setPosition();
            try {
                TimeUnit.MILLISECONDS.sleep(Voler.SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Stop le thread
     */
    public void stopped(){
        stop = true;
    }

    /**
     * Constructeur de la classe
     * @param parcours Un parcours a faire defiler
     */
    public Avancer(Parcours parcours){
        this.parcours = parcours;
    }
}
