import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Partie{
    public static void main(String[] args) {

        CollectionCartes paquet = new CollectionCartes();
        TasDeCartes defausse = new TasDeCartes();
        TasDeCartes pioche = new TasDeCartes();
        MainJoueur [] hands = {new MainJoueur() ,new MainJoueur() ,new MainJoueur()};

        Joueur []  players = { new Joueur("Newton ", hands[0]), new Joueur("Einstein", hands[1]), new Joueur("Galois", hands[2]) };

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nombres des manches souhaitées : \n");
        int manches = sc.nextInt();
        for(int k =0 ; k < manches ; k++) {
            System.out.println("On distribue les cartes pour pouvoir commencer la partie de Crazy Eights ");
            paquet.construirePaquet();
            pioche.construirePioche(paquet);
            defausse.construireDefausse(pioche);
            for (int i = 0; i < hands.length; i++)
                hands[i].construireMainJoueur(pioche);


            System.out.println("============================================================================================");

            System.out.println("Les joueurs et leurs mainJoueur après la distribution et avant  le début de la partie ");

            for (int i = 0; i < players.length; i++)
                System.out.println(players[i]);

            System.out.println("============================================================================================");

            System.out.println(" Le contenu de la pioche après la distribution  " + pioche);

            System.out.println("============================================================================================");

            System.out.println("Le contenu de la défausse après la distribution, il affiche la carte suivant : " + defausse);

            System.out.println("============================================================================================");


            System.out.println("Ici, on affiche le déroulement du jeux ");

            System.out.println("============================================================================================");

            while (!(hands[0].paquet.size() <= 0 || hands[1].paquet.size() <= 0 || hands[2].paquet.size() <= 0)) {

                for (int i = 0; i < players.length; i++) {

                    players[i % 3].jouer(defausse, pioche, players[(i + 1) % 3]);

                    //si le joueur joue une carte d'hauteur 1, le joueur suivant va devoir piocher deux cartes
                    if (defausse.getDernier().getHauteur().getHauteur() == 1) {
                        System.out.println("le joueur " + players[i % 3].getNom() + " demande au joueur suivant de piocher 2 cartes ");
                        for (int j = 0; j <= 2; j++)
                            players[(i + 1) % 3].getMainJoueur().piocher(pioche);
                        break;
                    }
                    //si le joueur joue une carte d'hauteur 7, le joueur suivant va devoir sauter son tour
                    if (defausse.getDernier().getHauteur().getHauteur() == 7) {
                        System.out.println("le joueur " + players[(i + 1) % 3].getNom() + " saute son tour");
                        players[(i + 2) % 3].jouer(defausse, pioche, players[(i + 3) % 3]);
                        break;
                    }
                    //si le joueur joue une carte d'hauteur 8, on choisit une couleur aléatoirement pour la carte suivant
                    if (defausse.getDernier().getHauteur().getHauteur() == 8) {
                        System.out.println("le joueur " + players[i % 3].getNom() + " a changé la couleur des cartes ");
                        ArrayList<Couleur> couleurs = new ArrayList<>(4);
                        couleurs.add(Couleur.CARREAUX);
                        couleurs.add(Couleur.TREFLES);
                        couleurs.add(Couleur.PIQUES);
                        couleurs.add(Couleur.COEURS);
                        Collections.shuffle(couleurs);
                        defausse.getDernier().setCouleur(couleurs.get(0));
                        break;
                    }
                    //si le joueur joue une carte d'hauteur 10, le joueur jouera une autre fois
                    if (defausse.getDernier().getHauteur().getHauteur() == 10) {
                        System.out.println("le joueur " + players[i % 3].getNom() + " va jouer une autre fois ");
                        players[i % 3].jouer(defausse, pioche, players[(i + 1) % 3]);
                        break;
                    }
                    //si le joueur joue une carte d'hauteur 11, la direction change
                    if (defausse.getDernier().getHauteur().getHauteur() == 11) {
                        System.out.println("le joueur " + players[i % 3].getNom() + " change la direction ");
                        players[(players.length - 1 - i) % 3].jouer(defausse, pioche, players[((players.length - 2 - i)) % 3]);
                        break;
                    }
                    // si la pioche est vide; on reconstruit une autre pioche
                    if (pioche.paquet.size() <= 0) {
                        pioche.reConstruireLaPioche(defausse);
                        pioche.melanger();
                        System.out.println("le  pioche est vide, on reconstruit une autre pioche ");
                        break;
                    }
                }
            }


            System.out.println("============================================================================================");


            System.out.println(" La defausse  après la fin de la partie  " + defausse);


            System.out.println("============================================================================================");

            System.out.println(" La pioche après la fin de  la partie  " + pioche);

            System.out.println("============================================================================================");

            System.out.println("les joueurs et leurs mains après la fin de la partie ");

            System.out.println("--------------------------------------------------------------------------------------------");


            for (int i = 0; i < players.length; i++) {
                System.out.println(players[i]);
                System.out.println("============================================================================================");

            }

            for (int i = 0; i < players.length; i++) {
                System.out.println("Les points du joueur " + players[i].getNom() + " sont " + players[i].getScore());

            }

            System.out.println("============================================================================================");

            for (int i = 0; i < players.length; i++) {
                if (players[i].getScore() == 0)
                    System.out.println("le joueur " + players[i].getNom() + " a gagné la partie");
            }
        }
    }
}