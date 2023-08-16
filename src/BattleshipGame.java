import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipGame {
    private ArrayList<Battleship> battleships;
    private int totalGuesses;

    public BattleshipGame() {
        battleships = new ArrayList<>();
        totalGuesses = 0;
    }

    public void playGame() {
        GameHelper helper = new GameHelper();
        createBattleships();

        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;

        while (!isGameOver) {
            String userGuess = helper.getUserInput("Enter a guess: ");
            totalGuesses++;

            String result = checkUserGuess(userGuess);
            System.out.println(result);

            if (battleships.isEmpty()) {
                isGameOver = true;
                System.out.println("Congratulations! You sank all the battleships.");
                System.out.println("Total number of guesses: " + totalGuesses);
            }
        }
    }

    private void createBattleships() {
        int numOfBattleships = 3;
        for (int i = 0; i < numOfBattleships; i++) {
            Battleship battleship = new Battleship();
            battleships.add(battleship);
        }
    }

    private String checkUserGuess(String guess) {
        GameHelper helper = new GameHelper();
        if (!helper.isValidGuess(guess)) {
            return "Invalid guess. Please enter a valid guess within the grid range.";
        }

        String result = "Miss";

        for (int i = 0; i < battleships.size(); i++) {
            Battleship battleship = battleships.get(i);
            String checkResult = battleship.checkGuess(guess);

            if (checkResult.equals("Hit")) {
                result = "Hit";
                break;
            } else if (checkResult.equals("Sunk")) {
                result = "You sank a battleship!";
                battleships.remove(i);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.playGame();
    }
}