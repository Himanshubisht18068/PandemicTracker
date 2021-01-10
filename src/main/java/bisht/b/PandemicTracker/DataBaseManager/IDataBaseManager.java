package bisht.b.PandemicTracker.DataBaseManager;

public interface IDataBaseManager {
    boolean patientExists(String patientID, String diseaseName);

    void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName);
}
