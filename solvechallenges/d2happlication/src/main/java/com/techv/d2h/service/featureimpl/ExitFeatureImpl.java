package com.techv.d2h.service.featureimpl;

public class ExitFeatureImpl extends AbstractFeatureImpl{

    private String exitMessage;

    public ExitFeatureImpl() {
    }

    public ExitFeatureImpl(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    @Override
    public void process() {
        if (exitMessage != null) {
            LOGGER.info(exitMessage);
        }
        System.exit(0);
    }
}
