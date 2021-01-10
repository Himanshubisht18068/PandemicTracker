package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.DataBaseManager.DataBaseManager;
import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;

public class State implements IState{

    private IDataBaseManager dataBaseManager;

    public State(){

        this.dataBaseManager = new DataBaseManager();

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
