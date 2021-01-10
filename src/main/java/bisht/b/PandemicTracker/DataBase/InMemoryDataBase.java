package bisht.b.PandemicTracker.DataBase;

import bisht.b.PandemicTracker.DAO.IRegionInfo;
import bisht.b.PandemicTracker.DAO.IStats;
import bisht.b.PandemicTracker.DAO.RegionInfo;
import bisht.b.PandemicTracker.DAO.Stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDataBase implements IDataBase {

    static InMemoryDataBase instance = null;

    private IStats worldStats;
    private Map<String, IStats> mTableWorldDiseaseStats;
    private Map<String, IStats> mTableCountryDiseaseStats;
    private Map<String, IStats> mTableStateDiseaseStats;

    private Map<String, IRegionInfo> mPatientAddress;
    private Map<String, List<String>> mPatientDiseaseList;


    private InMemoryDataBase() {

        this.worldStats = new Stats();
        this.mTableWorldDiseaseStats = new HashMap<>();
        this.mTableCountryDiseaseStats = new HashMap<>();
        this.mTableStateDiseaseStats = new HashMap<>();

        this.mPatientAddress = new HashMap<>();
        this.mPatientDiseaseList = new HashMap<>();

    }

    public static InMemoryDataBase getInstance() {

        if (instance == null) {
            instance = new InMemoryDataBase();
        }
        return instance;
    }

    @Override
    public void fatalState(String diseaseName, String countryName, String stateName) {

        String key = String.join("__", diseaseName, countryName, stateName);

        this.mTableStateDiseaseStats.get(key).fatal();

    }

    @Override
    public void inActiveState(String diseaseName, String countryName, String stateName) {

        String key = String.join("__", diseaseName, countryName, stateName);

        this.mTableStateDiseaseStats.get(key).inActive();

    }

    @Override
    public void curedState(String diseaseName, String countryName, String stateName) {

        String key = String.join("__", diseaseName, countryName, stateName);

        this.mTableStateDiseaseStats.get(key).cured();

    }

    @Override
    public void reportState(String diseaseName, String countryName, String stateName) {

        String key = String.join("__", diseaseName, countryName, stateName);

        if (!this.mTableStateDiseaseStats.containsKey(key)) {
            this.mTableStateDiseaseStats.put(key, new Stats());
        }

        this.mTableStateDiseaseStats.get(key).inActive();

    }

    @Override
    public String showStateBreakup(String diseaseName, String countryName) {

        StringBuilder output = new StringBuilder();

        for(Map.Entry<String, IStats> entrySet: this.mTableStateDiseaseStats.entrySet()){

            String[] str = entrySet.getKey().split("__");

            if(str[0].equals(diseaseName) && str[1].equals(countryName)){

                output.append(entrySet.getValue().getStats(str[2]));

            }

        }

        return output.toString();
    }

    @Override
    public void inActiveCountry(String diseaseName, String countryName) {



    }

    @Override
    public String showCountryBreakup(String diseaseName) {
        return null;
    }

    @Override
    public void fatalCountry(String diseaseName, String countryName) {

    }

    @Override
    public void curedCountry(String diseaseName, String countryName) {

    }

    @Override
    public void reportCountry(String diseaseName, String countryName) {

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
