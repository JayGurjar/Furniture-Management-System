package edu.ucalgary.ensf409;

class Chair extends OfficeFurniture {
    private char legs;
    private char arms;
    private char seat;
    private char cushion;

    public Chair() {
    }

    public Chair(String id, String type, String manuId, int price, char legs, char arms, char seat, char cushion) {
        super.setId(id);
        super.setType(type);
        super.setManuID(manuId);
        super.setPrice(price);
        setLegs(legs);
        setArms(arms);
        setSeat(seat);
        setCushion(cushion);
    }

    public char getLegs() {
        return this.legs;
    }

    public void setLegs(char legs) {
        this.legs = legs;
    }

    public char getArms() {
        return this.arms;
    }

    public void setArms(char arms) {
        this.arms = arms;
    }

    public char getSeat() {
        return this.seat;
    }

    public void setSeat(char seat) {
        this.seat = seat;
    }

    public char getCushion() {
        return this.cushion;
    }

    public void setCushion(char cushion) {
        this.cushion = cushion;
    }
}
