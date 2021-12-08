package controller;

import service.HoltelService;
import view.DichVuHoltelView;

public class DichVuHoltell {



    public void managerDichVuHoltel(){
        HoltelService holtelService = new HoltelService();
        DichVuHoltelView dichVuHoltelView = new DichVuHoltelView();
        ControllerAcccount controllerAcccount = new ControllerAcccount();
        while (true) {
            int choice = dichVuHoltelView.menuManagerDichVu();
            if (choice >= 1 && choice <= 5){
            switch (choice){
                case 1:
                    holtelService.showlist();
                    break;
                case 2:
                    holtelService.addListHoltelService(dichVuHoltelView.addDichVu());
                    break;
                case 3:
                    holtelService.showlist();
                    holtelService.editHoltelService(dichVuHoltelView.editByName(), dichVuHoltelView.editDichVu());

                    break;
                case 4:
                    holtelService.showlist();
                    holtelService.deleteByName(dichVuHoltelView.delete());
                    break;
                case 5:
                    controllerAcccount.menuManageAdmin();
                    break;
            }

        }else
                System.err.println("                           ︻╦╤─ ҉ – – - -           lựa chọn không tồn tại!! chọn theo số từ 1 đến 5");
        }
    }
}
