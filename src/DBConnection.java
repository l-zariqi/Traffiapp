/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// created by : Tanzila Islam (ID: w1723144)

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBConnection {
    
     public static Connection getConn (){             //DB connection method 
        
            String url = "jdbc:sqlite:Traffiapp.db";
            
            
            try {
               
            Driver driver= new org.sqlite.JDBC();
            
            DriverManager.registerDriver(driver);
            
            System.out.println("Driver for SQLite downloaded.");
            
                } catch (Exception e) {
                    System.out.println("Problem with download driver for SQLite: " + e.getMessage());
            }
            Connection connection = null;
            
            try {
            connection = DriverManager.getConnection(url);
            
            System.out.println("Connected to the database");
            
            
                } catch (Exception e) {
                    System.out.println("Error connection to the database " + e.getMessage());   
                }
          
             return connection;
         }
     
     
     
       public static void creatingTable () {                   //create user registration table method
        Connection connection = DBConnection.getConn();
       
       
        String table = "CREATE TABLE if not exists User_Registration ("
                + " userID INTEGER  PRIMARY KEY AUTOINCREMENT,"
                + " userFirstName VARCHAR (50) NOT NULL,"
                + " userSurname VARCHAR (50) NOT NULL,"
                + " userGender VARCHAR (1) NOT NULL,"
                + " userEmail VARCHAR (50) NOT NULL,"
                + " userTel VARCHAR (50) NOT NULL,"
                + " userName VARCHAR (50) NOT NULL,"
                + " userPassword VARCHAR (50),"
                + " type VARCHAR (50) NOT NULL,"
                + " Salt VARCHAR (50) NOT NULL,"
                + " EncryptedPass VARCHAR (50) NOT NULL"+ ") ;";
        
        
        
              

        try {
            
            Statement sqlStatement =connection.createStatement();
            
            sqlStatement.executeUpdate(table);
            
            System.out.println("User_Registration table created!");
           
            } catch(Exception e) {
             System.out.println("Error creating User_Registration table");
        }
        
        
        String loginT = "CREATE TABLE if not exists Login ("           //create login table method
                + " loginID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " loginTimeDate DATETIME NOT NULL,"   
                + " logOutTimeDate DATETIME," 
                + " userName VARCHAR (50) NOT NULL"+ ") ;";
        
        
        try {
            
            Statement sqlStatement =connection.createStatement();
            
            sqlStatement.executeUpdate(loginT);
            
            System.out.println("Login table created!");
           
            } catch(Exception e) {
             System.out.println("Error creating Login table");
        }
               
    }
       
        public static void updateTime (java.sql.Timestamp  logOutTimeDate) {       //update log out time method
              Connection pS = DBConnection.getConn();
             
              String query ="INSERT INTO Login (logOutTimeDate) VALUES"
                        + "("
                        + "'" + logOutTimeDate + "'"
                        
                        + ")";
              try {
              
                  
              java.sql.Statement statement = pS.createStatement();
            
              statement.executeUpdate(query);
              
              System.out.println("Done");
                
           
                
            } catch (Exception e) {
                    
             System.out.println("Couldnt update");
            }
              
        }
        
        
         public static void cTrafficDataTables () {           //create region table method
              Connection connection = DBConnection.getConn();
              
               String table1 = "CREATE TABLE if not exists Region("
                                + " rId INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + " region_id INTEGER(1) NOT NULL,"
                                + " region_name VARCHAR(50) NOT NULL" + ");";
        
        try {
            
            Statement sqlStatement =connection.createStatement();
            
            sqlStatement.executeUpdate(table1);
            
            System.out.println("Region table created!");
           
            } catch(Exception e) {
             System.out.println("Error creating Region table");
        }
        
        
        
            String table2 = "CREATE TABLE if not exists Count_Point("                     //create count point table method 
                               + " cId INTEGER PRIMARY KEY AUTOINCREMENT,"
                               + " count_point_id INTEGER (10) NOT NULL,"
                               + " direction_of_travel VARCHAR (2) NOT NULL,"
                               + " year INTEGER (10) NOT NULL,"
                               + " count_date DATE NOT NULL,"
                               + " hour INTEGER (3) NOT NULL,"
                               + " count_point_vehicles_id INTEGER (4) NOT NULL,"
                               + " pedal_cycles INTEGER (3) NOT NULL,"
                               + " two_wheeled_motor_vehicles INTEGER (3) NOT NULL,"
                               + " cars_and_taxis INTEGER (5) NOT NULL,"
                               + " buses_and_coaches INTEGER (5) NOT NULL,"
                               + " lgvs INTEGER (5) NOT NULL,"
                               + " hgvs_2_rigid_axle INTEGER (5) NOT NULL,"
                               + " hgvs_3_rigid_axle INTEGER (5) NOT NULL,"
                               + " hgvs_4_or_more_rigid_axle INTEGER (5) NOT NULL,"
                               + " hgvs_3_or_4_articulated_axle INTEGER (5) NOT NULL,"
                               + " hgvs_5_articulated_axle INTEGER (5) NOT NULL,"
                               + " hgvs_6_articulated_axle INTEGER (5) NOT NULL,"
                               + " all_hgvs INTEGER (5) NOT NULL,"
                               + " all_motor_vehicles INTEGER (6) NOT NULL" + ");";
            
        
            try {
            
            Statement sqlStatement =connection.createStatement();
            
            sqlStatement.executeUpdate(table2);
            
            System.out.println("Count_Point table created!");
           
                } catch(Exception e) {
             System.out.println("Error creating Count_Point table");
            }
        
        
            
            String table3 = "CREATE TABLE if not exists Minor_Road_Local_Authority("     //create minor road table method
                              + " miId INTEGER PRIMARY KEY AUTOINCREMENT,"
                              + " local_authority_id INTEGER (3) NOT NULL,"
                              + " local_authority_name VARCHAR (50) NOT NULL,"
                              + " road_name VARCHAR (50) NOT NULL,"
                              + " road_type VARCHAR (50) NOT NULL,"
                              + " easting INTEGER (10) NOT NULL,"
                              + " northing INTEGERR (10) NOT NULL,"
                              + " latitude DECIMAL (11,11) NOT NULL,"
                              + " longitude VARCHAR (50) NOT NULL,"
                              + " cId INTEGER NOT NULL,"
                              + " rId INTEGER NOT NULL,"
                              + "FOREIGN KEY(cId) REFERENCES Count_Point(cId),"
                              + "FOREIGN KEY(rId) REFERENCES Region(rId)" + ");";
            
        
      
            try {
            
            Statement sqlStatement =connection.createStatement();
            
            sqlStatement.executeUpdate(table3);
            
            System.out.println("Minor_Road_Local_Authority table created!");
           
                } catch(Exception e) {
             System.out.println("Error creating Minor_Road_Local_Authority table");
            }
            
            
            
             
            String table4 = "CREATE TABLE if not exists Major_Road_Local_Authority("   //create major road table method
                           + " maId INTEGER PRIMARY KEY AUTOINCREMENT,"
                           + " local_authority_id INTEGER (3) NOT NULL,"
                           + " local_authority_name VARCHAR (50) NOT NULL,"
                           + " road_name VARCHAR (50) NOT NULL,"
                           + " road_type VARCHAR (50) NOT NULL,"
                           + " easting INTEGER (10) NOT NULL,"
                           + " northing INTEGERR (10) NOT NULL,"
                           + " latitude DECIMAL (11,11) NOT NULL,"
                           + " longitude VARCHAR (50) NOT NULL,"
                           + " start_junction_road_name VARCHAR (50),"
                           + " end_junction_road_name VARCHAR (50),"
                           + " link_length_km DECIMAL (3,3),"
                           + " link_length_miles DECIMAL (3,3),"
                           + " cId INTEGER NOT NULL,"
                           + " rId INTEGER NOT NULL,"
                           + "FOREIGN KEY(cId) REFERENCES Count_Point(cId),"
                           + "FOREIGN KEY(rId) REFERENCES Region(rId)" + ");";
            
        
      
            try {
            
            Statement sqlStatement =connection.createStatement();
            
            sqlStatement.executeUpdate(table4);
            
            System.out.println("Major_Road_Local_Authority table created!");
           
                } catch(Exception e) {
             System.out.println("Error creating Major_Road_Local_Authority table");
            }
            
             
              
         }
         
         public static void insertRData(int id, String name)  {  // insert data into region table method
                Connection connection = DBConnection.getConn();
                
                String query1 = "INSERT INTO Region (region_id, region_name) VALUES"
                        + "("
                        + "'" + id + "',"
                        + "'" + name + "'"
                        
                        + ")";
                
                try {
                     Statement sqlStatement =connection.createStatement();
            
                    sqlStatement.executeUpdate(query1);
            
                    System.out.println("This id: " + id + " is inserted.");

                }catch (Exception e) {
                    System.out.println("Error inserting data into Region table." + e.getMessage());
                              
                }
                
                
                  
            }
         // insert data into count point 
           public static void insertCData(int d1, String d2, int d3, String d4, int d5,
           int d6, String d7, String d8, String d9, String d10, String d11, String d12,String d13,String d14, String d15, String d16, String d17, String d18, String d19)  {  // insert data into Count_Point table method
                Connection connection = DBConnection.getConn();
                
                String query2 = "INSERT INTO Count_Point(count_point_id, direction_of_travel, year, count_date, hour, count_point_vehicles_id, pedal_cycles, two_wheeled_motor_vehicles, cars_and_taxis, buses_and_coaches, lgvs, hgvs_2_rigid_axle, hgvs_3_rigid_axle, hgvs_4_or_more_rigid_axle, hgvs_3_or_4_articulated_axle, hgvs_5_articulated_axle, hgvs_6_articulated_axle, all_hgvs, all_motor_vehicles) VALUES"
                        + "("
                        + "'" + d1 + "',"
                        + "'" + d2 + "',"
                        + "'" + d3 + "',"
                        + "'" + d4 + "',"
                        + "'" + d5 + "',"
                        + "'" + d6 + "',"
                        + "'" + d7 + "',"
                        + "'" + d8 + "',"
                        + "'" + d9 + "',"
                        + "'" + d10 + "',"
                        + "'" + d11 + "',"
                        + "'" + d12 + "',"
                        + "'" + d13 + "',"
                        + "'" + d14 + "',"
                        + "'" + d15 + "',"
                        + "'" + d16 + "',"
                        + "'" + d17 + "',"
                        + "'" + d18 + "',"
                        + "'" + d19 + "'"
                        
                        + ")";
                
                try {
                     Statement sqlStatement =connection.createStatement();
            
                    sqlStatement.executeUpdate(query2);
            
                    System.out.println("This data: " + d1 + " is inserted ");

                }catch (Exception e) {
                    System.out.println("Error inserting data into Count_Point table." + e.getMessage());
                              
                }
                  
            }
           
           //insert data into minor table
           public static void insertMiData (int da1, String da2,String da3,String da4,String da5,String da6,String da7,String da8,String da9,String da10) {
               
                 Connection connection = DBConnection.getConn();
                
                String query2 = "INSERT INTO Minor_Road_Local_Authority(local_authority_id,local_authority_name,road_name,road_type,easting,northing,latitude,longitude,cId,rId) VALUES"
                        + "("
                        + "'" + da1 + "',"
                        + "'" + da2 + "',"
                        + "'" + da3 + "',"
                        + "'" + da4 + "',"
                        + "'" + da5 + "',"
                        + "'" + da6 + "',"
                        + "'" + da7 + "',"
                        + "'" + da8 + "',"
                        + "'" + da9 + "',"                       
                        + "'" + da10 + "'"
                        
                        + ")";
                
                try {
                     Statement sqlStatement =connection.createStatement();
            
                    sqlStatement.executeUpdate(query2);
            
                    System.out.println("This data: " + da1 + " is inserted ");

                }catch (Exception e) {
                    System.out.println("Error inserting data into Minor_Road_Local_Authority" + e.getMessage());
                              
                }
               
           }
           
           
           //insert data into major table
            public static void insertMaData (int c1, String c2,String c3,String c4,String c5,String c6,String c7,String c8,String c9,String c10,String c11,String c12,String c13,String c14) {
               
                 Connection connection = DBConnection.getConn();
                
                String query2 = "INSERT INTO Major_Road_Local_Authority(local_authority_id,local_authority_name,road_name,road_type,easting,northing,latitude,longitude,start_junction_road_name,end_junction_road_name,link_length_km,link_length_miles,cId,rId) VALUES"
                        + "("
                        + "'" + c1 + "',"
                        + "'" + c2 + "',"
                        + "'" + c3 + "',"
                        + "'" + c4 + "',"
                        + "'" + c5 + "',"
                        + "'" + c6 + "',"
                        + "'" + c7 + "',"
                        + "'" + c8 + "',"
                        + "'" + c9 + "'," 
                        + "'" + c10 + "'," 
                        + "'" + c11 + "'," 
                        + "'" + c12 + "',"
                        + "'" + c13 + "'," 
                        + "'" + c14 + "'"
                        
                        + ")";
                
                try {
                     Statement sqlStatement =connection.createStatement();
            
                    sqlStatement.executeUpdate(query2);
            
                    System.out.println("This data: " + c1 + " is inserted ");

                }catch (Exception e) {
                    System.out.println("Error inserting data into Major_Road_Local_Authority" + e.getMessage());
                              
                }
               
           }
         
            //insert data from the csv file to the region table 
         public static void insertR (ArrayList<String> value){
             for (String line : value) {
                 String[] Array =line.split(",");
                 int id = Integer.parseInt(Array[5]);
                 String name = Array[6];
                 insertRData(id,name);
                 
             }
             
         }
           //insert data from the csv file to the count point table
          public static void insertC(ArrayList<String> value){
             for (String line : value) {
                 String[] Array =line.split(",");
                 int d1 = Integer.parseInt(Array[0]);
                 String d2 = Array[1];
                 int d3 = Integer.parseInt(Array[2]);
                 String d4 = Array[3];
                 int d5 = Integer.parseInt(Array[4]);
                 int d6 = Integer.parseInt(Array[32]);
                 String d7 = Array[19];
                 String d8 = Array[20];
                 String d9 = Array[21];
                 String d10 = Array[22];
                 String d11= Array[23];
                 String d12 = Array[24];
                 String d13= Array[25];
                 String d14= Array[26];
                 String d15= Array[27];
                 String d16= Array[28];
                 String d17= Array[29];
                 String d18= Array[30];                        
                 String d19= Array[31];  
                 insertCData(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19);
                 
             }
             
            
             
         }
            //insert data from the csv file to the minor table 
            public static void insertMi(ArrayList<String> value){
             for (String line : value) {
                 String[] Array =line.split(",");
                 int da1 = Integer.parseInt(Array[7]);
                 String da2 = Array[8];
                 String da3 = Array[9];
                 String da4 = Array[10];
                 String da5 = Array[13];
                 String da6 = Array[14];
                 String da7 = Array[15];
                 String da8 = Array[16];
                 String da9 = Array[32];
                 String da10= Array[32];
                   
                 insertMiData(da1,da2,da3,da4,da5,da6,da7,da8,da9,da10);
                 
             }
             
            }
            
              //insert data from the csv file to the major table 
          public static void insertMa(ArrayList<String> value){
             for (String line : value) {
                 String[] Array =line.split(",");
                 int c1 = Integer.parseInt(Array[7]);
                 String c2 = Array[8];
                 String c3 = Array[9];
                 String c4 = Array[10];
                 String c5 = Array[13];
                 String c6 = Array[14];
                 String c7 = Array[15];
                 String c8 = Array[16];
                 String c9 = Array[11];
                 String c10 = Array[12];
                 String c11 = Array[17];
                 String c12 = Array[18];
                 String c13 = Array[32];
                 String c14= Array[32];
                   
                 insertMaData(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14);
                 
             }
             
            }
         
    
}
