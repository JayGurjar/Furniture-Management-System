package edu.ucalgary.ensf409;

import java.io.*;
import java.sql.*;

public class Order {
    private String[] orderId;
    private String furnitureCategory;
    private String type;
    private int items;
    private Connection dbConnect;
    private ResultSet results;

    // private FacultyInfo facultyInfo;
    // private Desk [] desks;
    // private Chair [] chairs;
    // private Lamp [] lamps;
    // private Filing [] filings;
    // hi
    private String [] idOrderedItems;


    public static void main(String[] args) throws IOException {
        Order o1 = new Order();
        o1.readOrder();
        o1.createConnection();
        o1.writeOrder();
        o1.selectChair();
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
                            + "\n \n" + "Items Ordered: " + "\n";  //make function orderToString to get Orders and converToString
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
    
    
}