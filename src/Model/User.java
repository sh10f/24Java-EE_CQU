package Model;

import java.util.ArrayList;

public class User {
    private static ArrayList<User> arrayList;
    private int Uid;
    private String Uname;
    private String UPassWord;
    private String UPhone;
    private String UClass;


    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUPassWord() {
        return UPassWord;
    }

    public void setUPassWord(String UPassWord) {
        this.UPassWord = UPassWord;
    }

    public String getUPhone() {
        return UPhone;
    }

    public void setUPhone(String UPhone) {
        this.UPhone = UPhone;
    }

    public String getUClass() {
        return UClass;
    }

    public void setUClass(String UClass) {
        this.UClass = UClass;
    }

    private String getRememberedPassWord(int uid){
        for(User i : arrayList){
            if(i.Uid == uid)
                return i.UPassWord;
        }
        return "";
    }
}
