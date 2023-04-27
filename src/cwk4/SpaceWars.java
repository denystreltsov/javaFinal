package cwk4; 
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class implements the behaviour expected from a WIN
 system as required for 5COM2007 - March 2023
 * 
 * @author Team ??
 * @version March 2023
 */

public class SpaceWars implements WIN, java.io.Serializable {
    private User user;
    ArrayList<Battle> Battles = new ArrayList();
//**************** WIN **************************  

    /**
     * Constructor requires the name of the admiral
     *
     * @param admiral the name of the admiral
     */
    public SpaceWars(String admiral) {
        this.user = new User(admiral);
        setupForces();
        setupBattles();
    }
    /** Second constructor - task 3.5
     *  To be added for task 3.5
     */
    /**
     * Returns a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Active Star Fleet(ASF),(or, "No forces" if Star Fleet is empty)
     *
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Star Fleet,(or, "No forces" if Active Star Fleet is empty)
     **/
    public String toString() {
        return getAllForces() + "\n" + getAllBattles() + "\n" + "************ User Details ************" + "\n" + "Name= " + user.getName() + "\n" + "Role= " + user.getRole() + "\n" + "Warchest= " + user.getWarchest() +"\n\n\n";}
    /**
     * returns true if war chest <=0 AND the active Star Fleet(ASF) has no
     * forces which can be recalled.
     *
     * @returns true if war chest <=0 and the active Star Fleet(ASF) has no
     * forces which can be recalled.
     */
    public boolean isDefeated() {
        return user.isDefeated();
    }
    /**
     * returns the number of bit coins in the war chest
     *
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest() {
        return user.getWarchest();
    }
    /**
     * Returns a list of all forces in the system by listing :
     * All forces in the Active Star Fleet(ASF), or "No forces in ASF")
     * All forces remaining in the UFF dock, or "No forces in UFF dock
     * All forces destroyed as a result of losing a battle, or "No destroyed forces"
     */
    public String getAllForces() {
        return user.getAllForces();
    }
    /**
     * Returns true if force is in the United Forces Fleet(UFF), else false
     *
     * @param ref reference of the force
     * @return a String representation of all forces in the United Forces Fleet(UFF)
     **/
    public boolean isInUFFDock(String ref) {
        return user.isInDock(ref);
    }

    /**
     * Returns a String representation of all forces in the United Forces Fleet(UFF) dock.
     * Does not include destroyed forces
     *
     * @return a String representation of all forces in the United Forces Fleet(UFF) dock.
     **/
    public String getForcesInDock() {
        String s = "\n************************ Forces available in UFFleet Dock ************************\n";
        for (int i = 0; i < user.getDockedArray().size(); i++) {
            s += "\n" + user.getDockedArray().get(i).toString();
        }
        return s;
    }

    /**
     * Returns a list of all destroyed forces in the system
     *
     * @return all destroyed forces
     */
    public String getDestroyedForces() {
        String s = "\n********************************** Destroyed Forces **********************************\n";
        for (int i = 0; i < user.getDestroyedArray().size(); i++) {
            s += "\n" + user.getDestroyedArray().get(i).toString();
        }
        return s;
    }

    /**
     * Returns details of the force with the given reference code, or "No such force"
     *
     * @param ref the reference of the force
     * @return details of the force with the given reference code
     **/
    public String getForceDetails(String ref) {
        return user.getForceDetails(ref);
    }
    // ***************** Active Star Fleet Forces ************************
    /**
     * Allows a force to be activated into the Active Star Fleet(ASF), but
     * only if there are enough resources for the activation fee.The force's
     * state is set to "active"
     *
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the UFF dock or is destroyed
     * 2 if not enough money, -1 if no such force
     **/
    public int activateForce(String ref) {
        return user.activateForce(ref);
    }
    /**
     * Returns true if the force with the reference code is in
     * the Active Star Fleet(ASF), false otherwise.
     *
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the active Star Fleet(ASF), false otherwise.
     **/
    public boolean isInASFleet(String ref) {
        return user.isInASFleet(ref);
    }

    /**
     * Returns a String representation of the forces in the active
     * Star Fleet(ASF), or the message "No forces activated"
     *
     * @return a String representation of the forces in the active
     * Star Fleet, or the message "No forces activated"
     **/
    public String getASFleet() {
        String s = "\n****** Forces in the Active Star Fleet******\n";
        s += user.getActiveArray();
        return s;
    }

