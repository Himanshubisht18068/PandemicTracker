package bisht.b.PandemicTracker.PandemicManager;

public class World implements IWorld {

    private ICountry country;

    public World(ICountry country) {
        this.country = country;
    }
}
