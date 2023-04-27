package cwk4;

public class Starship extends Ship{
    private int laserCanon;
    private int torpedo;

    public String toString() {
        return "Starship: " +
                "laserCanon=" + laserCanon +
                ", torpedo=" + torpedo +
                ", fees=" + fees +
                ", strength=" + strength;
    }

    public Starship(int fees, int strength, int laserCanon, int torpedo) {
        super(fees, strength);
        this.laserCanon = laserCanon;
        this.torpedo = torpedo;
}
}