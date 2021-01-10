package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.DataBaseManager.DataBaseManager;
import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;

public class Country implements ICountry {

    private IState state;
    private IDataBaseManager dataBaseManager;

    public Country(IState state) {
        this.state = state;
        this.dataBaseManager = new DataBaseManager();
    }

    @Override
    public void report(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.reportCountry(diseaseName, countryName);

        this.state.report(diseaseName, countryName, stateName);

    }

    @Override
    public void cured(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.curedCountry(diseaseName, countryName);

        this.state.cured(diseaseName, countryName, stateName);
    }

    @Override
    public void fatal(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.fatalCountry(diseaseName, countryName);

        this.state.fatal(diseaseName, countryName, stateName);
    }

    @Override
    public void inActive(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.inActiveCountry(diseaseName, countryName);

        this.state.inActive(diseaseName, countryName, stateName);

    }

    @Override
    public String showCountryBreakup(String diseaseName) {
        return this.dataBaseManager.showCountryBreakup(diseaseName);
    }
}
