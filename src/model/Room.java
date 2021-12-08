package model;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable {
    private int idRoom;
    public static int idnumber;
    private double price;
    private String description;
    private boolean status;

    public Room() {
    }

    public Room(double price, int day, boolean status) {
    }

    public Room(double price, String description, boolean status) {
        this.idRoom = ++idnumber;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public static int getIdnumber() {
        return idnumber;
    }

    public static void setIdnumber(int idnumber) {
        Room.idnumber = idnumber;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double price) {
        this.price = price;
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public List<Room> setStatus(boolean status) {
        this.status = status;
        return null;
    }

    @Override
    public String toString() {

        return "số phòng: " + idRoom + " ,  < " + " ,  giá phòng : " + price + " , " + " , loại phòng: " + description + " ," + " , tình trạng phòng : " + status + ", > ";
//        return "Room{" +
//                "số phòng=" + idRoom +
//                ", price=" + price +
//                ", description='" + description + '\'' +
//                ", status=" + status +
//                '}';
    }
}
