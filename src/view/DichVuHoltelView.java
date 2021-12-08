package view;

import controller.DichVuHoltell;
import model.ServiceHoltel;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DichVuHoltelView {

    DichVuHoltell dichVuHoltell = new DichVuHoltell();
    Scanner scanner = new Scanner(System.in);

    public ServiceHoltel addDichVu() {
        System.out.println("nhập tên sản phẩm");
        String name = checkName();
        System.out.println("nhập giá sản phẩm");
        double price = checkMoney();
        System.out.println("nhập số lượng");
        int quanTiTy = checkId();
        return new ServiceHoltel(name, price, quanTiTy);
    }

    public int menuDichVuOder() {
        System.out.println("                                       ★* Christmas*★ ✈✈ ☁ ☁ MENU  ☘ ODER  ☘ DỊCH VỤ ☘ ✈✈ ☁ ☁ *.★* Christmas*★                           ");
        System.out.println("                                       ⌛                                                                            ⌛                        ");
        System.out.println("                                       ⌛                         1. hiển thị dịch vụ                                ⌛                             ");
        System.out.println("                                       ⌛                         2. chọn dịch vụ                                    ⌛                            ");
        System.out.println("                                       ⌛                         3. QUAY LẠI MENU ĐẶT PHÒNG                         ⌛                            ");
        System.out.println("                                       ⌛                                                                            ⌛                    ");
        System.out.println("                                      ✄ ✂✁ ✃ ✄ ✂✁ ✃ ✄ ✂✁ ⚡ ✄ ✂✁ ✃ ✄ ✂✁ ⚡ ⚡ ✁ ✃ ✄ ✂✁ ✃ ✄ ✁ ✃ ✄ ✂✁             ");
        return checkId();
    }


    public int menuManagerDichVu() {
        System.out.println("                                       ★* Christmas*★ ✈✈ ☁ ☁ MENU  ☘ QUẢN  ☘ LÝ  DỊCH VỤ ☘ ✈✈ ☁ ☁ *.★* Christmas*★                           ");
        System.out.println("                                       ⌛                                                                               ⌛                        ");
        System.out.println("                                       ⌛                         1. hiển thị dịch vụ                                   ⌛                             ");
        System.out.println("                                       ⌛                         2. thêm dịch vụ                                       ⌛                            ");
        System.out.println("                                       ⌛                         3. sửa dịch vụ                                        ⌛                            ");
        System.out.println("                                       ⌛                         4. xóa dịch vụ                                        ⌛                    ");
        System.out.println("                                       ⌛                         5. QUAY LẠI MENU QUẢN LÝ                              ⌛                    ");
        System.out.println("                                       ⌛                                                                               ⌛                    ");
        System.out.println("                                      ✄ ✂✁ ✃ ✄ ✂✁ ✃ ✄ ✂✁ ⚡ ✄ ✂✁ ✃ ✄ ✂✁ ⚡ ⚡ ✁ ✃ ✄ ✂✁ ✃ ✄ ✁ ✃ ✄ ✂✁✂✁             ");
        return checkId();
    }

    public String delete() {
        System.out.println("nhập tên cần xóa");
        String name = checkName();
        return name;
    }

    public String editByName() {
        System.out.println("nhập tên cần sửa");
        String name = checkName();
        return name;
    }

    public ServiceHoltel editDichVu() {
        System.out.println("nhập lại tên sản phẩm");
        String name = checkName();
        System.out.println("nhập lại  giá cho sản phẩm");
        double price = checkMoney();
        System.out.println("nhập lại số lượng");
        int quanTiTy = checkId();
        return new ServiceHoltel(name, price, quanTiTy);
    }


    private int checkMoney() {

        boolean checkMoney;
        int sumMoney = 0;
        do {
            System.out.println();
            checkMoney = true;
            try {
                sumMoney = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkMoney = false;
                System.err.println( "                                ︻╦╤─ ҉ – – - -           Tiền nhập vào phải là số!!!");
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
                System.err.println(  "                                 ︻╦╤─ ҉ – – - -                   Id phải là số!!!");
            }
        } while (!checkId);
        return id;
    }


    public String checkName() {

        String name = "";
        while (true) {
            System.out.println();
            name = scanner.nextLine();
            Pattern p = Pattern.compile("^\\pL+[\\pL\\pZ\\pP ]{0,}$");
            if (p.matcher(name).find()) {
//                System.out.println("email la : " + name + "\n" + "----------------------");
                break;
            } else {
                System.err.println( " ︻╦╤─ ҉ – – - -                 tên phải là chữ-- ko đc nhập số" + " \n");
                System.err.println("︻╦╤─ ҉ – – - -                   nhập phím bất kỳ để tiếp tục ,, nhập Q để thoát");
                String quit = scanner.nextLine();
                if (quit.equalsIgnoreCase("q")){
                    dichVuHoltell.managerDichVuHoltel();
                }
            }
        }
        return name;
    }

}
