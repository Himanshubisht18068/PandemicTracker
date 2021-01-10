package bisht.b.PandemicTracker.CustomExceptions;

public class PatientNotFound extends RuntimeException {

    private String exceptionMsg;

    public PatientNotFound(String exceptionMsg) {
        super(exceptionMsg);
        this.exceptionMsg = exceptionMsg;
    }

}
