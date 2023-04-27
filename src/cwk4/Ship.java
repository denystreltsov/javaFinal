package cwk4;

public class Ship implements java.io.Serializable {
    protected int fees;
    protected int strength;

    public Ship(int fees, int strength) {
        this.fees = fees;
        this.strength = strength;
}
    public int getFees(){
        return fees;
    }
    public String toString() {
        return "Ship{" +
                "fees=" + fees +
                ", strength=" + strength +
                '}';
    }
}