package test;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface UC {
    @WebMethod
    double c2f(double celsius);
}