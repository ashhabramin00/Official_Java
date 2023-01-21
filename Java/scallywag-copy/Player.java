/* Abs (March 4 2022)
/* Abs (March 17 2022)
 * A class used to manage players
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IndexOutOfBoundsException;

public class Player {
    private String name;
    private int charAmt;
    private boolean useNum;
    private List <String> usedChar;
    private List <String> totalChar;
    
    public Player (String alias, int amt, boolean rng) {
        name = alias;
        charAmt = amt;
        useNum = rng;
        usedChar = new ArrayList <String>();
        totalChar = defineTotalCharList();
    }
    
    public String insertNumRoll(int numRoll) {
        // rolls a random character & checks for reroll
        
        Scanner scan = new Scanner(System.in);
        Random gen = new Random();
        String rolledChar = "";
        String itIs;
        String prevChar;
        String prevChar2;
        boolean reroll = true;
        
        try {
            prevChar = usedChar.get(usedChar.size() - 1);
        }
        catch (IndexOutOfBoundsException exception) {
            prevChar = null;
        }
        
        try {
            prevChar2 = usedChar.get(usedChar.size() - 2);
        }
        catch (IndexOutOfBoundsException exception) {
            prevChar2 = null;
        }
        
        while (reroll) {
            System.out.println(name + " rolled " + numRoll
                             + "\nWho is it?");
            rolledChar = scan.nextLine();
                
            if (!(rolledChar.equals(prevChar) || rolledChar.equals(prevChar2))) {
                reroll = false;
            }
            else {
                boolean again = true;
                String repeat;
                
                while (again) {
                    System.out.println("Reroll? [Y/N]");
                    repeat = scan.nextLine();
                    
                    if (repeat.equalsIgnoreCase("y")) {
                        again = false;
                    }
                    else if (repeat.equalsIgnoreCase("n")) {
                        reroll = false;
                        again = false;
                    }
                    else
                        System.out.println("Try again.");
                }
            }
        }
        
        usedChar.add(rolledChar);
        
        return rolledChar;
    }
    
    public int rollNum () {
        // rolls a random number
        
        Random gen = new Random();
        int numRoll;
        
        numRoll = gen.nextInt(charAmt + 1);
        
        return numRoll;
    }
    
    public String rollChar () {
        // rolls a random character & checks for reroll
        
        Scanner scan = new Scanner(System.in);
        Random gen = new Random();
        int numRoll;
        String rolledChar = "";
        String itIs;
        String prevChar;
        String prevChar2;
        boolean reroll = true;
        
        try {
            prevChar = usedChar.get(usedChar.size() - 1);
        }
        catch (IndexOutOfBoundsException exception) {
            prevChar = null;
        }
        
        try {
            prevChar2 = usedChar.get(usedChar.size() - 2);
        }
        catch (IndexOutOfBoundsException exception) {
            prevChar2 = null;
        }
        
        while (reroll) {
            numRoll = gen.nextInt(totalChar.size());
            rolledChar = totalChar.get(numRoll);
            System.out.println(name + " rolled " + rolledChar);
                
            if (!(rolledChar.equals(prevChar) || rolledChar.equals(prevChar2))) {
                reroll = false;
            }
            else {
                boolean again = true;
                String repeat;
                
                while (again) {
                    System.out.println("Reroll? [Y/N]");
                    repeat = scan.nextLine();
                    
                    if (repeat.equalsIgnoreCase("y")) {
                        again = false;
                    }
                    else if (repeat.equalsIgnoreCase("n")) {
                        reroll = false;
                        again = false;
                    }
                    else
                        System.out.println("Try again.");
                }
            }
        }
        
        usedChar.add(rolledChar);
        
        return rolledChar;
    }
    
    public void cleanRoll () {
        //  removes last roll
        
        usedChar.remove(usedChar.size() - 1);
    }
    
    public void addUsedChar(String used) {
        usedChar.add(used);
    }
    
    public void changePlayer (Player newPlayer) {
        name = newPlayer.getName();
        charAmt = newPlayer.getCharAmt();
        useNum = newPlayer.getUseNum();
    }
    
    public List <String> defineTotalCharList () {
        // defines totalChar
        
        List <String> characters = new ArrayList <String>();
        
        try {
            Scanner in = new Scanner(new File("characters.txt"));
                
            while (in.hasNextLine())
                characters.add(in.nextLine());
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error.");
            ex.printStackTrace();
        }
        
        return characters;
    }
    
    public String getName () {
        return name;
    }
    
    public int getCharAmt () {
        return charAmt;
    }
    
    public boolean getUseNum () {
        return useNum;
    }
    
    public List <String> getUsedChar ( ) {
        return usedChar;
    }
    
    public List <String> getTotalChar () {
        return totalChar;
    }
}