package Part_2;

public class Avancer extends Thread {
    private final Parcours parcours;

    public void run() {
        parcours.setPosition();
    }

    public Avancer(Parcours parcours){
        this.parcours = parcours;
    }
}
