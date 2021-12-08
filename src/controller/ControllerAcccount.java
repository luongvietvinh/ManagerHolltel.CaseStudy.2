package controller;

import model.Acccount;
import service.AcccountService;
import view.AcccountView;
import view.RoomView;



public class ControllerAcccount {
    RoomView roomView = new RoomView();
    ControllerBill controllerBill = new ControllerBill();




    public void menuLogin() {
        AcccountView acccountView = new AcccountView();
        AcccountService acccountService = new AcccountService();
        ControllerRoom controllerRoom = new ControllerRoom();

        while (true) {
            int choice = acccountView.menuLogin();
            if (choice >= 1 && choice <= 3) {
                switch (choice) {
                    case 1:
                        Acccount acccount = acccountView.creteAcccount();

                        if (acccountService.loginAdmin(acccount)) {
                           menuManageAdmin();
                            break;
                        } if (acccountService.login(acccount)) {
                            controllerRoom.menuOderRoom();
                            break;
                        }
                    case 2:
                        acccountService.addAcccount(acccountView.creteAcccount());
                        break;
                    case 3:
                        return;
                }
            } else {
                System.err.println("                             ︻╦╤─ ҉ – – - -                 lựa chọn không tồn tại, mời nhập lại");
            }
        }
    }

    public void menuManageAdmin() {
        DichVuHoltell dichVuHoltell = new DichVuHoltell();
        ControllerRoom controllerRoom = new ControllerRoom();
        while (true) {
            int choice = roomView.menuAdmin();
            if (choice >= 1 && choice <= 5) {
                switch (choice) {
                    case 1:
                        controllerAcccount();
                        break;
                    case 2:
                        controllerRoom.controllerRomm();
                        break;
                    case 3:
                        controllerBill.menuManagerBill();
                        break;
                    case 4:
                        dichVuHoltell.managerDichVuHoltel();
                        break;
                    case 5:
                      menuLogin();
                        break;

                }
            } else {
                System.err.println("                    ︻╦╤─ ҉ – – - -      lựa chọn không tồn tại !!!!!, mời nhập lại");
            }
        }
    }

    public void controllerAcccount() {
        AcccountView acccountView = new AcccountView();
        AcccountService acccountService = new AcccountService();
        while (true) {
            int choice = acccountView.menuAdminQuanLyAcccount();
            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1:
                        acccountService.findAll();
                        break;
                    case 2:
                        acccountService.addAcccount(acccountView.creteAcccount());
                        break;
                    case 3:
                        acccountService.findAll();
                        acccountService.deleteByEmail(acccountView.deleteAcccountByEmail());
                    case 4:
                        menuManageAdmin();
                        break;
                }
            } else {
                System.err.println("                         ︻╦╤─ ҉ – – - -              lựa chọn không tồn tại , mời nhập lại");
            }
        }
    }

}
