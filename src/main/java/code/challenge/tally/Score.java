package code.challenge.tally;

public class Score {

    private final char player;
    private int points;

    public Score(char player, int points) {
        this.player = player;
        this.points = points;
    }

    public char getPlayer() {
        return player;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int newPoints) {
        points = newPoints;
    }
}
