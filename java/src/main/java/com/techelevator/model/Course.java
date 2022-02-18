package com.techelevator.model;

public class Course {
    private int courseId;
    private String courseName;
    private String address;
    private String city;
    private String stateName;
    private int zipcode;
    private double latitude;
    private double longitude;

    public Course(int courseId, String courseName, String address, String city, String stateName, int zipcode, double latitude, double longitude) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.address = address;
        this.city = city;
        this.stateName = stateName;
        this.zipcode = zipcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Course() {

    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", stateName='" + stateName + '\'' +
                ", zipcode=" + zipcode +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

