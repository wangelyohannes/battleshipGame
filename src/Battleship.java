public class Battleship {
    private String name;
    private String location;

    public Battleship() {
        name = "Battleship";
        location = generateLocation();
    }

    public String checkGuess(String guess) {
        if (guess.equals(location)) {
            return "Sunk";
        } else if (location.contains(guess)) {
            return "Hit";
        } else {
            return "Miss";
        }
    }

    private String generateLocation() {
        GameHelper helper = new GameHelper();
        return helper.generateLocation();
    }
}
