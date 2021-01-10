package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.DataBaseManager.DataBaseManager;
import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;

public class World implements IWorld {

    private ICountry country;
    private IDataBaseManager dataBaseManager;

    public World(ICountry country) {
        this.country = country;
        this.dataBaseManager = new DataBaseManager();
    }

    @Override
    public void report(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.reportWorld(diseaseName);
        this.country.report(diseaseName, countryName, stateName);

    }

    @Override
    public void cured(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.curedWorld(diseaseName);

        this.country.fatal(diseaseName, countryName, stateName);

    }

    @Override
    public void fatal(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.fatalWorld(diseaseName);

        this.country.fatal(diseaseName, countryName, stateName);


    }

    @Override
    public String showWorldSummary() {

        return this.dataBaseManager.getWorldSummary();

    }

    @Override
    public String showWorldSummaryDiseasesBreakup() {

        return this.dataBaseManager.getWorldSummaryDiseasesBreakup();

    }

    @Override
    public void inActive(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.inActiveWorld(diseaseName);

        this.country.inActive(diseaseName, countryName, stateName);

    }
}
