package bisht.b.PandemicTracker.PandemicManager;

public interface IState {
    String ShowStateBreakup(String diseaseName, String countryName);

    void report(String diseaseName, String countryName, String stateName);

    void cured(String diseaseName, String countryName, String stateName);

    void fatal(String diseaseName, String countryName, String stateName);

    void inActive(String diseaseName, String countryName, String stateName);
}
