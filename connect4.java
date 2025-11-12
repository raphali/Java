import java.util.Scanner;

class connect4 {

    public static Scanner scan = new Scanner(System.in);

    public static char[][] board = {
            { '.', '.', '.', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.' },
    };

    public static char symbol = 'x';

    public static void display() {
        for (char[] eachLine : board) {
            System.out.println(eachLine);
        }
    }

    public static void play() {
        System.out.println("Pseudo du joueur rouge : ");
        String playerX = scan.nextLine();
        System.out.println("Pseudo du joueur jaune : ");
        String playerO = scan.nextLine();
        int round = 0;
        display();
        boolean mustEnd = false;
        while (true) {
            try {
                System.out.println("Quelle colonne? (entre 0 et 6, + de 6 = fin de partie)");
                int colonne = scan.nextInt();
                if (colonne > 6) {
                    System.out.println("Fin de partie");
                    break;
                } else {
                    for (int i = 5; i > -1; i--) {

                        if (board[i][colonne] == '.') {
                            board[i][colonne] = symbol;
                            display();
                            break;
                        } else {
                            continue;
                        }

                    }
                }
                symbol = symbol == 'x' ? 'o' : 'x';
                round += 1;

                // Parcours horizontal if win
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (board[i][j] == 'x' && board[i][j + 1] == 'x' && board[i][j + 2] == 'x'
                                && board[i][j + 3] == 'x') {
                            System.out.println(playerX + " à battu " + playerO);
                            mustEnd = true;
                        } else if (board[i][j] == 'o' && board[i][j + 1] == 'o' && board[i][j + 2] == 'o'
                                && board[i][j + 3] == 'o') {
                            System.out.println(playerO + " à battu " + playerX);
                            mustEnd = true;
                        }
                    }

                }

                // Parcours vertical
                for (int j = 0; j < board.length; j++) {
                    for (int i = 0; i < 3; i++) {
                        if (board[i][j] == 'x' && board[i + 1][j] == 'x' && board[i + 2][j] == 'x'
                                && board[i + 3][j] == 'x') {
                            System.out.println(playerX + " à battu " + playerO);
                            mustEnd = true;
                        } else if (board[i][j] == 'o' && board[i + 1][j] == 'o' && board[i + 2][j] == 'o'
                                && board[i + 3][j] == 'o') {
                            System.out.println(playerO + " à battu " + playerX);
                            mustEnd = true;
                        }
                    }
                }
                if (mustEnd == true) {
                    break;
                }
                if (round == 42) {
                    System.out.println("Égalité !");
                    break;
                }
            } catch (Exception e) {

                scan.nextLine();
            }
        }
    }

    public static void main(String[] params) {
        play();
        display();
    }
}