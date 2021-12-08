package service;

import IO.WriteTofileReadFile;

import model.Acccount;

import java.util.List;


public class AcccountService {

    private List<Acccount> acccountList = WriteTofileReadFile.readFileUser();

// show list accCount
    public List<Acccount> findAll() {
        for (Acccount ac : acccountList) {
            System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+ac);
            System.out.println("                    -----------------------------------------------------------------------");
        }
        return null;
    }
  // add accCount và chẹck nếu đã có tài khoản rồi thì sẽ ko tạo
    public void addAcccount(Acccount acccount) {
        boolean isCheck;
        for (Acccount acc : acccountList) {
            do {
                isCheck = true;
                if (acc.getUserMail().equals(acccount.getUserMail())) {
                    System.err.println("             ︻╦╤─ ҉ – – - -            ten email da ton tai, moi nhap lai");
                }
            } while (!isCheck);

        }
        acccountList.add(acccount);
        WriteTofileReadFile.writeToFileUser(acccountList);

    }

    // kiểm tra đúng sai khi đăng nhập , nếu có tài khoản thì sẽ trả về true ,
    public boolean login(Acccount acccount) {

        while (true) {
            for (Acccount us : acccountList) {
                if (us.getUserMail().equals(acccount.getUserMail()) && us.getPass().equals(acccount.getPass())) {
                    return true;
                }

            }
            return false;
        }
    }

// đăng nhập với tài khoản admin mặc định..
    public boolean loginAdmin(Acccount acccount) {
        while (true) {
            if ("admin@gmail.com".equals(acccount.getUserMail()) && "123".equals(acccount.getPass())) {
                return true;
            }
            return false;
        }
    }

// xóa tài khoản theo email
    public void deleteByEmail(String email) {
        List<Acccount> list = WriteTofileReadFile.readFileUser();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserMail().equals(email)) {
                list.remove(i);
                System.out.println("đã xóa tài khoản : " + email + " thành công ");
                WriteTofileReadFile.writeToFileUser(list);
                break;

            }
        }
    }
}