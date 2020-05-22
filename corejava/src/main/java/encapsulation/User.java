package encapsulation;

import encapsulation.model.Remote;
import encapsulation.service.RemoteService;
import encapsulation.service.impl.LGRemoteServiceImpl;

public class User {

    public static void main(String[] args) {
        Remote remote = new Remote();
        RemoteService remoteService = new LGRemoteServiceImpl(remote);
//        RemoteService remoteService3 = new RemoteService();

        int b = RemoteService.batterPercentage;
        remoteService.getBatteryPercent();

        LGRemoteServiceImpl remoteService2 = new LGRemoteServiceImpl(remote);

        remoteService.changeChannelUp();
    }
}
