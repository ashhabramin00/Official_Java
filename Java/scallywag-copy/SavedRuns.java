/* Abs (March 17 2022)
 * A class used to manage boss runs
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IndexOutOfBoundsException;

public class SavedRuns {
    private List <String> bossRuns;
    private List <String> totalBosses;
    
    public SavedRuns () {
        bossRuns = new ArrayList <String>();
        totalBosses = defineBossList();
    }
    
    public void addRun (String newRun) {
        // adds a new value to bossRuns
        
        bossRuns.add(newRun);
    }
    
    public void removeRun () {
        bossRuns.remove(bossRuns.size() - 1);
    }
    
    public String currentBoss () {
        try {
            if (bossRuns.size() == 0)
                return totalBosses.get(0);
            else
                return totalBosses.get(bossRuns.size());
        }
        catch (IndexOutOfBoundsException ex) {
            return "NONE";
        }
    }
    
    public String showProgress () {
        String progress = "";
        
        for (int loop = 0; loop < bossRuns.size(); loop++) {
            progress += (bossRuns.get(loop) + "\n\n");
        }
        
        return progress;
    }
    
    public void saveResult () {
        // saves all values of bossRuns in a .txt file
        
        try {
            PrintWriter out = new PrintWriter("RNGBossRushResult.txt");
            
            for (int loop = 0; loop < bossRuns.size(); loop++)
                out.print(bossRuns.get(loop) + "\n\n");

            out.close();
            // closes file
        }
        catch (FileNotFoundException exception) {
            System.out.println("Error.");
        }
        catch (IOException exception) {
            System.out.println("Error.");
        }
        
        try
        {
            Scanner in = new Scanner (new File("RNGBossRushResult.txt"));
            
            while (in.hasNextLine())
                System.out.println(in.nextLine());
                
            System.out.println();
            
            in.close();
        }
        
        catch(IOException exception)
        {
            System.out.println("Error.");
        }
    }
    
    public List <String> defineBossList () {
        // defines totalBosses using the boss.txt file
        
        List <String> bosses = new ArrayList <String>();
        
        try {
            Scanner in = new Scanner(new File("bosses.txt"));
                
            while (in.hasNextLine())
                bosses.add(in.nextLine());
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error.");
            ex.printStackTrace();
        }
        
        return bosses;
    }
    
    public List <String> getBossRuns () {
        return bossRuns;
    }
    
    public List <String> getTotalBosses () {
        return totalBosses;
    }
}