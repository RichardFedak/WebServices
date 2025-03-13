package hw2;
import javax.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "hw2.VerificationService")
public class VerificationServiceImpl implements VerificationService {
	
	private final List<Integer> verifiedAthletes = new ArrayList<Integer>();
	
	@Override
	public boolean verify(int athleteId) {
		boolean isEligible = athleteId % 2 == 0;
        if (isEligible && !verifiedAthletes.contains(athleteId)) {
            verifiedAthletes.add(athleteId);
        }
        return isEligible;
	}
	
	@Override
	public List<Integer> getAllVerifiedAthletes() {
        return verifiedAthletes;
    }

}
