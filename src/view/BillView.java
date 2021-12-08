package view;

import IO.WriteTofileReadFile;
import controller.ControllerRoom;
import model.Bill;
import model.Room;
import model.ServiceHoltel;
import service.BillService;
import service.HoltelService;
import service.RoomService;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BillView {
    BillService billService = new BillService();
    RoomService roomService = new RoomService();
    List<Room> listRoom = WriteTofileReadFile.readFileRoom();
    List<Bill> listBill = WriteTofileReadFile.readFileBill();
    HoltelService holtelService = new HoltelService();
    List<ServiceHoltel> listDichVu = WriteTofileReadFile.readFileHoltelService();
    Scanner scanner = new Scanner(System.in);


    public void oderDichVuHoltel() {
        ControllerRoom controllerRoom = new ControllerRoom();
        while (true) {
            System.out.println("nhap id phong dat dich vu ");
            int id = checkId();
            int billIndex = billService.searchBillById(id); // tìm bill để thêm dịch vụ

            if (listBill.get(billIndex).isStatus()) { // nếu bill ở trang thái đã là true  thì sẽ tiến hành đặt đồ
                System.out.println("nhap ten dich vu muon dat");
                String nameDichVu = checkName();

                int indexServiceHoltel = holtelService.findByName(nameDichVu);
                listBill.get(billIndex).getDichVu().add(listDichVu.get(indexServiceHoltel));

                WriteTofileReadFile.writeToFileBill(listBill);
                break;
            } else
                System.err.println("                             ︻╦╤─ ҉ – – - -                    khong co dich vu nay");

                qToBackMenu(controllerRoom);
        }
    }


    public void caculateSumBill() {

        double sum = 0;
        for (int i = 0; i < listBill.size(); i++) {
            if (listBill.get(i).isStatus() == false) {
                sum += listBill.get(i).getSumMoney();
            }
        }
        System.out.println("                   ︻╦╤─ ҉ – – - -       tổng doanh thu  là : " + sum + " VND");
    }


    public void traPhong() {
        ControllerRoom controllerRoom = new ControllerRoom();
while (true) {
    System.out.println("nhập số id bill cần thanh toán");
    int id = checkId();

    listBill = WriteTofileReadFile.readFileBill();
    int indexbill = billService.searchBillById(id);  // tìm id theo file bill

    if (listBill.get(indexbill).isStatus() && id == listBill.get(indexbill).getId()) {
        int idRoom = listBill.get(indexbill).getRoom().getIdRoom();
        listBill.get(indexbill).setStatus(false);
        WriteTofileReadFile.writeToFileBill(listBill);

        String serviceHoltel = listDichVu.get(indexbill).getNameService();
        double price = listDichVu.get(indexbill).getPrice();
        int indexRoom = roomService.findById(idRoom);
        listRoom.get(indexRoom).setStatus(true);
        WriteTofileReadFile.writeToFileRoom(listRoom);

        System.out.println(" so tien phong phai trả = " + listBill.get(indexbill).getSumMoney() + " .VND" + " \n"
                + " ten dich vu : " + serviceHoltel + " .  co gia la : " + price + "VND" + "\n" +
                " tong tien phong va tien dich vu la :  " + listBill.get(indexbill).getSumMoney() + price + " VND");
        break;
    } else {
        System.err.println("                      ︻╦╤─ ҉ – – - -                     phòng đã thanh toán!!! mời chọn phòng khác");
        int choice =menuChonPhong();
        if (choice >= 0 && choice <= 1){
        switch (choice){
            case 1:
                traPhong();
                break;
            case 0:
                controllerRoom.menuOderRoom();
                break;
        }
    }else
            System.err.println("                  ︻╦╤─ ҉ – – - -                     chọn 0  hoặc 1 thôi ông tướng");

    }
}
    }
    public int menuChonPhong(){
        System.out.println("                        ︻╦╤─ ҉ – – - -                       nhập 1 .  để tiếp tục");
        System.out.println("                         ︻╦╤─ ҉ – – - -                      nhập 0 .  để quay về menu ");
        return checkId();
    }

    public Bill menuDatPhong() {

        System.out.println("nhap ID phong muon dat");
        int id = checkId();

        Room room = roomService.searchRomById(id);
        if (room.isStatus()) {
            int index = roomService.findById(id);
            listRoom.get(index).setStatus(false);
            WriteTofileReadFile.writeToFileRoom(listRoom);

            String name = checkName();
            int day = checkDay();
            double sumMonney = room.getPrice() * day;
            return new Bill(room, name, day, sumMonney, true);

        } else {
            System.err.println("                              ︻╦╤─ ҉ – – - -                   phòng đã có  người đặt");
            return menuDatPhong();
        }

    }


    public void editbill() {

        listBill = WriteTofileReadFile.readFileBill();
        System.out.println("nhập id bill cần sửa");
        int id = checkId();

        int indexbill = billService.searchBillById(id);  // tìm id theo file bill
        System.out.println("nhập giá mới");
         listBill.get(indexbill).getRoom().setPrice(checkMoney());
        System.out.println();
         listBill.get(indexbill).setDay(checkDay());
        WriteTofileReadFile.writeToFileBill(listBill);

    }


    public int menuManageBill() {
        System.out.println("                                         ★* Christmas*★ ✈✈ ☁ ☁ MENU  ☘ QUẢN  ☘ LÝ  BILL ☘ ✈✈ ☁ ☁ *.★* Christmas*★                           ");
        System.out.println("                                         ⌛                                                                            ⌛                        ");
        System.out.println("                                         ⌛                         1. hiển thị danh sách bill                         ⌛                             ");
        System.out.println("                                         ⌛                         2. xóa bill                                        ⌛                            ");
        System.out.println("                                         ⌛                         3. hiển thị tổng Doanh Thu                         ⌛                    ");
        System.out.println("                                         ⌛                         4. QUAY LẠI MENU QUẢN LÝ                           ⌛                    ");
        System.out.println("                                         ⌛                                                                            ⌛                    ");
        System.out.println("                                        ✄ ✂✁ ✃ ✄ ✂✁ ✃ ✄ ✂✁ ⚡ ✄ ✂✁ ✃ ✄ ✂✁ ⚡ ⚡ ✁ ✃ ✄ ✂✁ ✃ ✄ ✁ ✃ ✄ ✂✁        ");
        return checkLuaChon();
    }

    public void remoteBillByRoom() {
        listBill = WriteTofileReadFile.readFileBill();
        System.out.println("nhập số id bill cần thanh toán");
        int id = checkId();

        WriteTofileReadFile.writeToFileRoom(listRoom);

        int indexbill = billService.searchBillById(id);  // tìm id theo file bill
        int idRoom = listBill.get(indexbill).getRoom().getIdRoom();
        int indexRoom = roomService.findById(idRoom);
        listRoom.get(indexRoom).setStatus(true);
        WriteTofileReadFile.writeToFileRoom(listRoom);

        billService.deleteBill(indexbill);
        System.out.println("                         ︻╦╤─ ҉ – – - -          đã xóa bill có id :  " + id + " khỏi danh sách ");

    }



    private int checkDay() {
        boolean checkNumberOfRental;
        int numberOfRental = 0;
        do {
            System.out.println(" ︻╦╤─ ҉ – – - -      nhập số ngày thuê");
            checkNumberOfRental = true;
            try {
                numberOfRental = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkNumberOfRental = false;
                System.err.println("                          ︻╦╤─ ҉ – – - -                       Số ngày thuê phải là số!!!");
            }
        } while (!checkNumberOfRental);
        return numberOfRental;
    }

    private int checkMoney() {
        boolean checkMoney;
        int sumMoney = 0;
        do {
            System.out.println(" ︻╦╤─ ҉ – – - - ");
            checkMoney = true;
            try {
                sumMoney = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkMoney = false;
                System.err.println("                                     ︻╦╤─ ҉ – – - -                Tiền nhập vào phải là số!!!");
            }
        } while (!checkMoney);
        return sumMoney;
    }

    private int checkId() {
        boolean checkId;
        int id = 0;
        do {
            checkId = true;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkId = false;
                System.err.println("                                   ︻╦╤─ ҉ – – - -          phải là số!!!");
            }
        } while (!checkId);
        return id;
    }


    public String checkName() {
        String name = "";
        while (true) {
            System.out.println("nhap ten");
            name = scanner.nextLine();
            Pattern p = Pattern.compile("^\\pL+[\\pL\\pZ\\pP ]{0,}$");
            if (p.matcher(name).find()) {

                break;
            } else {
                System.err.println("                        ︻╦╤─ ҉ – – - -                tên phải là chữ-- ko đc nhập số");
            }
        }
        return name;
    }

    private int checkLuaChon() {
        boolean checklogin;
        int id = 0;
        do {
            checklogin = true;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checklogin = false;
                System.err.println("                  ︻╦╤─ ҉ – – - -           sai định dạng =>=> phải là số !!! " + " \n" + " mời  chọn lại:");
            }
        } while (!checklogin);
        return id;
    }
    private void qToBackMenu(ControllerRoom controllerRoom) {
        System.out.println("︻╦╤─ ҉ – – - -  nhập phím bất kỳ để tiếp tục , nhập Q để thoát ");
        String quit = scanner.nextLine();
        if (quit.equalsIgnoreCase("q")){
            controllerRoom.managerDichVuHoltel();
        }
    }
}
