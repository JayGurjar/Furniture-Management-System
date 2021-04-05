package edu.ucalgary.ensf409;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Order {
    private String[] orderId;
    private String furnitureCategory;
    private String type;
    private int items;
    private Connection dbConnect;
    private ResultSet results;

    private FacultyInfo facultyInfo;
    private Desk [] desks;
    private Chair [] chairs;
    private Lamp [] lamps;
    private Filing [] filings;
    private String [] idOrderedItems;

    public static void main(String[] args) throws IOException {
        Order o1 = new Order();
        o1.readOrder();
        o1.createConnection();
        //o1.writeOrder();
        o1.generalSelect();
        // o1.selectChair();
        // o1.selectDesk();
        o1.close();
    }

    public Order() {
    }

    public String getFurnitureCategory() {
        return this.furnitureCategory;
    }

    public void setFurnitureCategory(String furnitureCategory) {
        this.furnitureCategory = furnitureCategory;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getItems() {
        return this.items;
    }

    public void setItems(int items) {
        this.items = items;
    }



    /* Calcuate Furniture the furniture*/
    public void CalculateFurnitureCost() {
        // furnitureCategory = chair
        // type = mesh
        // get all mesh chairs (select * by type and category) (put into a array of relavant type)
        // make combination out of exisiting furniture  (check combinations)
        // find the lowest cost and compare to new chair (comapre function)
        // if lowest cost <= new chair 
        // else cant find combination go to manufacture
        // then get the lowest cost chair
        // updateTheDataBase(method updates database)
    }
    // For the furniture category and type specified, poplate the arrays with thecorresponding
    public void generalSelect() {
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + getFurnitureCategory() +  " WHERE Type ='" + getType() + "'" + ";") ;
            /* Counts the number of Elements needed to make the array */
            int i = 0;
            while (results.next()){
                i++;
            }
            if(getFurnitureCategory().toLowerCase().equals("chair")) {
                chairs = new Chair[i];
            } else if(getFurnitureCategory().toLowerCase().equals("desk")) {
                desks = new Desk[i];
            } else if(getFurnitureCategory().toLowerCase().equals("lamp")) {
                lamps = new Lamp[i];
            } else if(getFurnitureCategory().toLowerCase().equals("filing")) {
                filings = new Filing[i];
            } 
        
            results = myStmt.executeQuery("SELECT * FROM " + getFurnitureCategory() +  " WHERE Type ='" + getType() + "'" + ";") ;
            
            /* Populates the appropriate array with the values from database */
            int j = 0;
            while (results.next()){
            if(getFurnitureCategory().toLowerCase().equals("chair")) {
                    chairs[j] = new Chair(results.getString("ID"), results.getString("Type"), results.getString("ManuID"), 
                    results.getInt("Price"), results.getString("Legs").charAt(0), results.getString("Arms").charAt(0), 
                    results.getString("Seat").charAt(0), results.getString("Cushion").charAt(0));              
            }
            
            else if(getFurnitureCategory().toLowerCase().equals("desk")) {
                desks[j] = new Desk(results.getString("ID"), results.getString("Type"), results.getString("ManuID"), 
                results.getInt("Price"), results.getString("Top").charAt(0), results.getString("Drawer").charAt(0),
                results.getString("Legs").charAt(0));              
            }
            else if(getFurnitureCategory().toLowerCase().equals("lamp")) {
                lamps[j] = new Lamp(results.getString("ID"), results.getString("Type"), results.getString("ManuID"), 
                results.getInt("Price"), results.getString("Base").charAt(0), results.getString("Bulb").charAt(0));              
            }
            else if(getFurnitureCategory().toLowerCase().equals("filing")) {
                filings[j] = new Filing(results.getString("ID"), results.getString("Type"), results.getString("ManuID"), 
                results.getInt("Price"), results.getString("Rails").charAt(0), results.getString("Drawers").charAt(0), 
                results.getString("Cabinet").charAt(0));         
            }                 
            j++;
        }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void readOrder() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("What would you like to Order?");
        String readLine = reader.readLine();
        String [] lineArray = readLine.stripLeading().stripTrailing().split(" ");   // ADD error checking for invalid inputs
        type = lineArray[0];
        furnitureCategory = lineArray[1];
        System.out.println("How many items?");
        String readSecondLine = reader.readLine().stripLeading().stripTrailing();
        items = Integer.parseInt(readSecondLine);
    }

    public void writeOrder() throws IOException {
        try {
            FileWriter writer = new FileWriter("output.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            String write =  "Furniture Order Form" + "\n \n" + "Faculty Name: "
                    + "\n" + "Contact: " + "\n" + "Date: " + "\n \n"
                    + "Original Request: " + type + " " + furnitureCategory + ", " + Integer.toString(items)
                    + "\n \n" + "Items Ordered: " + "\n";  //make function orderToString to get Orders and convertToString
            buffer.write(write);
            buffer.close();

        } catch(Exception e) {
            System.err.println("Failed to write to file");
        }
    }

    /* Data Base methods */
    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost:3305/inventory", "ali", "ensf409");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectChair(){

        StringBuffer typeAndSeat = new StringBuffer();

        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM CHAIR");

            while (results.next()){
                // System.out.println("Print results: " + results.getString("Type") + ", " + results.getString("Seat"));
                // catsAndOwners.append(results.getString("name") + ", " + results.getString("owner"));
                // catsAndOwners.append('\n');
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return typeAndSeat.toString();
    }

    public String selectDesk(){

        StringBuffer typeAndSeat = new StringBuffer();

        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM DESK");

            while (results.next()){
                 System.out.println("Print results: " + results.getString("Type") + ", " + results.getString("ID"));
                // catsAndOwners.append(results.getString("name") + ", " + results.getString("owner"));
                // catsAndOwners.append('\n');
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return typeAndSeat.toString();
    }

    /* Commented out for now so we don't accidentally mess with the database
    // After extracting the desk we must delete that desk since it is used in our order
    public void deleteDesk(String ManuID){
        try {
            String query = "DELETE FROM DESK WHERE ManuID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, ManuID);
            myStmt.executeUpdate();
            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    */


}

