package bisht.b.PandemicTracker;

import bisht.b.PandemicTracker.CustomExceptions.PatientNotFound;
import bisht.b.PandemicTracker.PandemicManager.PandemicManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PandemicTrackerApplication {

	public static void main(String[] args) {

//		SpringApplication.run(PandemicTrackerApplication.class, args);

		System.out.println("Pandemic Tracker...");

		PandemicManager pandemicManager = new PandemicManager();

		pandemicManager.report("COVID-19", "P1", "China", "Hubei", "Wuhan" );
		pandemicManager.report("COVID-19", "P2", "China", "Hubei", "Wuhan");
		pandemicManager.report("COVID-19", "P3", "China", "Jiangsu", "Shanghai");
		pandemicManager.report("COVID-19", "P4", "India", "Uttar Pradesh", "Agra");
		pandemicManager.report("COVID-19", "P5", "India", "Uttar Pradesh", "Varanasi");
		pandemicManager.report("COVID-19", "P6", "India", "Karnataka", "Bangalore");
		pandemicManager.report("COVID-19", "P7", "India", "Karnataka", "Bangalore");
		pandemicManager.report("COVID-19", "P8", "India", "Karnataka", "Bangalore");
		pandemicManager.report("Spanish Flu", "P9", "USA", "California", "Los Angeles");
		pandemicManager.report("Spanish Flu", "P10", "USA", "California", "San-francisco");

		System.out.println(pandemicManager.showWorldSummary());

		System.out.println((pandemicManager.showWorldSummaryDiseasesBreakup()));

		System.out.println((pandemicManager.showCountryBreakup("COVID-19")));
		System.out.println((pandemicManager.showCountryBreakup("Spanish Flu")));

		pandemicManager.fatal("COVID-19", "P1");


		try{
			pandemicManager.fatal("COVID-19", "P1");
		}
		catch (PatientNotFound e){

			System.out.println(e.getMessage());

		}

		System.out.println(pandemicManager.showWorldSummaryDiseasesBreakup());



	}

}
