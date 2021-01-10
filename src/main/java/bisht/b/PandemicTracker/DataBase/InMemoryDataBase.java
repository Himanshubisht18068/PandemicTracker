package bisht.b.PandemicTracker.DataBase;

import bisht.b.PandemicTracker.DAO.RegionInfo;

import java.util.List;

public class InMemoryDataBase implements IDataBase{

    static InMemoryDataBase instance = null;

    private InMemoryDataBase(){

    }

    public static InMemoryDataBase getInstance(){

        if(instance == null){
            instance = new InMemoryDataBase();
        }
        return  instance;
    }

    @Override
    public void fatalState(String diseaseName, String countryName, String stateName) {

    }

    @Override
    public void inActiveState(String diseaseName, String countryName, String stateName) {

    }

    @Override
    public void curedState(String diseaseName, String countryName, String stateName) {

    }

    @Override
    public void reportState(String diseaseName, String countryName, String stateName) {

    }

    @Override
    public String showStateBreakup(String diseaseName, String countryName) {
        return null;
    }

    @Override
    public void inActiveCountry(String diseaseName) {

    }

    @Override
    public String showCountryBreakup(String diseaseName) {
        return null;
    }

    @Override
    public void fatalCountry(String diseaseName) {

    }

    @Override
    public void curedCountry(String diseaseName) {

    }

    @Override
    public void reportCountry(String diseaseName) {

    }

    @Override
    public String getWorldSummaryDiseasesBreakup() {
        return null;
    }

    @Override
    public String getWorldSummary() {
        return null;
    }

    @Override
    public void deletePatientDetails(String patientID) {

    }

    @Override
    public void inActiveWorld(String diseaseName) {

    }

    @Override
    public List<String> getPatientDiseasesList(String patientID) {
        return null;
    }

    @Override
    public void fatalWorld(String diseaseName) {

    }

    @Override
    public void patientCured(String patientID, String diseaseName) {

    }

    @Override
    public RegionInfo getPatientDetails(String patientID) {
        return null;
    }

    @Override
    public void curedWorld(String diseaseName) {

    }

    @Override
    public void reportWorld(String diseaseName) {

    }

    @Override
    public void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName) {

    }

    @Override
    public boolean patientExists(String patientID, String diseaseName) {
        return false;
    }
}
