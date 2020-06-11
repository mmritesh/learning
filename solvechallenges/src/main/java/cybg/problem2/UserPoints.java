package cybg.problem2;


import java.util.logging.Logger;
import cybg.problem2.exceptions.*;
import cybg.problem2.service.MyService;
import cybg.problem2.service.impl.MyServiceImpl;

public class UserPoints {

    private static final Logger log = Logger.getLogger(UserPoints.class.getName());
    private MyService myService;

    public UserPoints() {
        this.myService = new MyServiceImpl();
    }

    public boolean redeemPoint(String customerId, String amount) {
        try {
            Double toRedeem = Double.valueOf(amount);
            double currentPoints = myService.getPoints(customerId);
            double newPoints = currentPoints - toRedeem;
            myService.save(customerId, newPoints);
            log.info("Points redeemed for customer " + customerId);
        } catch (UserNotFoundException e) {
            // ToDo: Check why this logger not providing the error method.
            log.info("Error: User not found. id: " + customerId);
            return false;
        }
        return true;
    }
}