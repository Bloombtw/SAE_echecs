import java.util.Scanner;

public class Plateau {

    public static void afficherEnLigne(String c, int longueur) {
        if (longueur < 0) {
            System.out.println("ERREUR! afficherEnLigne : longueur négative ("
                    + longueur + ")");
        } else {
            for (int colonne = 1; colonne <= longueur; colonne++) {
                System.out.print(c);
            }
        }
    }

    // Création des contours de l'échiquier
    public static void afficherEchiquier(char[][] echiquier) {

        int ligne = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("--------------");
            }
            System.out.println("+");
            for (int j = 0; j < 8; j++) {
                System.out.print("|      " + echiquier[ligne][j] + "      ");
            }
            ligne++;
            System.out.println("|");
        }
        afficherEnLigne("-",112);
        System.out.println("+");
}

    public static String[][] transformationDuCharEnAscii(char[][] echiquier) {
        String[][] echiquierDaffichage = new String[echiquier.length][echiquier[0].length];
        for (int i = 0; i < echiquierDaffichage.length; i++) {
            for (int j = 0; j < echiquierDaffichage[i].length; j++) {
                if (echiquier[i][j] == 't') {
                    echiquierDaffichage[i][j] = "♖";
                }
                else if (echiquier[i][j] == 'c') {
                    echiquierDaffichage[i][j] = "♘";
                }
                else if (echiquier[i][j] == 'f') {
                    echiquierDaffichage[i][j] = "♗";
                }
                else if (echiquier[i][j] == 'd') {
                    echiquierDaffichage[i][j] = "♕";
                }
                else if (echiquier[i][j] == 'r') {
                    echiquierDaffichage[i][j] = "♔";
                }
                else if (echiquier[i][j] == 'p') {
                    echiquierDaffichage[i][j] = "♙";
                }

                else if (echiquier[i][j] == 'T') {
                    echiquierDaffichage[i][j] = "♜";
                }
                else if (echiquier[i][j] == 'C') {
                    echiquierDaffichage[i][j] = "♞";
                }
                else if (echiquier[i][j] == 'F') {
                    echiquierDaffichage[i][j] = "♝";
                }
                else if (echiquier[i][j] == 'D') {
                    echiquierDaffichage[i][j] = "♛";
                }
                else if (echiquier[i][j] == 'R') {
                    echiquierDaffichage[i][j] = "♚";
                }
                else if (echiquier[i][j] == 'P') {
                    echiquierDaffichage[i][j] = "♟";
                }
                else if (echiquier[i][j] == ' ') {
                    echiquierDaffichage[i][j] = " ";
                }
            }
        }
        return echiquierDaffichage;
    }

    public static void nomDesPieces() { // Cette méthode n'est pas utilisée mais sert d'index pour savoir les valeurs des pièces

        // Déf des valeurs des cases
        char caseBlanc = 'B';
        char caseNoir = 'N';
        char caseVide = ' ';

        // Déf des valeurs des pièces
        char pionBlanc = 'p';
        char cavalierBlanc ='c';
        char fouBlanc = 'f';
        char tourBlanc = 't';
        char dameBlanc = 'd';
        char roiBlanc = 'r';

        char pionNoir = 'P';
        char cavalierNoir = 'C';
        char fouNoir = 'F';
        char tourNoir = 'T';
        char dameNoir = 'D';
        char roiNoir = 'R';
    }

    public static void metLesCouleursDesCasesSurEchiquier(char[][] échiquier) {

        char caseBlanc = 'B';
        char caseNoir = 'N';
        for (int ligne = 0; ligne < 8; ligne ++) { // Si case blanche alors somme de ligne + colonne est pair, sinon c'est une case noire.
            for (int colonne = 0; colonne < 8; colonne++) {
               if ((ligne + colonne) %2 == 0) {
                   échiquier[ligne][colonne] = caseBlanc;
               }
               else {
                   échiquier[ligne][colonne] = caseNoir;
               }
            }
        }
    }



    // Mise en place des pièces dans les bonnes cases au début de la partie
    public static void insertionDesPieces(char[][] échiquier) {

        // Mise en place du jeu noir (tour cavalier fou dame roi fou cavalier tour)
        String premiereLigneNoire = "TCFDRCFT";
        String deuxiemeLigneNoire = "PPPPPPPP";
        for ( int ligne =0; ligne< 8; ligne++){ // Remplissage des deux premières lignes ( en partant du haut, le jeu noir)
            échiquier[0][ligne] = premiereLigneNoire.charAt(ligne); // Pièces
            échiquier[1][ligne] = deuxiemeLigneNoire.charAt(ligne); // Pions
        }

        // Mise en place du jeu blanc (tour cavalier fou dame roi fou cavalier tour)
        String premiereLigneBlanche = "tcfdrcft";
        String deuxiemeLigneBlanche = "pppppppp";
        for (int ligne =0; ligne< 8; ligne++){ // Remplissage des deux dernières lignes ( en partant du haut, le jeu blanc)
            échiquier[7][ligne] = premiereLigneBlanche.charAt(ligne); // Pièces
            échiquier[6][ligne] = deuxiemeLigneBlanche.charAt(ligne); // Pions
        }

        // Remplir le reste des cases du tableau en vide
        char caseVide = ' ';
        for (int ligne = 2; ligne < 6 ; ligne++) {
            for ( int colonne = 0; colonne < 8; colonne++) {
                échiquier[ligne][colonne] = caseVide;
            }
        }
    }
    public static void afficherEchiquierString(String[][] echiquier) {

        int ligne = 0;
        int compteur = 8;
        System.out.println("       A             B             C             D             E             F             G             H");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("--------------");
            }
            System.out.println("+");
            for (int j = 0; j < 8; j++) {
                System.out.print("|      " + echiquier[ligne][j] + "      ");
            }
            ligne++;
            System.out.print("|  ");
            System.out.println(compteur);
            compteur --;
        }
        afficherEnLigne("-",112);
        System.out.println("+");
    }

    // Uniquement envoyer un String de longueur 2 ex : "A6" -> renvoie la position en coordonnées java du tableau. Tjrs en suivant l'ex,
    // le programme renvoie un tab de int de longueur 2 : { 0, 5 }
    public static int[] traduisCoordonnées(String coordonneesEchecs) {
        int[] coordonnees = new int[2];
        char coordonnee1 = coordonneesEchecs.charAt(0); // tjrs dans l'exemple du dessus, prend le A
        char coordonnee2 = coordonneesEchecs.charAt(1); // Prends le 6
        switch (coordonnee1) {
            case 'A':
                coordonnees[1] = 0;
                break;
            case 'B':
                coordonnees[1] = 1;
                break;
            case 'C':
                coordonnees[1] = 2;
                break;
            case 'D':
                coordonnees[1] = 3;
                break;
            case 'E':
                coordonnees[1] = 4;
                break;
            case 'F':
                coordonnees[1] = 5;
                break;
            case 'G':
                coordonnees[1] = 6;
                break;
            case 'H':
                coordonnees[1] = 7;
                break;
        }
        switch (coordonnee2) {
            case '1':
                coordonnees[0] = 7;
                break;
            case '2':
                coordonnees[0] = 6;
                break;
            case '3':
                coordonnees[0] = 5;
                break;
            case '4':
                coordonnees[0] = 4;
                break;
            case '5':
                coordonnees[0] = 3;
                break;
            case '6':
                coordonnees[0] = 2;
                break;
            case '7':
                coordonnees[0] = 1;
                break;
            case '8':
                coordonnees[0] = 0;
                break;
        }
        return coordonnees;
    }

    public static void coordonneeEstJuste(String choix) {
        Scanner sc = new Scanner(System.in);
        if (!(choix.length() > 0 && choix.charAt(0) >= 'A' && choix.charAt(0) <= 'H') || (!(choix.length() > 0 && choix.charAt(1) >= '0' && choix.charAt(1) <= '8')) || (choix.length() > 2)) {
            System.out.println("Erreur, vous devez rentrer une coordonnée comme 'A4' par exemple.");
            System.out.println("Rentrez une nouvelle valeur : ");
            choix = sc.nextLine();
        }
    }

    public static void metAJourLePlateauEnAsciiEtLaffiche() {
        Main.echiquierString = Plateau.transformationDuCharEnAscii(Main.echiquier);
        Plateau.afficherEchiquierString(Main.echiquierString);
    }

}


