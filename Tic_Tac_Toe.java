import java.util.Scanner;

public class Tic_Tac_Toe {

    static String[] arr = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
    static final String player1 = "X";
    static final String player2 = "O";
    static int turnCounter = 1;
    static Scanner sc = new Scanner(System.in);
    static String checkWinner = " ";

    // 1. method to display the board wherever we need it
    static void board() {
        System.out.println("   " + "|" + "   " + "|" + "   ");
        System.out.println(
            " " +
            arr[0] +
            " " +
            "|" +
            " " +
            arr[1] +
            " " +
            "|" +
            " " +
            arr[2] +
            " "
        );
        System.out.println("---" + "|" + "---" + "|" + "---");
        System.out.println(
            " " +
            arr[3] +
            " " +
            "|" +
            " " +
            arr[4] +
            " " +
            "|" +
            " " +
            arr[5] +
            " "
        );
        System.out.println("---" + "|" + "---" + "|" + "---");
        System.out.println(
            " " +
            arr[6] +
            " " +
            "|" +
            " " +
            arr[7] +
            " " +
            "|" +
            " " +
            arr[8] +
            " "
        );
        System.out.println("   " + "|" + "   " + "|" + "   ");
    }

    // 2. metod to know whos turn is there
    static void turn() {
        board();
        int position;
        while (true) {
            if (turnCounter % 2 == 0) {
                checkWinner = whoIsWinner(1);
                System.out.println("Player 2 enter the position :- ");
                position = sc.nextInt();
                play(2, position);
                break;
            } else {
                checkWinner = whoIsWinner(2);
                System.out.println("Player 1 enter the position :- ");
                position = sc.nextInt();
                play(1, position);
                break;
            }
        }
    }

    //3. to know wheather position is empty or not
    static boolean isEmpty(int position) {
        if (arr[position] == "X" || arr[position] == "O") {
            return false;
        } else {
            return true;
        }
    }

    //4.to put the piece at the position entered by the user
    static void play(int plno, int position) {
        String piece;
        if (plno == 1) {
            piece = "X";
        } else {
            piece = "O";
        }

        if (position <= 8 && position >= 0) {
            if (isEmpty(position)) {
                arr[position] = piece;
                turnCounter++;
            } else {
                System.out.println("position already occupied");
                turn();
            }
        } else {
            System.out.println(" the position must be between 0-8 try again ");
            turn();
        }
    }

    //5. method to chedk the winner
    static String whoIsWinner(int player) {
        String piece;
        int counter = 0;
        if (player == 1) {
            piece = player1;
        } else {
            piece = player2;
        }

        if (arr[0] == piece && arr[1] == piece && arr[2] == piece) {
            return piece;
        } else if (arr[3] == piece && arr[4] == piece && arr[5] == piece) {
            return piece;
        } else if (arr[6] == piece && arr[7] == piece && arr[8] == piece) {
            return piece;
        } else if (arr[0] == piece && arr[3] == piece && arr[6] == piece) {
            return piece;
        } else if (arr[1] == piece && arr[4] == piece && arr[7] == piece) {
            return piece;
        } else if (arr[2] == piece && arr[5] == piece && arr[8] == piece) {
            return piece;
        } else if (arr[0] == piece && arr[4] == piece && arr[8] == piece) {
            return piece;
        } else if (arr[2] == piece && arr[4] == piece && arr[6] == piece) {
            return piece;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == "X" || arr[i] == "O") {
                    counter++;
                }
            }
            if (counter >= 7) {
                return "Draw";
            } else {
                return " ";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("NEW GAME");
        System.out.println();
        System.out.println("Player no.1 will have :- " + player1 + " piece ");
        System.out.println("Player no.2 will have :- " + player2 + " piece ");
        System.out.println();

        while (checkWinner == " ") {
            turn();
        }
        if (checkWinner == "X" || checkWinner == "O") {
            System.out.println(
                "HAHA you thought you had chance to win!?, but the winner is " +
                checkWinner
            );
        } else {
            System.out.println("its " + checkWinner);
        }
    }
}
