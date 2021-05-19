

public class TasDeCartes extends CollectionCartes {

    /**
     * la méthode permettant de créer une pioche à partir d'une collection de cartes et vider la collection par la suite
     * @param boite la collection de cartes avec laquelle on crée la pioche
     */
    public void construirePioche(CollectionCartes boite){
        for (int i =0; i<boite.paquet.size(); i++ ) {
            this.ajouter(boite.paquet.get(i));
        }
        boite.viderPaquet();
    }

    /**
     * la méthode permettant de créer une défausse à partir d'une pioche
     * @param laPioche la pioche avec laquelle on crée la défausse
     */
    public void construireDefausse(TasDeCartes laPioche){
        this.ajouter(laPioche.paquet.get(0));
        laPioche.paquet.remove(0);
    }

    /**
     * une fonction qui retourne le dernier élément d'un paquet
     * @return
     */
    public Carte getDernier(){

        return this.paquet.get(paquet.size()-1);
    }

    /**
     * méthode qui sert à reconstruire une pioche à partir d'un défausee dans le cas où la pioche devient vide
     * @param defausse la défausse avec laquelle on construit la pioche
     */
    public void reConstruireLaPioche( TasDeCartes defausse){
        Carte carta = defausse.getDernier();
            for (int i = 0; i < defausse.paquet.size() - 1; i++) {
                this.ajouter(defausse.paquet.get(i));
            }
            defausse.viderPaquet();
            defausse.ajouter(carta);

    }

    @Override
    public String toString() {
        return " " + getPaquet() ;
    }
}
