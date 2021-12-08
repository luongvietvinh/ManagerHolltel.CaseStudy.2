package service;

import IO.WriteTofileReadFile;
import controller.ControllerRoom;
import model.Room;

import java.util.List;
import java.util.Scanner;


public class RoomService {
    Scanner scanner = new Scanner(System.in);
    ControllerRoom controllerRoom = new ControllerRoom();
    private List<Room> roomList = WriteTofileReadFile.readFileRoom();


    public void saveRoom(Room room) {

        roomList.add(room);
        WriteTofileReadFile.writeToFileRoom(roomList);
    }


    public void delete(int id) {
        roomList.remove(id);
        WriteTofileReadFile.writeToFileRoom(roomList);
    }

    public void editRoom(int index, Room room) {
        roomList.set(index, room);
        WriteTofileReadFile.writeToFileRoom(roomList);
    }

    public int findById(int id) {
        List<Room> roomListpro = WriteTofileReadFile.readFileRoom();
        for (int i = 0; i < roomListpro.size(); i++) {
            if (id == roomListpro.get(i).getIdRoom()) {
                return i;
            }
        }
        return -1;
    }

    public Room searchRomById(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (id == roomList.get(i).getIdRoom()) {
                return roomList.get(i);
            }
        }
        return null;
    }
    // tìm phòng có giá cáo nhất
    public void searchRoomMaxPrice() {

        int index = 0;
        int max = 0;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getPrice() > max) {
                max = (int) roomList.get(i).getPrice();
                index = i;
            }
        }
        System.out.println("phòng giá cao nhất là : " + roomList.get(index));

        qToBackMenu();
    }
    // tìm phòng có giá thấp nhất
    public void searchRoomMinPrice() {

        int index = 0;
        int max = 0;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getPrice() < max) {
                max = (int) roomList.get(i).getPrice();
                index = i;
            }
        }
        System.out.println("phòng giá thấp nhất là : " + roomList.get(index));

        qToBackMenu();
    }



    private void qToBackMenu() {
        System.out.println("nhập phím bất kỳ để tiếp tục- nhập Q để thoát");

        String q = scanner.nextLine();
        if (q.equalsIgnoreCase("q")) {
            controllerRoom.menuOderRoom();
        }
    }

}
