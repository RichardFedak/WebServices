package hw2;

@jakarta.jws.WebService
public interface VerificationService {
    
    @jakarta.jws.WebMethod
    public boolean verify(int athleteId);
}
