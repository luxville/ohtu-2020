package statistics.matcher;

import statistics.Player;

public class All implements Matcher {
    private Matcher[] matchers;

    public All() {
        this.matchers = matchers;
    }

    public boolean matches(Player p) {
        return true;
    }
    
    
}
