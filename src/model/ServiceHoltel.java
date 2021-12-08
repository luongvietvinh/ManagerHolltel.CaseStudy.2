package model;

import java.io.Serializable;

public class ServiceHoltel implements Serializable {
    private String nameService;
    private double price;
    private int quanTiTy;

    public ServiceHoltel() {
    }

    public ServiceHoltel(String nameService, double price, int quanTiTy) {
        this.nameService = nameService;
        this.price = price;
        this.quanTiTy = quanTiTy;
    }


    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getPrice() {
        return price;
    }

    public int getQuanTiTy() {
        return quanTiTy;
    }

    public void setQuanTiTy(int quanTiTy) {
        this.quanTiTy = quanTiTy;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " dịch vụ khách sạn : " + " tên dịch vụ: " + nameService + " ,  giá :  " + price + " , số lượng : " + quanTiTy + " ..... ";
    }
}
