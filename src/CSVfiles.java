
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanzi
 */

// created by : Tanzila Islam (ID: w1723144)

public class CSVfiles {         //csv file reader
    
    public static ArrayList<String> readfile (String fileName){
        ArrayList<String> fileData = new ArrayList<String>();          
        
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader (reader);
            
            String l = "";          // skip the first row and start with the second row 
            
            bufferedReader.readLine();
            while ((l =bufferedReader.readLine()) !=null) {    //loop until it's not null
                
                fileData.add(l);
                System.out.println(l);
                
            }
            
            
            
            
        }catch (Exception e) {
            System.out.println("Error reading the file" + e.getMessage());
        }
        return fileData;
    }
}
