package bisht.b.PandemicTracker.PandemicManager;

public interface IWorld {
    void report(String diseaseName, String countryName, String stateName);

    void cured(String diseaseName, String countryName, String stateName);

    void fatal(String diseaseName, String countryName, String stateName);

    String showWorldSummary();

    String showWorldSummaryDiseasesBreakup();

    void inActive(String disease, String countryName, String stateName);
}
