package edu.ucalgary.ensf409;

class Lamp extends OfficeFurniture {
    private char base;

    public Lamp() {
    }
    public Lamp(char base) {
        setBase(base);
    }
    public Lamp(String id, String type, String manuId, int price, char legs, char arms, char seat, char cushion) {
        super.setId(id);
        super.setType(type);
        super.setManuID(manuId);
        super.setPrice(price);
        setBase(base); 
    }

    public char getBase() {
        return this.base;
    }

    public void setBase(char base) {
        this.base = base;
    }
}
