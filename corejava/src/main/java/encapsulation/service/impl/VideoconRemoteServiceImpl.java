package encapsulation.service.impl;

import encapsulation.model.Remote;
import encapsulation.service.AbstractRemoteService;

public class VideoconRemoteServiceImpl extends AbstractRemoteService {

    public VideoconRemoteServiceImpl(Remote remote) {
        super(remote);
    }

    @Override
    public int volumeUp() {
        return 0;
    }

    @Override
    public int volumeDown() {
        return 0;
    }

    @Override
    public boolean powerOff() {
        return false;
    }

    @Override
    public int changeChannelUp() {
        return 0;
    }

    @Override
    public int changeChannelDown() {
        return 0;
    }
}
