package bisht.b.PandemicTracker.DataBaseManager;

public class DataBaseManager implements IDataBaseManager {
    @Override
    public boolean patientExists(String patientID, String diseaseName) {
        return false;
    }

    @Override
    public void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName) {

    }
}
