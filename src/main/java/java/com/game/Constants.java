package java.com.game;

public interface Constants {
    String YOU_WON_THE_GAME = "You won the game!";
    String CREATED_BY_SHREYAS_SAHE_THANKS_FOR_PLAYING = "Created by Shreyas Saha. Thanks for playing!";
    String YOU_LOST_THE_GAME = "You lost the game";
    String IT_S_A_DRAW = "It's a draw!";
    String THAT_ONE_IS_ALREADY_IN_USE_ENTER_ANOTHER = "That one is already in use. Enter another.";
    String INVALID_INPUT_ENTER_AGAIN = "Invalid input. Enter again.";
    String ENTER_BOX_NUMBER_TO_SELECT_ENJOY = "Enter box number to select. Enjoy!\n";
    int BOARD_SIZE = 9;
    int I = 0;

    boolean boxEmpty = false;
    char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    boolean isBoxEmpty();

    void setBoxEmpty(boolean value);


}

