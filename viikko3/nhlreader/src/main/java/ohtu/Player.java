
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public Player(String name, String team, int goals, int assists, String nationality) {
        this.name = name;
        this.team = team;
        this.goals = goals;
        this.assists = assists;
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getAssists() {
        return assists;
    }

    public int getPoints() {
        return goals + assists;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        int empty1 = 20 - name.length();
        int empty2 = 5 - team.length();
        String nEmpty = "";
        String tRest = "";
        int n = 0;
        while(n < Math.max(empty1, empty2)) {
            if (n < empty1) {
                nEmpty += " ";
            }
            if (n < empty2) {
                tRest += " ";
            }
            n++;
        }
        if (goals < 10) {
            tRest += " ";
        }
        tRest += goals + " + ";
        if (assists < 10) {
            tRest += " ";
        }
        tRest += assists + " = ";
        if (goals + assists < 10) {
            tRest += " ";
        }
        tRest += (goals + assists);
        
        return name + nEmpty + tRest;
    }
      
    @Override
    public int compareTo(Player player) {
        if (this.getPoints() - player.getPoints() == 0) {
            return this.getGoals() - player.getGoals();
        }
        return this.getPoints() - player.getPoints();
    }
}
