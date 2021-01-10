package bisht.b.PandemicTracker.DataBase;

import bisht.b.PandemicTracker.DAO.RegionInfo;

import java.util.List;

public interface IDataBase {
    void fatalState(String diseaseName, String countryName, String stateName);

    void inActiveState(String diseaseName, String countryName, String stateName);

    void curedState(String diseaseName, String countryName, String stateName);

    void reportState(String diseaseName, String countryName, String stateName);

    String showStateBreakup(String diseaseName, String countryName);

    void inActiveCountry(String diseaseName);

    String showCountryBreakup(String diseaseName);

    void fatalCountry(String diseaseName);

    void curedCountry(String diseaseName);

    void reportCountry(String diseaseName);

    String getWorldSummaryDiseasesBreakup();

    String getWorldSummary();

    void deletePatientDetails(String patientID);

    void inActiveWorld(String diseaseName);

    List<String> getPatientDiseasesList(String patientID);

    void fatalWorld(String diseaseName);

    void patientCured(String patientID, String diseaseName);

    RegionInfo getPatientDetails(String patientID);

    void curedWorld(String diseaseName);

    void reportWorld(String diseaseName);

    void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName);

    boolean patientExists(String patientID, String diseaseName);
}
