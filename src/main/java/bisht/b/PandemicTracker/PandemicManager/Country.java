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
}
