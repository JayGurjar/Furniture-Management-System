package edu.ucalgary.ensf409;

class Lamp extends OfficeFurniture {
    private char base;
    private char bulb;

 

    public Lamp() {
    }
    public Lamp(char base) {
        setBase(base);
    }
    public Lamp(String id, String type, String manuId, int price, char base, char bulb) {
        super.setId(id);
        super.setType(type);
        super.setManuID(manuId);
        super.setPrice(price);
        setBase(base); 
        setBulb(bulb);
    }

    public char getBase() {
        return this.base;
    }

    public void setBase(char base) {
        this.base = base;
    }

    public char getBulb() {
        return this.bulb;
    }

    public void setBulb(char bulb) {
        this.bulb = bulb;
    }
}
