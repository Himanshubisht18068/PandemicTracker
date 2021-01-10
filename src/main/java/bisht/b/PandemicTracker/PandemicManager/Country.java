package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Country implements ICountry {

    private final IState state;
    private final IDataBaseManager dataBaseManager;

    @Autowired
    public Country(IState state, IDataBaseManager dataBaseManager) {
        this.state = state;
        this.dataBaseManager = dataBaseManager;
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
