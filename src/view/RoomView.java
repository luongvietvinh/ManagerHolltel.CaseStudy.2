package view;

import IO.WriteTofileReadFile;
import model.Room;
import service.RoomService;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RoomView {



    public int menuAdmin() {
        System.out.println("                                           ★* Christmas*★ ✈✈ ☁ ☁   MENU QUẢN LÝ ADMIN   ✈✈ ☁ ☁ *.★* Christmas*★            ");
        System.out.println("                                          ☯❖                                                                       ☯       ");
        System.out.println("                                          ☯                           1❖  Quản lý AccCount                         ☯       ");
        System.out.println("                                          ☯                           2❖  Quản lý Room                             ☯        ");
        System.out.println("                                          ☯                           3❖  Quản lý Bill                             ☯        ");
        System.out.println("                                          ☯                           4❖  Quản lý Dịch Vụ                          ☯        ");
        System.out.println("                                          ☯                           5❖  QUAY LẠI MENU ĐĂNG NHẬP                  ☯        ");
        System.out.println("                                          ☯❖                                                                       ☯       ");
        System.out.println("♪|◗ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ. ㍿ ☃㍿ ☃<,︻╦╤─ ҉ – – - -  ✈  ✈ ㍿ ☃㍿ ☃ ㍿ ☃ ـﮩﮩ٨ـ♡ﮩ٨ـ◖☯                                          ");
        return checkLuaChon();
    }

    public Room editRoom() {
        System.out.println("nhập price mới");
        double price = checkMoney();
        System.out.println("nhập lại loại phòng");
        String description = checkName();
        return new Room(price, description, true);
    }

    public int searchById() {
        System.out.println("nhap id phomng");
        return checkId();
    }


    public int menuAdminQuanLyPhong() {
        System.out.println("                                           ★* Christmas*★ ✈✈ ☁ ☁   MENU QUẢN LÝ PHÒNG  ✈✈ ☁ ☁ *.★* Christmas*★          ");
        System.out.println("                                          ☯❖                                                                        ☯       ");
        System.out.println("                                          ☯                           1❖  show Phòng hiện có                        ☯       ");
        System.out.println("                                          ☯                           2❖  Tạo Phòng Mới                             ☯       ");
        System.out.println("                                          ☯                           3❖  Sửa Phòng                                 ☯       ");
        System.out.println("                                          ☯                           4❖  Xóa Phòng ✾⚒                             ☯       ");
        System.out.println("                                          ☯                           5❖  QUAY LẠI MENU QUẢN LÝ ✾⚒                 ☯        ");
        System.out.println("                                          ☯⚒                                                                        ☯       ");
        System.out.println("♪|◗ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ. ㍿ ☃㍿ ☃<,︻╦╤─ ҉ – – - -  ✈  ✈ ㍿ ☃㍿ ☃ ㍿ ☃ ـﮩﮩ٨ـ♡ﮩ٨ـ◖☯                                          ");
        return checkLuaChon();
    }

    public int menuAdminQuanLyBill() {
        System.out.println("                                           ★* Christmas*★ ✈✈ ☁ ☁   MENU QUẢN LÝ BILL  ✈✈ ☁ ☁ *.★* Christmas*★            ");
        System.out.println("                                          ☯❖                                                                       ☯       ");
        System.out.println("                                          ☯                           1❖  show Bill                                ☯       ");
        System.out.println("                                          ☯                           2❖  Thanh Toán Bill                          ☯        ");
        System.out.println("                                          ☯                           3❖  QUAY LẠI MENU QUẢN LÝ                    ☯        ");
        System.out.println("                                          ☯❖                                                                       ☯       ");
        System.out.println("♪|◗ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ. ㍿ ☃㍿ ☃<,︻╦╤─ ҉ – – - -  ✈  ✈ ㍿ ☃㍿ ☃ ㍿ ☃ ـﮩﮩ٨ـ♡ﮩ٨ـ◖☯                                          ");
        return checkLuaChon();
    }


    public int deleteroom() {
        System.out.println(". nhap idRoom can xoa");
        return checkId();

    }


    public Room creteRoom() {
        System.out.println("nhap gia cho phong");
        double price = checkMoney();
        System.out.println("loai phong");
        String deccription = checkName();
        System.out.println("tinh trang phong < true >");
        return new Room(price, deccription, true);

    }


    public void show() {
        List<Room> list = WriteTofileReadFile.readFileRoom();
        for (Room h : list) {
            System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+h.toString());
            System.out.println("                            -------------------------------------------------------------------------------------------------");
        }
    }


    private double checkMoney() {
        Scanner scanner = new Scanner(System.in);
        boolean checkMoney;
        double sumMoney = 0;
        do {
            System.out.println("");
            checkMoney = true;
            try {
                sumMoney = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkMoney = false;
                System.err.println("                            ︻╦╤─ ҉ – – - -        Tiền nhập vào phải là số!!!");
            }
        } while (!checkMoney);
        return sumMoney;
    }

    private int checkId() {
        Scanner scanner = new Scanner(System.in);
        boolean checkId;
        int id = 0;
        do {
            checkId = true;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkId = false;
                System.err.println("                          ︻╦╤─ ҉ – – - -               Id phải là số!!!");
            }
        } while (!checkId);
        return id;
    }

    private int checkLuaChon() {
        Scanner scanner = new Scanner(System.in);
        boolean checklogin;
        int id = 0;
        do {
            checklogin = true;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checklogin = false;
                System.err.println("                                 ︻╦╤─ ҉ – – - -      sai định dạng =>=> phải là số !!! " + " \n" + "                                 ︻╦╤─ ҉ – – - -                 mời  chọn lại:");
            }
        } while (!checklogin);
        return id;
    }

    public String checkName() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (true) {

            name = scanner.nextLine();
            Pattern p = Pattern.compile("^\\pL+[\\pL\\pZ\\pP ]{0,}$");
            if (p.matcher(name).find()) {
//                System.out.println("email la : " + name + "\n" + "----------------------");
                break;
            } else {
                System.err.println("                          ︻╦╤─ ҉ – – - -                   tên phải là chữ-- ko đc nhập số");
            }
        }
        return name;
    }
}
