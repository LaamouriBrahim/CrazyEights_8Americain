public class MainJoueur extends TasDeCartes {



    /**
     * la méthode permettant de créer une main de joueur au début de la partie
     * @param laPioche le pioche avec laquelle on crée la main de joueur
     */
    public void  construireMainJoueur(TasDeCartes  laPioche){
        for (int i = 0;i < 5 ;i++) {
            this.ajouter(laPioche.paquet.get(0));
            laPioche.paquet.remove(0);

        }

    }

    /**
     * la méthode qui permet de pioche une carte par un joueur
     * @param pioche la pioche
     */
    public void piocher(TasDeCartes pioche){
        this.ajouter(pioche.paquet.get(0));
        pioche.paquet.remove(0);
    }

    /**
     * la méthode qui permet de défausser une carte par un joueur
     * @param defausse la défausse dans laquelle on met la carte
     * @param indice l'indice de la carte à défausser
     */
    public void defausser(TasDeCartes defausse, int indice){

        defausse.ajouter(this.paquet.get(indice));
        this.paquet.remove(indice);

    }


    @Override
    public String toString() {
        return " "+ getPaquet() ;
    }
}
