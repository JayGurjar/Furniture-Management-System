package edu.ucalgary.ensf409;

public class FacultyInfo {
    private String facultyName;
    private String contact;
    private String date;

    public FacultyInfo(){
        this.facultyName = null;
        this.contact = null;
        this.date = null;
    }

    public FacultyInfo(String facultyName, String contact, String date, Order order){
        this.facultyName = facultyName;
        this.contact = contact;
        this.date = date;
    }
}