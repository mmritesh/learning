package com.techv.d2h.patterns.strategy;



public class D2hApplicationContext {

    /**
     * InputStrategy can be anything like Console input, File Input, SMS Input, IVR Input
     * @param input
     */
    public static void run(String... input) {
        if (input != null || input.length == 0) {
            new ConsoleInputStrategy().apply(null);
        }
    }
}
