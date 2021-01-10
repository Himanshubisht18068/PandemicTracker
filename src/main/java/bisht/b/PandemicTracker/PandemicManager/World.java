package bisht.b.PandemicTracker.PandemicManager;

public class World implements IWorld {

    private ICountry country;

    public World(ICountry country) {
        this.country = country;
    }

    @Override
    public void report(String diseaseName, String countryName, String stateName) {
        //TODO
    }

    @Override
    public void cured(String diseaseName, String patientID) {
        //TODO
    }

    @Override
    public void fatal(String diseaseName, String patientID) {
        //TODO
    }

    @Override
    public String showWorldSummary() {
        //TODO
        return null;
    }

    @Override
    public String showWorldSummaryDiseasesBreakup() {
        //TODO
        return null;
    }
}
