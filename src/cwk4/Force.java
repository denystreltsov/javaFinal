package cwk4;

public class Force<shipType extends Ship> implements java.io.Serializable {
    private String name;
    private String reference;
    private shipType type;
    public Force(String name, String reference, shipType type) {
        this.name = name;
        this.reference = reference;
        this.type = type;
    }
    public int getStrength(){
        return (type.strength);
    }
    public boolean hasCloaking(){
        if(type instanceof WarBird){
            return ((WarBird) type).hasCloaking();
        }return false;
    }
    public Ship getType() {
        return type;
    }
    public String getReference() {
        return reference;
    }

    public String toString() {
        return
                "Name= " + name +
                ", Reference= " + reference +
                ", Type= " + type;
    }
}