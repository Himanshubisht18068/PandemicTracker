package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.CustomExceptions.PatientExistsWithThisDisease;
import bisht.b.PandemicTracker.DataBaseManager.DataBaseManager;
import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;

public class PandemicManager {

    private IWorld world;
    private ICountry country;
    private IState state;

    private IDataBaseManager dataBaseManager;


    public PandemicManager() {
        this.state = new State();
        this.country = new Country(this.state);
        this.world = new World(this.country);

        this.dataBaseManager = new DataBaseManager();
    }

    public void report(String diseaseName, String patientID, String countryName, String stateName, String cityName) throws PatientExistsWithThisDisease {

        this.savePatientDetails(patientID, diseaseName, countryName, stateName);

        this.world.report(diseaseName, countryName, stateName);


    }

    private void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName) throws PatientExistsWithThisDisease {

        if (this.dataBaseManager.patientExists(patientID, diseaseName)){
            throw new PatientExistsWithThisDisease(String.format("\nPatient %s with disease %s is all ready reported.\n", patientID, diseaseName));
        }

        this.dataBaseManager.savePatientDetails(patientID, diseaseName, countryName, stateName);

    }

    public void cured(String diseaseName, String patientID) {

    }

    public void fatal(String diseaseName, String patientID) {

    }

    public String showWorldSummary() {

        return null;

    }

    public String showWorldSummaryDiseasesBreakup() {

        return null;

    }

    public String showCountryBreakup(String diseaseName) {

        return null;

    }

    public String ShowStateBreakup(String diseaseName, String countryName) {

        return null;

    }


}
