class Score {

    private final char player;
    private int points;

    Score(char player, int points) {
        this.player = player;
        this.points = points;
    }

    char getPlayer() {
        return player;
    }

    int getPoints() {
        return points;
    }

    void setPoints(int newPoints) {
        points = newPoints;
    }
}
