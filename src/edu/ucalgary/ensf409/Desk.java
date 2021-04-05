package edu.ucalgary.ensf409;

class Desk extends OfficeFurniture {
    private char legs;
    private char top;
    private char drawer;

    public Desk() {        
    }
    
    public Desk(String id, String type, String manuId, int price, char top, char drawer, char legs) {
        super.setId(id);
        super.setType(type);
        super.setManuID(manuId);
        super.setPrice(price);
        setTop(top);
        setDrawer(drawer);
        setLegs(legs);
    }

    public char getLegs() {
        return this.legs;
    }

    public void setLegs(char legs) {
        this.legs = legs;
    }

    public char getTop() {
        return this.top;
    }

    public void setTop(char top) {
        this.top = top;
    }

    public char getDrawer() {
        return this.drawer;
    }

    public void setDrawer(char drawer) {
        this.drawer = drawer;
    }
    
}
