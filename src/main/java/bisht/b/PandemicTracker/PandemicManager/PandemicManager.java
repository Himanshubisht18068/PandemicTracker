package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.CustomExceptions.PatientExistsWithThisDisease;
import bisht.b.PandemicTracker.CustomExceptions.PatientNotFound;
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

    public void cured(String diseaseName, String patientID) throws PatientNotFound {

        if(!this.dataBaseManager.patientExists(patientID, diseaseName)){
            throw new PatientNotFound(String.format("\nPatient %s with disease %s does not Exists.\n", patientID, diseaseName));
        }

        this.world.cured(diseaseName, patientID);

    }

    public void fatal(String diseaseName, String patientID) {

        if(!this.dataBaseManager.patientExists(patientID, diseaseName)){
            throw new PatientNotFound(String.format("\nPatient %s with disease %s does not Exists.\n", patientID, diseaseName));
        }

        this.world.fatal(diseaseName, patientID);

    }

    public String showWorldSummary() {

        return this.world.showWorldSummary();

    }

    public String showWorldSummaryDiseasesBreakup() {

        return this.world.showWorldSummaryDiseasesBreakup();

    }

    public String showCountryBreakup(String diseaseName) {

        return this.country.showCountryBreakup(diseaseName);

    }

    public String showStateBreakup(String diseaseName, String countryName) {

        return this.state.showStateBreakup(diseaseName, countryName);

    }


}
