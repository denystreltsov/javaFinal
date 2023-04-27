package cwk4;

public class Wing extends Ship{

    private int strikers;

    public Wing(int fees, int strength, int strikers) {
        super(fees, strength);
        this.strikers = strikers;
    }

    public String toString() {
        return "Wing: " +
                "strikes=" + strikers +
                ", fees=" + fees +
                ", strength=" + strength;
}


}