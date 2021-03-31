package edu.ucalgary.ensf409;

public class Order {
    private String [] orderId;
    private String furnitureCategory;
    private String type;
    private int items;
    private FacultyInfo facultyInfo;
    private Desk [] desks;
    private Chair [] chairs;
    private Lamp [] lamps;
    private Filing [] filings;
    private String [] idOrderedItems;

    public void main(String[] args) {

    }

    public Order() {

    }

    public Order(String furnitureCateogry, String type, int items) {
        this.furnitureCategory = furnitureCateogry;
        this.type = type;
        this.items = items;
    }


    public void readOrder() {

    }
    public void writeOrder() {

    }
    public void calculateCost(Order order, Desk [] desks, Chair [] chairs, Lamp [] lamps, Filiing [] filings) {

    }

}