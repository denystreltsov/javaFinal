package cwk4;

public class Battle {
    private String type;
    private int battleNo;
    private String name;
    private int strength;
    private int loss;
    private int gain;

    public int getLoss(){
        return loss;}
    public int getGain(){
        return gain;}
    public Battle(int b, String t, String n, int s, int l, int g) {
        battleNo = b;
        type = t;
        name = n;
        strength = s;
        loss = l;
        gain = g;
    }

    public int getBattleNo() {
        return battleNo;
    }

    public String toString() {
        return
                "Battle Number= " + battleNo + '\'' +
                ", type= " + type + '\'' +
                ", name= " + name + '\'' +
                ", strength= " + strength +
                ", loss= " + loss +
                ", gain= " + gain
                 + "\n";
    }

    public int getStrength() {
        return strength;
    }

    public String getType() {
        return type;
    }
}
