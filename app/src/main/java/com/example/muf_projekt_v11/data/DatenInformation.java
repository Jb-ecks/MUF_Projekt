package com.example.muf_projekt_v11.data;

public class DatenInformation {

    private  String[] datenframe;
    private String mesungsname;
    private int messungid;
    private int frequenz;
    private float P1;
    private float P2;
    private float P3;
    private float P4;

    public float getP1() {
        return P1;
    }

    public void setP1(float p1) {
        P1 = p1;
    }

    public float getP2() {
        return P2;
    }

    public void setP2(float p2) {
        P2 = p2;
    }

    public float getP3() {
        return P3;
    }

    public void setP3(float p3) {
        P3 = p3;
    }

    public float getP4() {
        return P4;
    }

    public void setP4(float p4) {
        P4 = p4;
    }

    public String[] getDatenframe() {
        return datenframe;
    }

    public void setDatenframe(String[] datenframe) {
        this.datenframe = datenframe;
    }

    public String getMesungsname() {
        return mesungsname;
    }

    public void setMesungsname(String mesungsname) {
        this.mesungsname = mesungsname;
    }

    public int getMessungid() {
        return messungid;
    }

    public void setMessungid(int messungid) {
        this.messungid = messungid;
    }

    public int getFrequenz() {
        return frequenz;
    }

    public void setFrequenz(int frequenz) {
        this.frequenz = frequenz;
    }
}
