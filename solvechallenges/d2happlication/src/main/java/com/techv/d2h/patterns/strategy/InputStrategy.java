package com.techv.d2h.patterns.strategy;

public interface InputStrategy<T> {
    /**
     * InputStrategy can be anything like Console input, File Input, SMS Input, IVR Input
     * @param input
     */
    void apply(T input);
}
