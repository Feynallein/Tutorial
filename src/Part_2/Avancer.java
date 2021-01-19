package Part_2;

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
        parcours.setPosition();
    }

    /**
     * Constructeur de la classe
     * @param parcours Un parcours a faire defiler
     */
    public Avancer(Parcours parcours){
        this.parcours = parcours;
    }
}
