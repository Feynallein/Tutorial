package Part_1;

/**
 * Class etat
 * Il s'agit du modele
 */
public class Etat {
    public int hauteur;

    /**
     * Constructeur de la classe
     */
    public Etat(){
        hauteur = Affichage.y;
    }

    /**
     * Permet d'effectuer un saut
     */
    public void jump(){
        if(hauteur - 10 >= 0 && hauteur - 10  + Affichage.ovalHeight <= Affichage.height) hauteur -= 10 ;
    }

    /**
     * Getter de hauteur
     * @return - renvoit la hauteur
     */
    public int getHauteur(){
        return hauteur;
    }
}
