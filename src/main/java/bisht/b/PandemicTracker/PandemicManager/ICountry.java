package bisht.b.PandemicTracker.PandemicManager;

public interface ICountry {
    String showCountryBreakup(String diseaseName);

    void report(String diseaseName, String countryName, String stateName);

    void cured(String diseaseName, String countryName, String stateName);

    void fatal(String disease, String countryName, String stateName);

    void inActive(String disease, String countryName, String stateName);
}
