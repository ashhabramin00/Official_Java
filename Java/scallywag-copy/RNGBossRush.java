/* Abs (March 18 2022)
 * An RNG Bossrush Manager for Genshin Impact
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.io.IOException;

public class RNGBossRush {
    private List <Player> party;
    
    public RNGBossRush () {
        party = defineParty();
    }
    
    public static void main (String[]arg) {
        Scanner scan = new Scanner(System.in);
        RNGBossRush Manager = new RNGBossRush();
        List <Player> team = Manager.getParty();
        SavedRuns Fmt = new SavedRuns();
        int decision = 1;
        boolean repeat = true;
        
        System.out.println(Manager.intro());
        // greets the user with a nice message
        
        while (repeat) {
            // will repeat until user selects 7 to save & end run
            
            System.out.println("\nCURRENT BOSS: " + Fmt.currentBoss()
                             + "\n   [1] Start Boss"
                             + "\n   [2] Change Last Run"
                             + "\n   [3] Modify Player"
                             + "\n   [4] Show Progress"
                             + "\n   [5] Rules"
                             + "\n   [6] Save & End Run");
            // a decision window showcasing different options
            
            try {
                decision = scan.nextInt();
            }
            catch (InputMismatchException ex) {
                    System.out.println("Try again.");
                    scan.next();
            }
            // a try-catch that will repeat until a valid user input has given
            
            scan.nextLine();
            
            switch (decision) {
                case 1:
                    String[] rolls = new String[4];
                    int decision2 = 1;
                    boolean reroll = true;
                    boolean again = true;
                    
                    if (!(Fmt.currentBoss().equals("NONE"))) {
                        // option: start run
                        // if there are still bosses leftover, will continue
                        
                        for (int loop = 0; loop < 4; loop++) {
                            if (!(team.get(loop).getUseNum())) {
                                rolls[loop] = Manager.rollPlayer(team.get(loop));
                                team.get(loop).addUsedChar(rolls[loop]);
                            }
                            else
                                rolls[loop] = String.valueOf(team.get(loop).rollNum());
                        }
                        // saves the party's rolls
                        
                        System.out.println();
                        System.out.println("Roll Result:");
                        
                        for (int loop = 0; loop < 4; loop++) {
                            System.out.print(team.get(loop).getName() + " ");
                        }
                        // shows name of every party member
                        
                        
                        System.out.println();
                        
                        for (int loop = 0; loop < 4; loop++) {
                            System.out.print(rolls[loop] + " ");
                        }
                        // shows roll results for each respective party member
                        
                        System.out.println();
                        
                        for (int loop = 0; loop < 4; loop++) {
                            if (team.get(loop).getUseNum()) {
                                System.out.println();
                                System.out.println(team.get(loop).getName() + "'s Character is...?");
                                String itIs = scan.nextLine();
                                team.get(loop).addUsedChar(itIs);
                            }
                        }
                        
                        while (again) {
                            System.out.println();
                            System.out.println("\n[1] Save Run"
                                             + "\n[2] Reroll"
                                             + "\n[3] Fail Run");
                            
                            try {
                                decision2 = scan.nextInt();
                            }
                            catch (InputMismatchException ex) {
                                    System.out.println("Try again.");
                                    scan.next();
                            }
                            
                            scan.nextLine();
                            
                            switch (decision2) {
                                case 1:
                                    String newRun;
                                    String time;
                                    
                                    System.out.println("Time:");
                                    time = scan.nextLine();
                                    
                                    newRun = Manager.compileRun(Fmt.currentBoss(), time);
                                    Fmt.addRun(newRun);
                                    again = false;
                                    break;
                                    
                                case 2:
                                    int specify;
                                    
                                    System.out.println("Reroll who? [1/2/3/4]");
                                    specify = scan.nextInt();
                                    specify--;
                                    scan.nextLine();
                                    
                                    team.get(specify).cleanRoll();
                                    team.get(specify).addUsedChar(Manager.rollPlayer(team.get(specify)));
                                    break;
                                    
                                case 3:
                                    System.out.println("Wasted.");
                                    again = false;
                                    break;
                            }
                        }
                    }
                    else
                            System.out.println("There are no more bosses.");
                    break;
                
                case 2:
                    // option: change last run
                    
                    String newRun;
                    String time;
                    
                    Fmt.removeRun();
                    for (int loop = 0; loop < team.size(); loop++) {
                        String used;
                        
                        team.get(loop).cleanRoll();
                        System.out.println(team.get(loop).getName() + "'s Character:");
                        used = scan.nextLine();
                        team.get(loop).addUsedChar(used);
                    }
                    
                    System.out.println("Time:");
                    time = scan.nextLine();
                    
                    newRun = Manager.compileRun(Fmt.currentBoss(), time);
                    Fmt.addRun(newRun);
                    break;
                
                case 3:
                    // option: modify player
                    
                    Player chosenPlayer;
                    Player newPlayer;
                    int specify;
                    
                    System.out.println("Which player? [1/2/3/4]");
                    specify = scan.nextInt();
                    scan.nextLine();
                    specify--;
                    chosenPlayer = team.get(specify);
                    // asks which player to change
                    
                    newPlayer = Manager.modifyPlayer();
                    chosenPlayer.changePlayer(newPlayer);
                    
                    break;
                    
                case 4:
                    // option: show progress
                    System.out.println(Fmt.showProgress());
                    break;
                    
                case 5:
                    // option: rules
                    Manager.readRules();
                    break;
                    
                case 6:
                    // option: save & end run
                    // ends the program and method saves result into a .txt file
                    
                    Fmt.saveResult();
                    scan.close();
                    repeat = false;
                    break;
                    
                default:
                    // user didn't input a valid choice
                    System.out.println("YOU DON'T HAVE ANOTHER CHOICE, YOU FOOL!");
                    break;
            }
        }
    }
    
    public List <Player> defineParty () {
        // defines party
        
        Scanner scan = new Scanner(System.in);
        List <Player> createdParty = new ArrayList <Player>();
        String name;
        String useNumStringInput;
        int charAmt = 1;
        boolean useNum = true;
        
        for (int loop = 0; loop < 4; loop++) {
            boolean again = true;
            
            System.out.println("Name of P" + (loop + 1) + ":");
            name = scan.nextLine();
            
            while (again) {
                System.out.println("Use numbers instead of the entire list? [Y/N]");
                useNumStringInput = scan.nextLine();
            
                if (useNumStringInput.equalsIgnoreCase("y")) {
                    useNum = true;
                    again = false;
                }
                else if (useNumStringInput.equalsIgnoreCase("n")) {
                    useNum = false;
                    charAmt = 0;
                    again = false;
                }
                else
                    System.out.println("Try again.");
            }
            
            again = true;
            
            if (useNum)
                while (again) {
                    try {
                        System.out.println("Amount of Characters P" + (loop + 1) + " has:");
                        charAmt = scan.nextInt();
                        scan.nextLine();
                        again = false;
                    }
                    catch (InputMismatchException ex) {
                        System.out.println("Try again.");
                        scan.next();
                    }
                }
            
            Player Person = new Player(name, charAmt, useNum);
            createdParty.add(Person);
            System.out.println();
        }
        
        return createdParty;
    }
    
    public String intro () {
        // returns a friendly greeting to the user
        
        List <Player> team = this.getParty();
        String greeting = "";
        
        for(int loop = 0; loop < team.size(); loop++) {
            greeting += (team.get(loop).getName());
            
            if (loop == 2)
                greeting += (", and ");
            else if (loop < 2)
                greeting += (", ");
        }
            
        greeting += (" are feeling murdery!"
                   + "\nThus starts the RNG Boss Rush!");
        
        return greeting;
    }
    
    public String rollPlayer (Player p) {
        String usedChar;
        boolean useNum = p.getUseNum();
        
        if (useNum) {
            int charNum;
            
            charNum = p.rollNum();
            usedChar = p.insertNumRoll(charNum);
        }
        else {
            usedChar = p.rollChar();
        }
        
        return usedChar;
    }
    
    public String compileRun (String boss, String time) {
        // asks user for time and returns the compiled run
        
        Scanner scan = new Scanner(System.in);
        List <Player> team = this.getParty();
        String newRun = "";
        
        newRun += boss;
        
        newRun += " (" + time + ")\n"; 
        
        for (int loop = 0; loop < party.size(); loop++) {
            newRun += (team.get(loop).getName() + " ");
        }
        
        newRun += "\n";
        
        for (int loop = 0; loop < party.size(); loop++) {
            newRun += (team.get(loop).getUsedChar().get(team.get(loop).getUsedChar().size()-1) + " ");
        }
        
        return newRun;
    }
    
    public Player modifyPlayer() {
        Scanner scan = new Scanner(System.in);
        Player newPlayer;
        String newName;
        String newUseNumStringInput;
        int newCharAmt = 0;
        boolean newUseNum = false;
        boolean again = true;
        
        System.out.println("New Name:");
        newName = scan.nextLine();
        
        while (again) {
            System.out.println("Use numbers instead of the entire list? [Y/N]");
            newUseNumStringInput = scan.nextLine();
        
            if (newUseNumStringInput.equalsIgnoreCase("y")) {
                newUseNum = true;
                again = false;
            }
            else if (newUseNumStringInput.equalsIgnoreCase("n")) {
                newUseNum = false;
                newCharAmt = 0;
                again = false;
            }
            else
                System.out.println("Try again.");
        }
        
        again = true;
        
        if (newUseNum)
            while (again) {
                try {
                    System.out.println("Amount of Characters:");
                    newCharAmt = scan.nextInt();
                    scan.nextLine();
                    again = false;
                }
                catch (InputMismatchException ex) {
                    System.out.println("Try again.");
                    scan.next();
                }
            }
        
        newPlayer = new Player (newName, newCharAmt, newUseNum);
        return newPlayer;
    }
    
    public void readRules () {
        // prints the rules
        
        System.out.println();
        
        try {
                Scanner in = new Scanner(new File("rules.txt"));
                
                while (in.hasNextLine())
                    System.out.println(in.nextLine());
        }
        catch (FileNotFoundException ex) {
                System.out.println("Error.");
                ex.printStackTrace();
        }
    }
    
    public List <Player> getParty () {
        // returns the party List
        return party;
    }
}