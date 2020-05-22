package encapsulation.model;

public class Circuit {
    private int volume;

    public int trigger() {
        volume++;
        System.out.println("Triggering circuit.");
        return volume;
    }
}
