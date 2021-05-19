import java.util.ArrayList;
import java.util.Collections;

public class Joueur extends MainJoueur {
    private String nom;
    private MainJoueur mainJoueur = new MainJoueur();

    //Constructeurs
    public Joueur(String nom, MainJoueur mainJoueur) {
        this.nom = nom;
        this.mainJoueur = mainJoueur;
    }
    // les acesseurs

    public String getNom() {
        return nom;
    }

    public MainJoueur getMainJoueur() {
        return mainJoueur;
    }

    /**
     * la fonction jouer qui permet à un joueur de jouer une carte selon les cas qu'on gére dans la méthode
     * Notons bien qu'on va gérer les cas pour les cartes spécifiques dans classe partie
     *
     * @param defausse la defausse dans laquelle on met la carte
     * @param pioche   la pioche
     * @param player   le joueur suivant qui va jouer après le joueur appelant la fonction
     */
    public void jouer(TasDeCartes defausse, TasDeCartes pioche, Joueur player) {
        boolean defausser = false;

        for (Carte c : this.mainJoueur) {
            if (c.getHauteur().getHauteur() == 8 || c.getHauteur().getHauteur() == defausse.getDernier().getHauteur().getHauteur() || c.getCouleur().getNom().equals(defausse.getDernier().getCouleur().getNom())) {
                defausse.ajouter(c);
                mainJoueur.paquet.remove(c);
                defausser = true;

                break;
            }
        }
        if (!defausser) {
            mainJoueur.piocher(pioche);

        }

    }

    /**
     * la fonction getScore retourne les points de pénalité de chaque joueur qui appelle la fonction
     *
     * @return retourne les points de pénalité d'un joueur
     */
    public int getScore() {
        int score = 0;
        for (Carte c : this.mainJoueur.paquet) {
            switch (c.getHauteur().getHauteur()) {
                case 8:
                    score += 20;
                    break;
                case 11:
                    score += 10;
                    break;
                case 12:
                    score += 10;
                    break;
                case 13:
                    score += 10;
                    break;
                default:
                    score += c.getHauteur().getHauteur();
                    break;

            }
        }
        return score;
    }

    @Override
    public String toString() {
        return " Le joueur  " +getNom()+ " : \n La main de ce joueur est  " + getMainJoueur() ;

    }
}






