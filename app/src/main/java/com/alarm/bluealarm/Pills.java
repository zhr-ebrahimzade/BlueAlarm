package com.alarm.bluealarm;

public class Pills {

        private int id;
        private String pillName;
        private String pillColor;
        private String pillDay;
        private  String pillTime;
        private int pillDuration;
        private String pillDescription;
        private boolean alarmed;

        //constructors
        public Pills(int id, String pillName, String pillColor,  String pillDay,  String pillTime,
                     int pillDuration, String pillDescription, boolean alarmed) {
            this.id = id;
            this.pillName = pillName;
            this.pillColor = pillColor;
            this.pillDay = pillDay;
            this.pillTime = pillTime;
            this.pillDuration = pillDuration;
            this.pillDescription = pillDescription;
            this.alarmed = alarmed;
        }

        public Pills() {
        }

        //toString is very necessary for printing the contents of a class

        @Override
        public String toString() {
            return "Pills{" +
                    "id=" + id +
                    ", pillName='" + pillName + '\'' +
                    ", pillColor='" + pillColor + '\'' +
                    ", pillDay=" + pillDay +
                    ", pillTime=" + pillTime +
                    ", pillDuration=" + pillDuration +
                    ", pillDescription='" + pillDescription + '\'' +
                    ", alarmed=" + alarmed +
                    '}';
        }


        //getters and setters


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPillName() {
            return pillName;
        }

        public void setPillName(String pillName) {
            this.pillName = pillName;
        }

        public String getPillColor() {
            return pillColor;
        }

        public void setPillColor(String pillColor) {
            this.pillColor = pillColor;
        }

        public String getPillDay() {
            return pillDay;
        }

        public void setPillDay(String pillDay) {
            this.pillDay = pillDay;
        }

        public String getPillTime() {
            return pillTime;
        }

        public void setPillTime(String pillTime) {
            this.pillTime = pillTime;
        }

        public int getPillDuration() {
            return pillDuration;
        }

        public void setPillDuration(int pillDuration) {
            this.pillDuration = pillDuration;
        }

        public String getPillDescription() {
            return pillDescription;
        }

        public void setPillDescription(String pillDescription) {
            this.pillDescription = pillDescription;
        }

        public boolean isAlarmed() {
            return alarmed;
        }

        public void setAlarmed(boolean alarmed) {
            this.alarmed = alarmed;
        }


}
