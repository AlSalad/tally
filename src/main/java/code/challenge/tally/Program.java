package code.challenge.tally;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**5 Friends (let's call them a, b, c, d and e) are playing a game and need to keep track of the scores. Each time
 * someone scores a point, the letter of his name is typed in lowercase. If someone loses a point, the letter of his
 * name is typed in uppercase. Give the resulting score from highest to lowest.
 */

public class Program {

    public static void main(String[] args) {
        List<Score> finalScoreboard = extractScore("dbbaCEDbdAacCEAadcB");
        sortScoreBoard(finalScoreboard);
        outScoreBoard(finalScoreboard);
    }

    private static List<Score> extractScore(String input){
        char[] inputCharArray = input.toCharArray();
        List<Score> Scoreboard = new ArrayList<Score>();

        for (char inputChar : inputCharArray){
            if(Character.isLowerCase(inputChar)){
                if (checkIfInScoreboard(inputChar, Scoreboard))
                    modifyScore(inputChar, true, Scoreboard);
                else
                    addToScoreboard(inputChar, true, Scoreboard);
            }
            if(Character.isUpperCase(inputChar)){
                if (checkIfInScoreboard(inputChar, Scoreboard))
                    modifyScore(inputChar, false, Scoreboard);
                else
                    addToScoreboard(inputChar, false, Scoreboard);
            }
        }
        return Scoreboard;
    }

    // Check if player is already in Scoreboard
    private static boolean checkIfInScoreboard(char playerChar, List<Score> Scoreboard){
        char playerCharLowerCase = Character.toLowerCase(playerChar);

        for (Score score : Scoreboard)
            if (score.getPlayer() == playerCharLowerCase)
                return true;
        return false;
    }

    //
    private static void addToScoreboard(char playerChar, boolean lowerCase, List<Score> Scoreboard){
        int points = lowerCase ? 1 : -1;

        Score scoreToAdd = new Score(Character.toLowerCase(playerChar), points);
        Scoreboard.add(scoreToAdd);
    }

    private static void modifyScore(char playerChar, boolean lowerCase, List<Score> Scoreboard){
        char playerCharLowerCase = Character.toLowerCase(playerChar);
        int currentPoints = 0;

        for (Score score : Scoreboard)
            if (score.getPlayer() == playerCharLowerCase){
                currentPoints = score.getPoints();
                int newPoints = lowerCase ? currentPoints + 1 : currentPoints - 1;
                score.setPoints(newPoints);
            }
    }

    private static void sortScoreBoard(List<Score> Scoreboard){
        //TODO
    }

    private static void outScoreBoard(List<Score> Scoreboard){
        for (Score score : Scoreboard){
            System.out.println(score.getPlayer() + ":" + score.getPoints() + ",");
        }
    }
}
