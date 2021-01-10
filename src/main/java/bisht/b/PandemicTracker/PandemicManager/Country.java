package bisht.b.PandemicTracker.PandemicManager;

public class Country implements ICountry {

    private IState state;

    public Country(IState state) {
        this.state = state;
    }

    @Override
    public String showCountryBreakup(String diseaseName) {
        //TODO
        return null;
    }

    @Override
    public void report(String diseaseName, String countryName, String stateName) {
        //TODO
    }

    @Override
    public void cured(String diseaseName, String countryName, String stateName) {
        //TODO
    }

    @Override
    public void fatal(String disease, String countryName, String stateName) {
        //TODO
    }

    @Override
    public void inActive(String disease, String countryName, String stateName) {
        //TODO
    }
}
