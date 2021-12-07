package priv.lushiwu.takeout.admin;

import java.time.LocalDate;

/**
 * @Author: lushiwu
 * @Date 2021/12/6 18:01
 */
public class User {
    private String uID;
    private String uName;
    private String uSex;
    private String uPwd;
    private String uAddress;
    private String uTel;
    private LocalDate uTime;

    public User() {
    }

    public User(String uID, String uName, String uSex, String uPwd, String uAddress, String uTel, LocalDate uTime) {
        this.uID = uID;
        this.uName = uName;
        this.uSex = uSex;
        this.uPwd = uPwd;
        this.uAddress = uAddress;
        this.uTel = uTel;
        this.uTime = uTime;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public LocalDate getuTime() {
        return uTime;
    }

    public void setuTime(LocalDate uTime) {
        this.uTime = uTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uID='" + uID + '\'' +
                ", uName='" + uName + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", uTel='" + uTel + '\'' +
                ", uTime=" + uTime +
                '}';
    }
}
