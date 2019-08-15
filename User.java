package com.util.Dao;

public class User {
    private int uid;
    private String username;
    private String password;
    private String confirm_pwd;
    private String sex;
    private String hobbys;
    private String phone;
    private String email;
    private String addrs;
    private String flag;

    public User() {
    }

    public User(int uid, String username, String password, String confirm_pwd, String sex, String hobbys, String phone, String email, String addrs, String flag) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.confirm_pwd = confirm_pwd;
        this.sex = sex;
        this.hobbys = hobbys;
        this.phone = phone;
        this.email = email;
        this.addrs = addrs;
        this.flag = flag;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_pwd() {
        return confirm_pwd;
    }

    public void setConfirm_pwd(String confirm_pwd) {
        this.confirm_pwd = confirm_pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobbys() {
        return hobbys;
    }

    public void setHobbys(String hobbys) {
        this.hobbys = hobbys;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirm_pwd='" + confirm_pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", hobbys='" + hobbys + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", addrs='" + addrs + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
