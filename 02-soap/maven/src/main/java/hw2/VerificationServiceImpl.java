package hw2;
import jakarta.jws.WebService;

@WebService(endpointInterface = "hw2.VerificationService")
public class VerificationServiceImpl implements VerificationService {
	public boolean verify(int athleteId) {
		return athleteId % 2 == 0;
	}

}
