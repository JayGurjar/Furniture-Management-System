package edu.ucalgary.ensf409;
class Filing extends OfficeFurniture {
    private char rails;
    private char drawers;
    private char cabinet;

    public Filing() {
    }
   
    public Filing(String id, String type, String manuId, int price, char rails, char drawers, char cabinet) {
        super.setId(id);
        super.setType(type);
        super.setManuID(manuId);
        super.setPrice(price);
        setRails(rails);
        setDrawers(drawers);
        setCabinet(cabinet);
    }

    public char getRails() {
        return this.rails;
    }

    public void setRails(char rails) {
        this.rails = rails;
    }

    public char getDrawers() {
        return this.drawers;
    }

    public void setDrawers(char drawers) {
        this.drawers = drawers;
    }

    public char getCabinet() {
        return this.cabinet;
    }

    public void setCabinet(char cabinet) {
        this.cabinet = cabinet;
    }

}
