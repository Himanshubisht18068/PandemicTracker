package bisht.b.PandemicTracker.DataBaseManager;

import bisht.b.PandemicTracker.DAO.RegionInfo;

import java.util.List;

public class DataBaseManager implements IDataBaseManager {
    @Override
    public boolean patientExists(String patientID, String diseaseName) {
        return false;
    }

    @Override
    public void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName) {

    }

    @Override
    public void reportWorld(String diseaseName) {
        //TODO
    }

    @Override
    public void curedWorld(String diseaseName) {
        //TODO
    }

    @Override
    public RegionInfo getPatientDetails(String patientID) {
        //TODO
        return null;
    }

    @Override
    public void patientCured(String patientID, String diseaseName) {
        //TODO
        // remove disease from patient
    }

    @Override
    public void fatalWorld(String diseaseName) {
        //TODO
    }

    @Override
    public List<String> getPatientDiseasesList(String patientID) {
        //TODO
        return null;
    }

    @Override
    public void inActiveWorld(String disease) {
        //TODO
    }

    @Override
    public void deletePatientDetails(String patientID) {
        //TODO
    }
}
