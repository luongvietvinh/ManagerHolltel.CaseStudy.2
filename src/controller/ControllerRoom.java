package controller;

import service.BillService;
import service.HoltelService;
import service.RoomService;
import view.AcccountView;
import view.BillView;
import view.DichVuHoltelView;
import view.RoomView;


public class ControllerRoom {
    RoomView roomView = new RoomView();

    BillService billService = new BillService();

    DichVuHoltelView dichVuHoltelView = new DichVuHoltelView();
    HoltelService holtelService = new HoltelService();


    public void deleteRoom() {
        RoomService roomService = new RoomService();
        int id = roomView.deleteroom();
        int index = roomService.findById(id);
        roomService.delete(index);
    }


    public void menuOderRoom() {
        BillView billView = new BillView();
        RoomService roomService = new RoomService();
        AcccountView acccountView = new AcccountView();
        ControllerAcccount controllerAcccount = new ControllerAcccount();
        RoomView roomView = new RoomView();
        while (true) {
            int choice = acccountView.menuUser();
            if (choice >= 1 && choice <= 9) {
                switch (choice) {
                    case 1:
                        roomView.show();
                        break;
                    case 2:
                        billService.showListBill();
                        break;
                    case 3:
                        roomView.show();
                        billService.addBill(billView.menuDatPhong());
                        break;
                    case 4:
                        managerDichVuHoltel();
                        break;
                    case 5:
                        billService.showListBill();
                        billView.remoteBillByRoom();
                        break;
                    case 6:
                        billService.showListBill();
                        billView.traPhong();
                        break;
                    case 7:

                        roomService.searchRoomMaxPrice();
                        break;
                    case 8:
                        roomService.searchRoomMinPrice();
                        break;
                    case 9:
                        controllerAcccount.menuLogin();
                        break;

                }
            } else {
                System.err.println("                                     ︻╦╤─ ҉ – – - -               lựa chọn không tồn tại, mời nhập lại");
            }
        }
    }


    public void managerDichVuHoltel() {
        BillView billView = new BillView();
        while (true) {
            int choice = dichVuHoltelView.menuDichVuOder();
            if (choice >= 1 && choice <= 3) {
                switch (choice) {
                    case 1:
                        holtelService.showlist();
                        break;
                    case 2:
                        holtelService.showlist();
                        billView.oderDichVuHoltel();
                        break;
                    case 3:
                        menuOderRoom();
                        break;
                }
            } else
                System.out.println("                               ︻╦╤─ ҉ – – - -                 lựa chọn không tồn tại!! nhập lại");
        }
    }


    public void controllerRomm() {
        ControllerAcccount controllerAcccount = new ControllerAcccount();
        RoomService roomService = new RoomService();
        RoomView roomView = new RoomView();
        while (true) {
            int choice = roomView.menuAdminQuanLyPhong();
            if (choice >= 1 && choice <= 5) {
                switch (choice) {
                    case 1:
                        roomView.show();
                        break;
                    case 2:
                        roomService.saveRoom(roomView.creteRoom());
                        break;
                    case 3:
                        roomView.show();
                        int id = roomService.findById(roomView.searchById());
                        roomService.editRoom(id, roomView.editRoom());
                        break;
                    case 4:
                        roomView.show();
                        deleteRoom();
                        break;
                    case 5:
                        controllerAcccount.menuManageAdmin();
                        break;
                }
            } else {
                System.err.println("                                  ︻╦╤─ ҉ – – - -                 lựa chọn không tồn tại , mời nhập lại");
            }
        }
    }

}
