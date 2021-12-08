package IO;

import model.Bill;
import model.Room;
import model.Acccount;
import model.ServiceHoltel;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteTofileReadFile {

 // đọc ghi file accCount

    public static List<Acccount> readFileUser(){
       try {
           File file = new File("user.txt");
           if (!file.isFile()){
               file.createNewFile();
           }
           FileInputStream fis = new FileInputStream("user.txt");
            if (fis.available() != 0){
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (List<Acccount>) ois.readObject();
            }
            return new ArrayList<>();
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }
       return null;
    }

    public static void writeToFileUser(List<Acccount> acccountList){
        try {
            FileOutputStream fos = new FileOutputStream("user.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(acccountList);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


  // đọc ghi file room

    public static List<Room> readFileRoom(){
        try {
            File file = new File("room.txt");
            if (!file.isFile()){
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream("room.txt");
            if (fis.available() != 0){
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (List<Room>) ois.readObject();
            }
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeToFileRoom(List<Room> roomList){
        try {
            FileOutputStream fos = new FileOutputStream("room.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(roomList);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


 // đọc ghi file bill

    public static List<Bill> readFileBill(){
        try {
            File file = new File("bill.txt");
            if (!file.isFile()){
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream("bill.txt");
            if (fis.available() != 0){
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (List<Bill>) ois.readObject();
            }
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeToFileBill(List<Bill> billList){
        try {
            FileOutputStream fos = new FileOutputStream("bill.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(billList);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // dọc ghi file dịch vụ

    public static List<ServiceHoltel> readFileHoltelService(){
        try {
            File file = new File("dichvu.txt");
            if (!file.isFile()){
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream("dichvu.txt");
            if (fis.available() != 0){
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (List<ServiceHoltel>) ois.readObject();
            }
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeToFileHoltelService(List<ServiceHoltel> listDichVu){
        try {
            FileOutputStream fos = new FileOutputStream("dichvu.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listDichVu);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
