package bisht.b.PandemicTracker.DataBase;

import bisht.b.PandemicTracker.DAO.IStats;
import bisht.b.PandemicTracker.DAO.RegionInfo;
import bisht.b.PandemicTracker.DAO.Stats;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InMemoryDataBase implements IDataBase {

    private final IStats worldStats;
    private final Map<String, IStats> mTableWorldDiseaseStats;
    private final Map<String, IStats> mTableCountryDiseaseStats;
    private final Map<String, IStats> mTableStateDiseaseStats;

    private final Map<String, RegionInfo> mPatientAddress;
    private final Map<String, List<String>> mPatientDiseaseList;


    public InMemoryDataBase() {

        this.worldStats = new Stats();
        this.mTableWorldDiseaseStats = new HashMap<>();
        this.mTableCountryDiseaseStats = new HashMap<>();
        this.mTableStateDiseaseStats = new HashMap<>();

        this.mPatientAddress = new HashMap<>();
        this.mPatientDiseaseList = new HashMap<>();

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

        this.mTableStateDiseaseStats.get(key).report();

    }

    @Override
    public String showStateBreakup(String diseaseName, String countryName) {

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, IStats> entrySet : this.mTableStateDiseaseStats.entrySet()) {

            String[] str = entrySet.getKey().split("__");

            if (str[0].equals(diseaseName) && str[1].equals(countryName)) {

                output.append(entrySet.getValue().getStats(str[2]));

            }

        }

        return output.toString();
    }

    @Override
    public void inActiveCountry(String diseaseName, String countryName) {

        String key = String.join("__", diseaseName, countryName);

        this.mTableCountryDiseaseStats.get(key).inActive();

    }

    @Override
    public String showCountryBreakup(String diseaseName) {

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, IStats> entrySet : this.mTableCountryDiseaseStats.entrySet()) {

            String[] str = entrySet.getKey().split("__");

            if (str[0].equals(diseaseName)) {

                output.append(entrySet.getValue().getStats(str[1]));

            }

        }

        return output.toString();

    }

    @Override
    public void fatalCountry(String diseaseName, String countryName) {

        String key = String.join("__", diseaseName, countryName);

        this.mTableCountryDiseaseStats.get(key).fatal();

    }

    @Override
    public void curedCountry(String diseaseName, String countryName) {

        String key = String.join("__", diseaseName, countryName);

        this.mTableCountryDiseaseStats.get(key).cured();

    }

    @Override
    public void reportCountry(String diseaseName, String countryName) {

        String key = String.join("__", diseaseName, countryName);

        if (!this.mTableCountryDiseaseStats.containsKey(key)) {
            this.mTableCountryDiseaseStats.put(key, new Stats());
        }

        this.mTableCountryDiseaseStats.get(key).report();

    }

    @Override
    public String getWorldSummaryDiseasesBreakup() {

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, IStats> entrySet : this.mTableWorldDiseaseStats.entrySet()) {

            output.append(entrySet.getValue().getStats(entrySet.getKey()));

        }

        return output.toString();

    }

    @Override
    public String getWorldSummary() {

        return this.worldStats.getStats("OverAll");

    }


    @Override
    public void inActiveWorld(String diseaseName) {

        this.worldStats.inActive();

        this.mTableWorldDiseaseStats.get(diseaseName).inActive();


    }

    @Override
    public void fatalWorld(String diseaseName) {

        this.worldStats.fatal();

        this.mTableWorldDiseaseStats.get(diseaseName).fatal();

    }

    @Override
    public void curedWorld(String diseaseName) {

        this.worldStats.cured();

        this.mTableWorldDiseaseStats.get(diseaseName).cured();

    }

    @Override
    public void reportWorld(String diseaseName) {

        this.worldStats.report();

        if (!this.mTableWorldDiseaseStats.containsKey(diseaseName)) {
            this.mTableWorldDiseaseStats.put(diseaseName, new Stats());
        }

        this.mTableWorldDiseaseStats.get(diseaseName).report();

    }

    @Override
    public void deletePatientDetails(String patientID) {

        this.mPatientDiseaseList.remove(patientID);

        this.mPatientAddress.remove(patientID);

    }

    @Override
    public List<String> getPatientDiseasesList(String patientID) {

        return this.mPatientDiseaseList.get(patientID);

    }

    @Override
    public void patientCured(String patientID, String diseaseName) {

        List<String> diseases = this.mPatientDiseaseList.get(patientID);

        diseases.remove(diseaseName);

        if (0 == diseases.size()){

            this.mPatientDiseaseList.remove(patientID);

            this.mPatientAddress.remove(patientID);

        }

    }

    @Override
    public RegionInfo getPatientDetails(String patientID) {

        return this.mPatientAddress.get(patientID);

    }

    @Override
    public void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName) {

        this.mPatientAddress.put(patientID, new RegionInfo(countryName, stateName));

        if (!this.mPatientDiseaseList.containsKey(patientID)) {

            this.mPatientDiseaseList.put(patientID, new LinkedList<>());

        }

        this.mPatientDiseaseList.get(patientID).add(diseaseName);

    }

    @Override
    public boolean patientExists(String patientID, String diseaseName) {

        if (!this.mPatientDiseaseList.containsKey(patientID)) {

            return false;

        }

        return this.mPatientDiseaseList.get(patientID).contains(diseaseName);

    }
}
