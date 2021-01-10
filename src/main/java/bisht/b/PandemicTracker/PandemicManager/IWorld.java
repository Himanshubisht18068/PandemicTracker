package bisht.b.PandemicTracker.PandemicManager;

public interface IWorld {
    void report(String diseaseName, String countryName, String stateName);

    void cured(String diseaseName, String patientID);

    void fatal(String diseaseName, String patientID);

    String showWorldSummary();

    String showWorldSummaryDiseasesBreakup();
}
