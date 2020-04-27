package com.techv.d2h.service;

public interface Logger {
    void info(String string);
    void error(String string);
    void error(String string, Throwable e);
}
