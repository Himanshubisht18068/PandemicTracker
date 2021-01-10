package bisht.b.PandemicTracker.DataBaseManager;

import bisht.b.PandemicTracker.DAO.RegionInfo;
import bisht.b.PandemicTracker.DataBase.IDataBase;
import bisht.b.PandemicTracker.DataBase.InMemoryDataBase;

import java.util.List;

public class DataBaseManager implements IDataBaseManager {

    private IDataBase inMemory;

    public DataBaseManager() {
        this.inMemory = InMemoryDataBase.getInstance();
    }

    @Override
    public boolean patientExists(String patientID, String diseaseName) {

        return this.inMemory.patientExists(patientID, diseaseName);

    }

    @Override
    public void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName) {

        this.inMemory.savePatientDetails(patientID, diseaseName, countryName, stateName);

    }

    @Override
    public void reportWorld(String diseaseName) {

        this.inMemory.reportWorld(diseaseName);

    }

    @Override
    public void curedWorld(String diseaseName) {

        this.inMemory.curedWorld(diseaseName);

    }

    @Override
    public RegionInfo getPatientDetails(String patientID) {

        return this.inMemory.getPatientDetails(patientID);

    }

    @Override
    public void patientCured(String patientID, String diseaseName) {

        this.inMemory.patientCured(patientID, diseaseName);

    }

    @Override
    public void fatalWorld(String diseaseName) {

        this.inMemory.fatalWorld(diseaseName);

    }

    @Override
    public List<String> getPatientDiseasesList(String patientID) {

        return this.inMemory.getPatientDiseasesList(patientID);
    }

    @Override
    public void inActiveWorld(String diseaseName) {

        this.inMemory.inActiveWorld(diseaseName);

    }

    @Override
    public void deletePatientDetails(String patientID) {

        this.inMemory.deletePatientDetails(patientID);

    }

    @Override
    public String getWorldSummary() {

        return this.inMemory.getWorldSummary();

    }

    @Override
    public String getWorldSummaryDiseasesBreakup() {

        return this.inMemory.getWorldSummaryDiseasesBreakup();

    }

    @Override
    public void reportCountry(String diseaseName, String countryName) {

        this.inMemory.reportCountry(diseaseName, countryName);

    }

    @Override
    public void curedCountry(String diseaseName, String countryName) {

        this.inMemory.curedCountry(diseaseName, countryName);

    }

    @Override
    public void fatalCountry(String diseaseName, String countryName) {

        this.inMemory.fatalCountry(diseaseName, countryName);

    }

    @Override
    public String showCountryBreakup(String diseaseName) {

        return this.inMemory.showCountryBreakup(diseaseName);

    }

    @Override
    public void inActiveCountry(String diseaseName, String countryName) {

        this.inMemory.inActiveCountry(diseaseName, countryName);

    }

    @Override
    public String showStateBreakup(String diseaseName, String countryName) {

        return this.inMemory.showStateBreakup(diseaseName, countryName);

    }

    @Override
    public void reportState(String diseaseName, String countryName, String stateName) {

        this.inMemory.reportState(diseaseName, countryName, stateName);

    }

    @Override
    public void curedState(String diseaseName, String countryName, String stateName) {

        this.inMemory.curedState(diseaseName, countryName, stateName);

    }

    @Override
    public void inActiveState(String diseaseName, String countryName, String stateName) {

        this.inMemory.inActiveState(diseaseName, countryName, stateName);

    }

    @Override
    public void fatalState(String diseaseName, String countryName, String stateName) {

        this.inMemory.fatalState(diseaseName, countryName, stateName);

    }
}
