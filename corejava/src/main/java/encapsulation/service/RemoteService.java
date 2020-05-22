package encapsulation.service;

public interface RemoteService {
    int batterPercentage = 100; //Are by default public, static

    /**
     * default methods are public by default. those accessible by object reference.
     * @return
     */
    default int getBatteryPercent() {
        return batterPercentage;
    }

    /**
     * Turns volume up
     * @return current volume
     */
    int volumeUp();

    /**
     * Turns volume down
     * @return current volume
     */
    int volumeDown();

    /**
     * Power off the TV
     * @return
     */
    boolean powerOff();

    /**
     * change channel upwards.
     * @return channel Number
     */
    int changeChannelUp();

    /**
     * change channel downwards.
     * @return
     */
    int changeChannelDown();
}
