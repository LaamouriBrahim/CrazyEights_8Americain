
import java.util.*;

public class CollectionCartes implements Iterable<Carte> {

    protected ArrayList<Carte> paquet  ;

    /**
     * Constructeur sans argument de la classe CollectionCartes
     */
    public CollectionCartes(){

        paquet = new ArrayList<>();

    }

    /**
     * l'accesseur de l'attribut paquet
     * @return le paquet
     */
    public ArrayList<Carte> getPaquet() {
        return paquet;
    }

    /**
     * Fonction ajouter qui ajoute les éléments dans une collection de cartes
     * @param carte la carte qu'on veut ajouter
     */
    public void ajouter(Carte carte){

        paquet.add(carte);

    }

    /**
     * la méthode permettant de construire un paquet de cartes et les mélanger par la suite
     */
    public void construirePaquet() {
        for (Couleur couleur : Couleur.values()) {
            for (Hauteur hauteur : Hauteur.values()) {
                Carte card = new Carte(hauteur, couleur);
                ajouter(card);
            }
        }
        Collections.shuffle(paquet);
    }

    /**
     * la méthode permettant de mélanger une collection de cartes
     */
    public void melanger(){

        Collections.shuffle(paquet);

    }

    /**
     * la méthode permettant de vider un paquet
     */
    public void viderPaquet(){

        paquet.clear();

    }

    @Override
    public String toString() {
        return " " + getPaquet() ;
    }

    /**
     * la surcharge de la méthode iterator de l'interface Iterable
     * @return l'Iterator du ArrayList paquet
     */
    @Override
    public Iterator<Carte> iterator() {

        return paquet.iterator();

    }


}
