package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.CustomExceptions.PatientExistsWithThisDisease;
import bisht.b.PandemicTracker.CustomExceptions.PatientNotFound;
import bisht.b.PandemicTracker.DAO.RegionInfo;
import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PandemicManager {

    private final IWorld world;
    private final ICountry country;
    private final IState state;

    private final IDataBaseManager dataBaseManager;

    @Autowired
    public PandemicManager(IWorld world, ICountry country, IState state, IDataBaseManager dataBaseManager) {
        this.world = world;
        this.country = country;
        this.state = state;
        this.dataBaseManager = dataBaseManager;
    }

    public void report(String diseaseName, String patientID, String countryName, String stateName, String cityName) throws PatientExistsWithThisDisease {

        this.savePatientDetails(patientID, diseaseName, countryName, stateName);

        this.world.report(diseaseName, countryName, stateName);


    }

    private void savePatientDetails(String patientID, String diseaseName, String countryName, String stateName) throws PatientExistsWithThisDisease {

        if (this.dataBaseManager.patientExists(patientID, diseaseName)) {
            throw new PatientExistsWithThisDisease(String.format("\nPatient %s with disease %s is all ready reported.\n", patientID, diseaseName));
        }

        this.dataBaseManager.savePatientDetails(patientID, diseaseName, countryName, stateName);

    }

    public void cured(String diseaseName, String patientID) throws PatientNotFound {

        if (!this.dataBaseManager.patientExists(patientID, diseaseName)) {
            throw new PatientNotFound(String.format("\nPatient %s with disease %s does not Exists.\n", patientID, diseaseName));
        }

        RegionInfo region = this.dataBaseManager.getPatientDetails(patientID);

        this.world.cured(diseaseName, region.getCountryName(), region.getStateName());

        // Patient is cured, so update his diseases list
        this.dataBaseManager.patientCured(patientID, diseaseName);

    }

    public void fatal(String diseaseName, String patientID) {

        if (!this.dataBaseManager.patientExists(patientID, diseaseName)) {
            throw new PatientNotFound(String.format("\nPatient %s with disease %s does not Exists.\n", patientID, diseaseName));
        }


        RegionInfo region = this.dataBaseManager.getPatientDetails(patientID);

        List<String> diseases = this.dataBaseManager.getPatientDiseasesList(patientID);
        for (String disease : diseases) {

            if (disease.equals(diseaseName)) {

                this.world.fatal(disease, region.getCountryName(), region.getStateName());

            } else {

                this.world.inActive(disease, region.getCountryName(), region.getStateName());

            }

        }

        //Patient is dead, removed all this details
        this.dataBaseManager.deletePatientDetails(patientID);

    }

    public String showWorldSummary() {

        System.out.println("showWorldSummary() => ");

        return this.world.showWorldSummary();

    }

    public String showWorldSummaryDiseasesBreakup() {

        System.out.println("showWorldSummaryDiseasesBreakup() => ");

        return this.world.showWorldSummaryDiseasesBreakup();

    }

    public String showCountryBreakup(String diseaseName) {

        System.out.printf("showCountryBreakup(%s) => %n", diseaseName);

        return this.country.showCountryBreakup(diseaseName);

    }

    public String showStateBreakup(String diseaseName, String countryName) {

        System.out.printf("showStateBreakup(%s, %s) => %n", diseaseName, countryName);

        return this.state.showStateBreakup(diseaseName, countryName);

    }


}
