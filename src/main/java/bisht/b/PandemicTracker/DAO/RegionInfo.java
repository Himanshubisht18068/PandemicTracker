package bisht.b.PandemicTracker.DAO;

public class RegionInfo implements IRegionInfo{

    private String countryName;
    private String stateName;

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
