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
}
