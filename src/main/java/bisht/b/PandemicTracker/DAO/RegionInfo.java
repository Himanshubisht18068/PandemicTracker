package bisht.b.PandemicTracker.DAO;

public class RegionInfo {

    private final String countryName;
    private final String stateName;

    public RegionInfo(String countryName, String stateName) {
        this.countryName = countryName;
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getStateName() {
        return stateName;
    }
}
