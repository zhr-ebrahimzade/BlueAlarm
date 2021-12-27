package com.alarm.bluealarm;

public class Doctors {
    private int id;
    private String drName;
    private String drSpeciality;
    private boolean reminder ;
    private String drDate;
    private String drTime;

    @Override
    public String toString() {
        return "Doctors{" +
                "id=" + id +
                ", drName='" + drName + '\'' +
                ", drSpeciality='" + drSpeciality + '\'' +
                ", reminder=" + reminder +
                ", drDate='" + drDate + '\'' +
                ", drTime='" + drTime + '\'' +
                '}';
    }

    public Doctors(int id, String drName, String drSpeciality, boolean reminder, String drDate, String drTime) {
        this.id = id;
        this.drName = drName;
        this.drSpeciality = drSpeciality;
        this.reminder = reminder;
        this.drDate = drDate;
        this.drTime = drTime;
    }

    public Doctors() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getDrSpeciality() {
        return drSpeciality;
    }

    public void setDrSpeciality(String drSpeciality) {
        this.drSpeciality = drSpeciality;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public String getDrDate() {
        return drDate;
    }

    public void setDrDate(String drDate) {
        this.drDate = drDate;
    }

    public String getDrTime() {
        return drTime;
    }

    public void setDrTime(String drTime) {
        this.drTime = drTime;
    }
}
