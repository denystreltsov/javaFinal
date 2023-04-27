package cwk4;

public class WarBird extends Ship{
    private boolean cloaking;

    public String toString() {
        return "WarBird: " +
                "cloaking=" + cloaking +
                ", fees=" + fees +
                ", strength=" + strength;
    }
    public boolean hasCloaking(){
        return cloaking;
    }

    public WarBird(int fees, int strength, boolean cloaking) {
        super(fees, strength);
        this.cloaking = cloaking;
}
}