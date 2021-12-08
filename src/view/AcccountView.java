package view;

import controller.ControllerAcccount;
import model.Acccount;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AcccountView {
    Scanner scanner = new Scanner(System.in);
    ControllerAcccount controllerAcccount = new ControllerAcccount();

    public int menuLogin() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                                           ★* Christmas*★ ✈✈ ☁ ☁ weolcome to love hotel ✈✈ ☁ ☁ *.★* Christmas*★            ");
        System.out.println("                                          ☯❖                                                                        ✞       ");
        System.out.println("                                          ☯                           1❖  đăภɢ  nhập™                               ✞       ");
        System.out.println("                                          ☯                           2❖  dang  ky™                                 ✞        ");
        System.out.println("                                          ☯                           3❖  thoat                                     ✞        ");
        System.out.println("                                          ☯❖                                                                        ✞       ");
        System.out.println("♪|◗ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ. ㍿ ☃㍿ ☃<,︻╦╤─ ҉ – – - -  ✈  ✈ ㍿ ☃㍿ ☃ ㍿ ☃ ـﮩﮩ٨ـ♡ﮩ٨ـ◖☯                                          ");
        return checkLogin();
    }


    public Acccount creteAcccount() {
        String mail = getMail();
        String pass = getPass();
        return new Acccount(mail, pass);
    }

    public int menuUser() {
        System.out.println("                                       ⌛☃ ☃ ☃ ★* Christmas*★ ✈✈ ☁ ☁ MENU  ☘ NGƯỜI  ☘ DÙNG ✈✈ ☁ ☁ *.★* Christmas*★ ☃  ☃ ☃ ⌛                    ");
        System.out.println("                                       ⌛                                                                                     ☠ ⌛                    ");
        System.out.println("                                       ⌛             1. Show danh sach phong       ☠  5. xoa phong da dat                      ⌛                    ");
        System.out.println("                                       ⌛             2. phong da dat               ☠  6. thanh toán                            ⌛                    ");
        System.out.println("                                       ⌛             3. dat phong                  ☠  7. tìm phòng có giá cao nhất             ⌛                    ");
        System.out.println("                                       ⌛             4. dich vu holtel             ☠  8. tìm phòng có giá thấp nhất            ⌛                    ");
        System.out.println("                                       ⌛☠                                                                                      ⌛                    ");
        System.out.println("                                       ⌛                               ☠ 9. QUAY LẠI MENU ĐĂNG NHẬP                            ⌛                    ");
        System.out.println("                                       ⌛☠                                                                                      ⌛                    ");
        System.out.println("                                        ✄ ✂✁ ✃ ✄ ✂✁ ✃ ✄ ✂✁ ⚡ ︻╦╤─ ҉ – – - -  ✈  ✈ ⚡ ✁ ✃  ✁ ✃ ✄ ✂✁ ✃ ✄ ✁ ✃ ✄ ✂✁                    ");
        return checkLuaChon();
    }

    public int menuAdminQuanLyAcccount() {
        System.out.println("                                           ★* Christmas*★ ✈✈ ☁ ☁ MENU QUẢN LÝ ACCCOUNT ✈✈ ☁ ☁ *.★* Christmas*★           ");
        System.out.println("                                          ☯❖                                                                        ☯       ");
        System.out.println("                                          ☯                           1❖  show accCount hiện có™                    ☯       ");
        System.out.println("                                          ☯                           2❖  tạo accCount™                             ☯        ");
        System.out.println("                                          ☯                           3❖  xóa AccCount                              ☯        ");
        System.out.println("                                          ☯                           4❖  QUAY LẠI MENU QUẢN LÝ                     ☯        ");
        System.out.println("                                          ☯❖                                                                        ☯       ");
        System.out.println("♪|◗ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ. ㍿ ☃㍿ ☃<,︻╦╤─ ҉ – – - -  ✈  ✈ ㍿ ☃㍿ ☃ ㍿ ☃ ـﮩﮩ٨ـ♡ﮩ٨ـ◖☯                                          ");
        return checkLuaChon();
    }


    public String deleteAcccountByEmail() {
        System.out.println("nhap email can xoa");
        return checkName();
    }


    public String getMail() {
        String mail = "";
        while (true) {
            System.out.println("nhap mail");
            mail = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{2,}@[a-zA-Z]{2,5}(\\.[a-zA-Z]+){1,3}$");
            if (p.matcher(mail).find()) {
                System.out.println("email la : " + mail + "\n" + "----------------------");
                break;
            } else {
                   System.out.println("︻╦╤─ ҉ – – - -  ✈  ✈ ㍿ ☃㍿ ـﮩﮩ٨ـ♡ﮩ٨ـ◖ ـﮩﮩ٨ـ♡ﮩ٨ـ◖");
                    System.err.println("sai định dạng... mail tối thiểu 2 ký tự và có đuôi là @gmail...." );
                    quitMenuLogin();
            }
        }
        return mail;
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
                System.err.println(" sai định dạng =>=> phải là số !!! " + " \n" + " mời  chọn lại:");
            }
        } while (!checklogin);
        return id;
    }

    public String getPass() {
        String past = "";

        while (true) {
            System.out.println("nhap pass ");
            past = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-z0-9]{3,9}$");
            if (p.matcher(past).find()) {
                System.out.println("\n" + " chao mung ban den voi love holtel");
                System.out.println("--------------------------------------------");
                return past;
            } else {
                System.err.println(" ︻╦╤─ ҉ – – - -pass phai la chu thuong toi thieu 3 ky tu va toi da la 9 ");
                quitMenuLogin();
            }
        }
    }
    public String checkName() {
        String name = "";
        while (true) {

            name = scanner.nextLine();
            Pattern p = Pattern.compile("^\\pL+[\\pL\\pZ\\pP ]{0,}$");
            if (p.matcher(name).find()) {
//                System.out.println("email la : " + name + "\n" + "----------------------");
                break;
            } else {
                System.err.println(" ︻╦╤─ ҉ – – - -tên phải là chữ-- ko đc nhập số");
                quitMenuLogin();
            }
        }
        return name;
    }

    private int checkLogin() {
        boolean checklogin;
        int id = 0;
        do {
            checklogin = true;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checklogin = false;
                System.err.println("                                     ︻╦╤─ ҉ – – - -         chưa chọn mà đã đòi đăng nhập ah !!! " + " \n" + "                                     ︻╦╤─ ҉ – – - -             mời nhập lựa chọn :");
            }
        } while (!checklogin);
        return id;
    }



    public void quitMenuLogin(){
        System.out.println("nhập phím bất kỳ để tiếp tục .... nhập Q để thoát");
        String quit = scanner.nextLine();
        if (quit.equalsIgnoreCase("q")){
            controllerAcccount.menuLogin();
        }
    }

}
