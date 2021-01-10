package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class World implements IWorld {

    private final ICountry country;
    private final IDataBaseManager dataBaseManager;


    @Autowired
    public World(ICountry country, IDataBaseManager dataBaseManager) {
        this.country = country;
        this.dataBaseManager = dataBaseManager;
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
