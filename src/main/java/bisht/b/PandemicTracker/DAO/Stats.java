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

        return String.format("\n%s:\n\t1. TotalCases: %s\n\t2. CuredCases: %s\n\t3. FatalCases: %s\n\t4. ActiveCases: %s\n\n", name, this.totalCases, this.curedCases, this.fatalCases, this.activeCases);

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

    @Override
    public void report() {
        ++this.totalCases;
        ++this.activeCases;
    }
}
