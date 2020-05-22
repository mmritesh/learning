package encapsulation.service;

import encapsulation.model.Remote;

public abstract class AbstractRemoteService implements RemoteService  {

    protected Remote remote;

    public AbstractRemoteService(Remote remote) {
        this.remote = remote;
    }
}
