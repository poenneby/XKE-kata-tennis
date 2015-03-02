package tennis;

public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    class Player {
        final String name;
        int score;

        public Player(String playerName) {
            this.name = playerName;
            this.score = 0;
        }

        public void incrementScore() {
            this.score++;
        }
    }

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.name.equals(playerName))
            player1.incrementScore();
        else
            player2.incrementScore();
    }

    public String getScore() {
        if (player1.score == player2.score) {
            return messageForEqual(player1.score);
        } else if (player1.score >= 4 || player2.score >= 4) {
            return messageForDifference(player1.score - player2.score);
        } else {
            return messageFor(player1.score) + "-" + messageFor(player2.score);
        }
    }

    private String messageForDifference(int difference) {
        if (difference == 1) return "Advantage player1";
        else if (difference == -1) return "Advantage player2";
        else if (difference >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String messageFor(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    private String messageForEqual(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
