package com.alarm.bluealarm;

public class Records {

    private int sys;
    private int dya;
    private int plu;
    private int fbs;

    @Override
    public String toString() {
        return "Records{" +
                "sys=" + sys +
                ", dya=" + dya +
                ", plu=" + plu +
                ", fbs=" + fbs +
                '}';
    }

    public Records(int sys, int dya, int plu, int fbs) {
        this.sys = sys;
        this.dya = dya;
        this.plu = plu;
        this.fbs = fbs;
    }

    public Records() {
    }

    public int getSys() {
        return sys;
    }

    public void setSys(int sys) {
        this.sys = sys;
    }

    public int getDya() {
        return dya;
    }

    public void setDya(int dya) {
        this.dya = dya;
    }

    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public int getFbs() {
        return fbs;
    }

    public void setFbs(int fbs) {
        this.fbs = fbs;
    }

}
