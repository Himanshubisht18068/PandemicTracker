package bisht.b.PandemicTracker.DataBaseManager;

import bisht.b.PandemicTracker.DAO.RegionInfo;

import java.util.List;

public interface IDataBaseManager {
    boolean patientExists(String patientID, String diseaseName);

    void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName);

    void reportWorld(String diseaseName);

    void curedWorld(String diseaseName);

    RegionInfo getPatientDetails(String patientID);

    void patientCured(String patientID, String diseaseName);

    void fatalWorld(String diseaseName);

    List<String> getPatientDiseasesList(String patientID);

    void inActiveWorld(String disease);

    void deletePatientDetails(String patientID);

    String getWorldSummary();

    String getWorldSummaryDiseasesBreakup();
}
