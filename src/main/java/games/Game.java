package games;

public class Game {

    private String firstCountry;
    private String secondCountry;
    private int firstCountryScore;
    private int secondCountryScore;

    public Game(String firstCountry, String secondCountry, int firstCountryScore, int secondCountryScore) {
        this.firstCountry = firstCountry;
        this.secondCountry = secondCountry;
        this.firstCountryScore = firstCountryScore;
        this.secondCountryScore = secondCountryScore;
    }

    public String getFirstCountry() {
        return firstCountry;
    }

    public String getSecondCountry() {
        return secondCountry;
    }

    public int getFirstCountryScore() {
        return firstCountryScore;
    }

    public int getSecondCountryScore() {
        return secondCountryScore;
    }

    public String winner() {
        if (firstCountryScore == secondCountryScore) {
            return "Draw";
        }
        return firstCountryScore > secondCountryScore ? firstCountry : secondCountry;
    }

    public static Game createGameFromLine(String line) {
        String[] lineArr = line.split(";");
        return new Game(lineArr[0], lineArr[1], Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]));
    }
}
