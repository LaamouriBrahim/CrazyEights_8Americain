public enum Couleur {
    CARREAUX("Carreaux"),
    COEURS("Coeurs"),
    PIQUES("Piques"),
    TREFLES("Trefles");

    private final String nom;

    private Couleur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
