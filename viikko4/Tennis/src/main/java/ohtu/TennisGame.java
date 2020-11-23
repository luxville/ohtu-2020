package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String[] pelaajat = {"player1", "player2"};
    private static final String[] pisteidenNimet = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String tasatilanteenPaate = "-All";
    private static final String tasatilanneJatkopalloilla = "Deuce";
    private static final String etuJatkopalloilla = "Advantage ";
    private static final String voittaja = "Win for ";

    public TennisGame(String player1Name, String player2Name) {
        this.pelaajat[0] = player1Name;
        this.pelaajat[1] = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(pelaajat[0])) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    private String tasan(int voitetutPisteet) {
        if (voitetutPisteet >= pisteidenNimet.length) {
            return "Deuce";
        }
        return pisteidenNimet[voitetutPisteet] + tasatilanteenPaate;
    }

    private String jatkopallot(int pisteEro) {
        String johdossa;
        if (pisteEro > 0) {
            johdossa = pelaajat[0];
        } else {
            johdossa = pelaajat[1];
        }
        if (Math.abs(pisteEro) == 1) {
            return etuJatkopalloilla + johdossa;
        } else {
            return voittaja + johdossa;
        }
    }

    private String pisteetEnnenJatkopalloja(int voitetutPallot) {
        return pisteidenNimet[voitetutPallot];
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return tasan(player1Score);
        } else if (Math.max(player1Score, player2Score) >= 4) {
            return jatkopallot(player1Score - player2Score);
        } else {
            return pisteetEnnenJatkopalloja(player1Score) + "-" + pisteetEnnenJatkopalloja(player2Score);
        }
    }
}
