package test;

import jakarta.jws.WebService;

@WebService(endpointInterface = "test.UC")
public class UCImpl implements UC {
    public double c2f(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }
}