package java.com.game;

import java.util.Random;
import java.util.Scanner;

public class GameLogic implements Constants {
    Scanner scanner;
    Random random;

    private boolean boxEmpty = false;

    public GameLogic() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }


    public void startGame() {

        System.out.println(ENTER_BOX_NUMBER_TO_SELECT_ENJOY);

        while (true) {
            System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");

            if (!boxEmpty) {
                for (int j = 0; j < BOARD_SIZE; j++)
                    board[j] = ' ';
                boxEmpty = true;
            }

            while (true) {
                int input = scanner.nextInt();
                if (input > 0 && input < 10) {
                    if (board[input - 1] == 'X' || board[input - 1] == 'O')
                        System.out.println(THAT_ONE_IS_ALREADY_IN_USE_ENTER_ANOTHER);
                    else {
                        board[input - 1] = 'X';
                        break;
                    }
                } else {
                    System.out.println(INVALID_INPUT_ENTER_AGAIN);
                }
            }

            if (isWin(board, 'X') && winner(YOU_WON_THE_GAME)) {
                break;
            }

            if (!isBoxAvailable(board) && winner(IT_S_A_DRAW)) {
                break;
            }

            while (true) {
                int rand = random.nextInt(BOARD_SIZE);
                if (board[rand] != 'X' && board[rand] != 'O') {
                    board[rand] = 'O';
                    break;
                }
            }

            if (isWin(board, 'O') && winner(YOU_LOST_THE_GAME)) {
                break;
            }
        }
    }

    private static boolean isBoxAvailable(final char[] box) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                return true;
            }
        }
        return false;
    }

    private static boolean isWin(final char[] board, final char symbol) {
        return (board[0] == symbol && board[1] == symbol && board[2] == symbol) || (board[3] == symbol && board[4] == symbol && board[5] == symbol)
                || (board[6] == symbol && board[7] == symbol && board[8] == symbol) || (board[0] == symbol && board[3] == symbol && board[6] == symbol)
                || (board[1] == symbol && board[4] == symbol && board[7] == symbol) || (board[2] == symbol && board[5] == symbol && board[8] == symbol)
                || (board[0] == symbol && board[4] == symbol && board[8] == symbol) || (board[2] == symbol && board[4] == symbol && board[6] == symbol);
    }


    private static boolean winner(final String winner) {
        if (winner.equalsIgnoreCase(YOU_WON_THE_GAME)) {
            System.out.println(YOU_WON_THE_GAME);
            System.out.println(CREATED_BY_SHREYAS_SAHE_THANKS_FOR_PLAYING);
            return true;
        } else if (winner.equalsIgnoreCase(YOU_LOST_THE_GAME)) {
            System.out.println(YOU_LOST_THE_GAME);
            System.out.println(CREATED_BY_SHREYAS_SAHE_THANKS_FOR_PLAYING);
            return true;
        } else if (winner.equalsIgnoreCase(IT_S_A_DRAW)) {
            System.out.println(IT_S_A_DRAW);
            System.out.println(CREATED_BY_SHREYAS_SAHE_THANKS_FOR_PLAYING);
            return true;
        }
        return false;

    }
    @Override
    public boolean isBoxEmpty() {
        return boxEmpty;
    }

    @Override
    public void setBoxEmpty(boolean value) {
        boxEmpty = value;
    }

}



