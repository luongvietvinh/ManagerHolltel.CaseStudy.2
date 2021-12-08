package model;

import java.io.Serializable;

public class Acccount implements Serializable {
    private String userMail;
    private String pass;

    public Acccount() {
    }

    public Acccount(String userMail, String pass) {
        this.userMail = userMail;
        this.pass = pass;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return " ten tai khoan: " + "\t" + userMail + "\n" +"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t" +"\t"+"\t"+ "pass : " + pass;
    }
}
