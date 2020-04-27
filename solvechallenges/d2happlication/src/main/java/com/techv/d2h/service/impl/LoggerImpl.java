package com.techv.d2h.service.impl;

import com.techv.d2h.service.Logger;

public class LoggerImpl implements Logger {
    @Override
    public void info(String output) {
        System.out.println(output);
    }

    @Override
    public void error(String string) {
        System.out.println("[ERROR] " + string);
    }

    @Override
    public void error(String string, Throwable e) {
        System.out.println(string);
        e.printStackTrace();
    }
}
