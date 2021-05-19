public enum Hauteur {

    AS("as", 1),
    DEUX("Deux", 2),
    TROIS("Trois", 3),
    QUATRE("Quatre", 4),
    CINQ("Cinq", 5),
    SIX("Six", 6),
    SEPT("Sept", 7),
    HUIT("Huit", 8),
    NEUF("Neuf",9),
    DIX("Dix",10),
    VALET("Valet",11),
    DAME("Dame",12),
    ROI("Roi",13);

    private final String nom;
    private final int hauteur;

    private Hauteur(String nom, int hauteur) {
        this.nom = nom;
        this.hauteur = hauteur;
    }

    public String getNom() {
        return nom;
    }

    public int getHauteur() {
        return hauteur;
    }
}

