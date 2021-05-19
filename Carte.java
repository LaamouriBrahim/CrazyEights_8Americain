import java.util.*;
public class Carte implements Comparable<Carte> {

    private Hauteur hauteur;
    private Couleur couleur;
    private String symbole;

    /**
     * Constructeur de la carte
     * @param hauteur la hauteur de la carte
     * @param couleur la couleur de la carte
     */
    public Carte(Hauteur hauteur, Couleur couleur) {
        this.hauteur = hauteur;
        this.couleur = couleur;
    }



    public Hauteur getHauteur() {
        return hauteur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     *  méthode qui  remplace les nombres égale à 1 ou entre 11 et 13 par leurs symbole
     * @return le symbole qui convient à chaque hauteur entre 11 et 13 ou égale à 1
     */
    public String getSymbole() {
        String symbole;
        if(this.hauteur.getHauteur()>1 && this.hauteur.getHauteur()<11){
            symbole = ""+ this.hauteur;
            this.symbole = symbole;
            return this.symbole;
        }
        else
        {
            switch (this.hauteur.getHauteur())
            {
                case 11:
                    this.symbole="V";
                    break;
                case 12:
                    this.symbole="D";
                    break;
                case 13:
                    this.symbole="R";
                    break;
                case 1:
                    this.symbole="A";
                    break;
            }
            return this.symbole;
        }
    }

    /**
     * la surchage de la méthode equals
     * @param card  la carte avec laquelle on teste l'égalisation
     * @return vrai si les deux carte sont identiques, et faux sinon
     */
    @Override
    public boolean equals(Object card) {
        Carte carte = (Carte) card;
        if (this.hauteur == carte.hauteur && this.couleur == carte.couleur) return true;
        return false;
    }

    /**
     * méthode compareTo qui compare deux carte
     * @param c la carte avec laquelle on teste la comparaison
     * @return zéro si les deux cartes sont identiques, 1 et -1 sinon
     */
    public int compareTo(Carte c) {
        if (this.hauteur.getHauteur() == c.hauteur.getHauteur()) return 0;
        if (this.hauteur.getHauteur() < c.hauteur.getHauteur()) return -1;
        return 1;
    }

    @Override
    public String toString() {

        String resultat = "";
        if(getHauteur().getHauteur() ==1)
            resultat = "(AS de "+getCouleur() +")";
        if(getHauteur().getHauteur() ==11)
            resultat = "(VALET de "+getCouleur()+")";
        if(getHauteur().getHauteur() ==12)
            resultat = "(DAME de "+getCouleur()+")";
        if(getHauteur().getHauteur() ==13)
            resultat = "(ROI de "+getCouleur()+")";
        if(getHauteur().getHauteur() >1 && getHauteur().getHauteur()<11)
            resultat = "("+getHauteur().getHauteur()+" de "+getCouleur()+")";

        return resultat;
    }

}


