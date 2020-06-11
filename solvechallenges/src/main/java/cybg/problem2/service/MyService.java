package cybg.problem2.service;

import cybg.problem2.exceptions.*;

public interface MyService {
    double getPoints(String customerId) throws UserNotFoundException;
    void save(String customerId, double points) throws UserNotFoundException;
}