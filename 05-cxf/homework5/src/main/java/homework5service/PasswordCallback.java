package homework5service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class PasswordCallback implements CallbackHandler {

	private Map<String, String> passwords = new HashMap<String, String>();
    	public PasswordCallback() {
          	passwords.put("Athlete1", "aaa111");
          	passwords.put("Athlete2", "bbb222");
    	}
    
    	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        
	  System.out.println("Callback");
    	  for (int i = 0; i < callbacks.length; i++) {
            	WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];
            	String pass = passwords.get(pc.getIdentifier());
            	if (pass != null) {
                 	pc.setPassword(pass);
                	return;
            	}
        	}
    }
}