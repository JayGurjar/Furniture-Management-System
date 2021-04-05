package edu.ucalgary.ensf409;

abstract class OfficeFurniture {
    private String id;
    private String type;
    private String manuID;
    private int price;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManuID() {
        return this.manuID;
    }

    public void setManuID(String manuID) {
        this.manuID = manuID;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
