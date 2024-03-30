package Model;

import java.util.ArrayList;

public class Order {
    public int EOid;
    public String EOsender;
    public String EOPhoneS;
    public String EOSenderAddr;
    public int EOWeight;

    public String EOReceiver;
    public String EOPhoneReceiver;
    public String EOReceiverAddr;
    public String ItemClass;


    public int getEOid() {
        return EOid;
    }

    public void setEOid(int EOid) {
        this.EOid = EOid;
    }

    public String getEOsender() {
        return EOsender;
    }

    public void setEOsender(String EOsender) {
        this.EOsender = EOsender;
    }

    public String getEOPhoneS() {
        return EOPhoneS;
    }

    public void setEOPhoneS(String EOPhoneS) {
        this.EOPhoneS = EOPhoneS;
    }

    public String getEOSenderAddr() {
        return EOSenderAddr;
    }

    public void setEOSenderAddr(String EOSenderAddr) {
        this.EOSenderAddr = EOSenderAddr;
    }

    public int getEOWeight() {
        return EOWeight;
    }

    public void setEOWeight(int EOWeight) {
        this.EOWeight = EOWeight;
    }

    public String getEOReceiver() {
        return EOReceiver;
    }

    public void setEOReceiver(String EOReceiver) {
        this.EOReceiver = EOReceiver;
    }

    public String getEOPhoneReceiver() {
        return EOPhoneReceiver;
    }

    public void setEOPhoneReceiver(String EOPhoneReceiver) {
        this.EOPhoneReceiver = EOPhoneReceiver;
    }

    public String getEOReceiverAddr() {
        return EOReceiverAddr;
    }

    public void setEOReceiverAddr(String EOReceiverAddr) {
        this.EOReceiverAddr = EOReceiverAddr;
    }

    public String getItemClass() {
        return ItemClass;
    }

    public void setItemClass(String classIndex) {
        ItemClass = classIndex;
    }
}
