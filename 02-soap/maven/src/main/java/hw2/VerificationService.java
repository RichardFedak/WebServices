package hw2;
import java.util.List;

@jakarta.jws.WebService
public interface VerificationService {
    
    @jakarta.jws.WebMethod
    public boolean verify(int athleteId);
    
    @jakarta.jws.WebMethod
    public List<Integer> getAllVerifiedAthletes();

}
