package hw4;
import java.util.List;

@javax.jws.WebService
public interface VerificationService {
    
	@javax.jws.WebMethod
    public boolean verify(int athleteId);
    
	@javax.jws.WebMethod
    public List<Integer> getAllVerifiedAthletes();

}
