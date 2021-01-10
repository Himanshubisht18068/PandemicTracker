package bisht.b.PandemicTracker.CustomExceptions;

public class PatientExistsWithThisDisease extends RuntimeException{

    private String exceptionMsg;

    public PatientExistsWithThisDisease(String exceptionMsg) {
        super(exceptionMsg);
        this.exceptionMsg = exceptionMsg;
    }

}
