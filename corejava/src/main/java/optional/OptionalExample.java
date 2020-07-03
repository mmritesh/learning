package optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String nullString = null;
       String optionalS = Optional.ofNullable(nullString).orElse("");
    }
}
