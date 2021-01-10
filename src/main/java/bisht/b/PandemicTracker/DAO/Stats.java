package bisht.b.PandemicTracker.DAO;

public class Stats implements IStats{

    private int totalCases;
    private int curedCases;
    private int fatalCases;
    private int activeCases;

    public Stats() {
    }

    @Override
    public String getStats(String name) {
        return null;
    }

    @Override
    public void fatal() {
        ++this.fatalCases;
        --this.activeCases;
    }

    @Override
    public void inActive() {
        --this.activeCases;
    }

    @Override
    public void cured() {
        ++this.curedCases;
        --this.activeCases;
    }
}
