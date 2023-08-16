import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameHelper {
    private static final int GRID_SIZE = 7;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }

    public String generateLocation() {
        int shipSize = 3;
        int direction = (int) (Math.random() * 2);
        int[] startingPoint = new int[2];

        if (direction == 0) {
            // Horizontal
            startingPoint[0] = (int) (Math.random() * GRID_SIZE);
            startingPoint[1] = (int) (Math.random() * (GRID_SIZE - shipSize + 1));
        } else {
            // Vertical
            startingPoint[0] = (int) (Math.random() * (GRID_SIZE - shipSize + 1));
            startingPoint[1] = (int) (Math.random() * GRID_SIZE);
        }

        char row = (char) (startingPoint[0] + 'A');
        int column = startingPoint[1] + 1;

        return Character.toString(row) + column;
    }

    public boolean isValidGuess(String guess) {
        if (guess.length() != 2)
            return false;

        char rowChar = guess.charAt(0);
        int column;
        try {
            column = Integer.parseInt(guess.substring(1));
        } catch (NumberFormatException e) {
            return false;
        }

        int row = rowChar - 'A' + 1;
        return row >= 1 && row <= GRID_SIZE && column >= 1 && column <= GRID_SIZE;
    }
}