package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher apu = this.matcher;
        this.matcher = new All();
        return apu;
    }
    
    public QueryBuilder playsIn(String team) {
        this.rajaa(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder rajaa(Matcher matcher) {
        this.matcher = new And(this.matcher, matcher);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.rajaa(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.rajaa(new HasFewerThan(value, category));
        return this;
    }
}
