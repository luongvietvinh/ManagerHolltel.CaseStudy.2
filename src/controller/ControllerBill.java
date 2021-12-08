package controller;

import service.BillService;
import view.BillView;

public class ControllerBill {
    BillView billView = new BillView();
    BillService billService = new BillService();


    public void menuManagerBill() {
        ControllerAcccount controllerAcccount = new ControllerAcccount();
        while (true) {
            int choice = billView.menuManageBill();
            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1:
                        billService.showListBill();
                        break;
                    case 2:
                        billService.showListBill();
                        billView.remoteBillByRoom();
                        break;
                    case 3:
                        billView.caculateSumBill();
                        break;
                    case 4:
                        controllerAcccount.menuManageAdmin();
                        break;
                }
            } else {
                System.err.println("                                   ︻╦╤─ ҉ – – - -lựa chọn không tồn tại!!!!, mời nhập lại");
            }
        }
    }

}
