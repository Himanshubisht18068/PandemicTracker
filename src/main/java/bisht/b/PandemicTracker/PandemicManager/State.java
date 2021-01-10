package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class State implements IState {

    private final IDataBaseManager dataBaseManager;

    @Autowired
    public State(IDataBaseManager dataBaseManager) {

        this.dataBaseManager = dataBaseManager;

    }

    @Override
    public String showStateBreakup(String diseaseName, String countryName) {

        return this.dataBaseManager.showStateBreakup(diseaseName, countryName);
    }

    @Override
    public void report(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.reportState(diseaseName, countryName, stateName);

    }

    @Override
    public void cured(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.curedState(diseaseName, countryName, stateName);

    }

    @Override
    public void fatal(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.fatalState(diseaseName, countryName, stateName);

    }

    @Override
    public void inActive(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.inActiveState(diseaseName, countryName, stateName);

    }
}
