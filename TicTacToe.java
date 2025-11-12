import java.util.Scanner;

// Class et fonction necessaire pour run un fichier java
class TicTacToe {
    public static char[][] board = {
            { '.', '.', '.' },
            { '.', '.', '.' },
            { '.', '.', '.' },
    };

    public static char symbol = 'x';

    public static void display() {
        for (char[] eachLine : board) { // equivalent forEach // print chaque ligne
            System.out.println(eachLine);
        }
    }

    public static void play() {
        System.out.println("Pseudo du joueur x : ");
        String playerX = scan.nextLine();
        System.out.println("Pseudo du joueur o : ");
        String playerO = scan.nextLine();
        int round=0;
        display();
        boolean mustEnd = false;
        while (true) {

            try {

                // Permet de choisir sur quelle ligne et quelle colonne placer le symbole
                System.out.println("Quelle ligne? (entre 0 et 2, + de 3 = fin de partie)");
                int ligne = scan.nextInt();
                if (ligne > 2) {
                    System.out.println("Fin de partie");
                    break;
                }
                System.out.println("Quelle colonne? (entre 0 et 2, + de 3 = fin de partie)");
                int colonne = scan.nextInt();
                if (colonne > 2) {
                    System.out.println("Fin de partie");
                    break;
                }
                if (board[ligne][colonne] != '.') {
                    System.out.println("Impossible, il y a déjà un autre symbole");
                    continue;
                }
                board[ligne][colonne] = symbol;
                display();
                symbol = symbol == 'x' ? 'o' : 'x';
                round+=1;

                // Parcours horizontal
                for (int i = 0; i < board.length; i++) {
                    if (board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x') {
                        System.out.println(playerX + " à battu " + playerO);
                        mustEnd = true;
                    } else if (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o') {
                        System.out.println(playerO + " à battu " + playerX);
                        mustEnd = true;
                    }
                }

                // Parcours vertical
                for (int j = 0; j < board.length; j++) {
                    if (board[0][j] == 'x' && board[1][j] == 'x' && board[2][j] == 'x') {
                        System.out.println(playerX + " à battu " + playerO);
                        mustEnd = true;
                    } else if (board[0][j] == 'o' && board[1][j] == 'o' && board[2][j] == 'o') {
                        System.out.println(playerO + " à battu " + playerX);
                        mustEnd = true;
                    }
                }

                // Parcours diagonal de gauche à droite
                if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') {
                    System.out.println(playerX + " à battu " + playerO);
                    mustEnd = true;
                } else if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') {
                    System.out.println(playerO + " à battu " + playerX);
                    mustEnd = true;
                }

                // Parcours diagonal de droite à gauche
                if (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') {
                    System.out.println(playerX + " à battu " + playerO);
                    mustEnd = true;
                } else if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o') {
                    System.out.println(playerO + " à battu " + playerX);
                    mustEnd = true;
                }
                if (mustEnd == true) {
                    break;
                }
                if (round==9) {
                    System.out.println("Égalité !");
                    break;
                }
            } catch (Exception e) {

                scan.nextLine();
            }
        }
    }

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] params) {
        play();
        display();
    }
}