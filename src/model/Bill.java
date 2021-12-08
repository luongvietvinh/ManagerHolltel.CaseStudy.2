package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private Room room;
    private int id;
    public static int idnumber;
    private String renterName;       // ten ng thue
    private int day;               // ngay thue
    private double sumMoney;       // tong tien
    private List<ServiceHoltel> dichVu = new ArrayList<>();
    private boolean status;

    public Bill() {
    }

    public Bill(String renterName, int day, double sumMoney) {
        this.id = ++idnumber;
        this.renterName = renterName;
        this.day = day;
        this.sumMoney = sumMoney;
    }


    public Bill(Bill bill, String name, int day, double sum) {
    }

    public Bill(double price, int day, boolean b) {
    }

    public Bill(Room room, String name, int day, double sumMoney, boolean status) {
        this.id = ++idnumber;
        this.room = room;
        this.renterName = name;
        this.day = day;
        this.sumMoney = sumMoney;
        this.status = status;

    }

    public Bill(double price, int day) {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdnumber() {
        return idnumber;
    }

    public static void setIdnumber(int idnumber) {
        Bill.idnumber = idnumber;
    }


    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public int getDay() {
        return day;
    }

    public int setDay(int day) {
        this.day = day;
        return day;
    }


    public List<ServiceHoltel> getDichVu() {
        return dichVu;
    }

    public void setDichVu(List<ServiceHoltel> dichVu) {
        this.dichVu = dichVu;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    @Override
    public String toString() {
        return "hóa đơn ID: " + id + " ==> " + room + "\n" + " tên người đặt :" + renterName + " , " + " , số ngày trọ : " + day + " , tổng tiền : " + sumMoney + " , trạng thái bill: " + status + " , " + dichVu + " (-_-)";

    }
}
