package bisht.b.PandemicTracker.PandemicManager;

import bisht.b.PandemicTracker.DAO.RegionInfo;
import bisht.b.PandemicTracker.DataBaseManager.DataBaseManager;
import bisht.b.PandemicTracker.DataBaseManager.IDataBaseManager;

import java.util.List;

public class World implements IWorld {

    private ICountry country;
    private IDataBaseManager dataBaseManager;

    public World(ICountry country) {
        this.country = country;
        this.dataBaseManager = new DataBaseManager();
    }

    @Override
    public void report(String diseaseName, String countryName, String stateName) {

        this.dataBaseManager.reportWorld(diseaseName);
        this.country.report(diseaseName, countryName, stateName);

    }

    @Override
    public void cured(String diseaseName, String patientID) {

        this.dataBaseManager.curedWorld(diseaseName);

        RegionInfo region = this.dataBaseManager.getPatientDetails(patientID);
        this.country.cured(diseaseName, region.getCountryName(), region.getStateName());

        // Patient is cured, so update his diseases list
        this.dataBaseManager.patientCured(patientID, diseaseName);

    }

    @Override
    public void fatal(String diseaseName, String patientID) {


        RegionInfo region = this.dataBaseManager.getPatientDetails(patientID);

        List<String> diseases = this.dataBaseManager.getPatientDiseasesList(patientID);
        for(String disease: diseases){

            if(disease.equals(diseaseName)){

                this.dataBaseManager.fatalWorld(diseaseName);

                this.country.fatal(disease, region.getCountryName(), region.getStateName());

            }
            else{

                this.dataBaseManager.inActiveWorld(disease);

                this.country.inActive(disease, region.getCountryName(),region.getStateName());

            }

        }

        this.dataBaseManager.deletePatientDetails(patientID);
    }

    @Override
    public String showWorldSummary() {
        //TODO
        return null;
    }

    @Override
    public String showWorldSummaryDiseasesBreakup() {
        //TODO
        return null;
    }
}
