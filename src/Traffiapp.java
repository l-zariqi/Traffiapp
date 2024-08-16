

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// created by : Tanzila Islam (ID: w1723144)

public class Traffiapp {
    
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        
     DBConnection.getConn();
      // DBConnection.creatingTable();
     //DBConnection.cTrafficDataTables();
     // ArrayList<String> fileData= CSVfiles.readfile("./Data.csv");
     // DBConnection.insertR(fileData);
     // DBConnection.insertC(fileData);
     //DBConnection.insertMi(fileData);
     //DBConnection.insertMa(fileData);
     
     userLogin login = new userLogin ();
     login.setVisible(true);
     
     
    }
}
