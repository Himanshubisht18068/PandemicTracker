package bisht.b.PandemicTracker.PandemicManager;

public class PandemicManager {

    private IWorld world;
    private ICountry country;
    private IState state;

    public PandemicManager() {
        this.state = new State();
        this.country = new Country(this.state);
        this.world = new World(this.country);
    }

    public void report(String diseaseName, String patientID, String countryName, String stateName, String cityName) {

    }

    public void cured(String diseaseName, String patientID) {

    }

    public void fatal(String diseaseName, String patientID) {

    }

    public String showWorldSummary() {

        return null;

    }

    public String showWorldSummaryDiseasesBreakup() {

        return null;

    }

    public String showCountryBreakup(String diseaseName) {

        return null;

    }

    public String ShowStateBreakup(String diseaseName, String countryName) {

        return null;

    }


}