    /**
     * Recalls a force from the Star Fleet(ASF) back to the UFF dock, but only
     * if it is in the Active Star Fleet(ASF)
     *
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref) {
        user.recallForce(ref);
    }
//**********************Battles************************* 

    /**
     * returns true if the number represents a battle
     *
     * @param num is the number of the required battle
     * @returns true if the number represents a battle
     **/
    public boolean isBattle(int num) {
        if (num <= this.Battles.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Provides a String representation of a battle given by
     * the battle number
     *
     * @param num the number of the battle
     * @return returns a String representation of a battle given by
     * the battle number
     **/
    public String getBattle(int num) {
        if (num <= this.Battles.size()) {
            String s = "\n************ Battle Number:" + num + " ************\n";
            for (int i = 0; i < this.Battles.size(); i++) {
                if (Battles.get(i).getBattleNo() == num) {
                    s += "\n" + Battles.get(i).toString();
                }
            }
            return s;
        } else {
            return "No such battle";
        }
    }
    /**
     * Provides a String representation of all battles
     *
     * @return returns a String representation of all battles
     **/
    public String getAllBattles() {
        String s = "\n************ All Battles ************\n";
        for (int i = 0; i < this.Battles.size(); i++)
            s += Battles.get(i).toString();

        return s;
    }
    /**
     * Retrieves the battle represented by the battle number.Finds
     * a force from the Active Star Fleet which can engage in the battle.The
     * results of battle will be one of the following:
     * 0 - Battle won, battle gains added to the war chest,
     * 1 - Battle lost as no suitable force available, battle losses
     * deducted from war chest
     * 2 - Battle lost on battle strength , battle losses
     * deducted from war chest and force destroyed
     * 3 - If a battle is lost and admiral completely defeated (no resources and
     * no forces to recall)
     * -1 - no such battle
     *
     * @param battleNo is the number of the battle
     * @return an int showing the result of the battle (see above)
     */
    public int doBattle(int battleNo) {
        String Etype = null;
        int Estrength = 0;
        int loss = 0;
        int gain = 0;
        Force Uforce = null;
        for (Battle battle : this.Battles) {
            if (battle.getBattleNo() == (battleNo)) {
                Estrength = battle.getStrength();
                Etype = battle.getType();
                loss = battle.getLoss();
                gain = battle.getGain();
                break;
            }
        }
        if(Etype == null){
            return -1;
        }
        Uforce = user.findSuitableForce(Etype);
        if (Uforce == null) {
            user.deductWarchest(loss);
            return 1;
        }
        if (Uforce.getStrength() == Estrength){
            user.addWarchest(gain);
            return 4;
        } else if
        (Uforce.getStrength() > Estrength) {
            user.addWarchest(gain);
            return 0;
        } else if
        (Uforce.getStrength() < Estrength) {
            user.loseBattle(Uforce, loss);
            return 2;
        } else if
        (user.isDefeated() == true) {
            return 3;
        }
        return 0;
    }


    //*******************************************************************************
    private void setupForces() {
        user.addToDockedArray(new Force("Enterprise", "SS2", new Starship(300, 200, 10, 20)));
        user.addToDockedArray(new Force("Twisters", "IW1", new Wing(200, 200, 10)));
        user.addToDockedArray(new Force("Droop", "WB3", new WarBird(300, 100, false)));
        user.addToDockedArray(new Force("Wingers", "IW4", new Wing(200, 400, 20)));
        user.addToDockedArray(new Force("Hang", "WB5", new WarBird(400, 300, true)));
        user.addToDockedArray(new Force("Voyager", "SS6", new Starship(450, 200, 15, 10)));
        user.addToDockedArray(new Force("Explorer", "SS7", new Starship(120, 65, 4, 5)));
        user.addToDockedArray(new Force("Hover", "WB9", new WarBird(300, 400, false)));
        user.addToDockedArray(new Force("Flyers", "IW10", new Wing(200, 100, 5)));
    }
    private void setupBattles() {
        BufferedReader reader; // New Array for the Battles, can be accessed by Admiral and the Spacewars class
        int battleCount = 1;
        try {
            reader = new BufferedReader(new FileReader("./src/battles.txt"));
            String line = reader.readLine(); //reads each line and assigns it to the temp variable 'line'
            while (line != null) { // while there is a line to process
                String[] a = line.split(","); // separates the read line everytime there is a ',' "100"
                this.Battles.add(new Battle(battleCount, a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]))); // creates battle object by inputing the parameters
                line = reader.readLine(); //moves to the next line
                battleCount = battleCount + 1;
            }
            // for (int i = 0; i < this.Battles.size(); i++) {    // Iterates through all of the objects, printing them out.
            //    System.out.println(this.Battles.get(i));
            // }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//**************************Add your own private methos here ***********************
    //*******************************************************************************
    //These methods are not needed until Task 3.5. Uncomment thmemto complete task 3.5
    // ***************   file write/read  *********************
    /**
     * Writes whole game to the specified file
     *
     *@param fname name of file storing requests
     */
    public void saveGame(String fname) {   // uses object serialisation
        try {
            FileOutputStream file = new FileOutputStream(fname);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this.user);
            out.close();
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            System.out.println(e);
        }
    }
    /**
     * reads all information about the game from the specified file
     * and returns a SpaceWars object
     *
     * @param fname name of file storing the game
     * @return the game (as a SpaceWars object)
     */
    public SpaceWars restoreGame(String fname) {
        try {
            FileInputStream file = new FileInputStream(fname);
            ObjectInputStream in = new ObjectInputStream(file);
            User user = (User) in.readObject();
            SpaceWars spaceWars = new SpaceWars(user.getName());
            spaceWars.user = user;
            in.close();
            file.close();
            return spaceWars;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
    /**
     * Reads information about battles from the specified file into the appropriate collection
     *
     * @param the name of the file
     */
    //private void readBattles(String fname) {
//
  //  }