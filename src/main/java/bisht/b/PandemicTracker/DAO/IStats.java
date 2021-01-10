package bisht.b.PandemicTracker.DAO;

public interface IStats {

    String getStats(String name);

    void fatal();

    void inActive();

    void cured();

    void report();
}
