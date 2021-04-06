package com.anubhavps.person;

public class Manager extends Person {
    String managerId;

    public Manager(String personName, Gender gender, String phoneNum, String mailId) {
        super(personName, gender, phoneNum, mailId);
    }

    public Manager(String personName, Gender gender, String phoneNum, String mailId, String managerId) {
        super(personName, gender, phoneNum, mailId);
        this.managerId = managerId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Override
    public String getPersonName() {
        return super.getPersonName();
    }

    @Override
    public void setPersonName(String personName) {
        super.setPersonName(personName);
    }

    @Override
    public String getPhoneNum() {
        return super.getPhoneNum();
    }

    @Override
    public void setPhoneNum(String phoneNum) {
        super.setPhoneNum(phoneNum);
    }

    @Override
    public String getMailId() {
        return super.getMailId();
    }

    @Override
    public void setMailId(String mailId) {
        super.setMailId(mailId);
    }

    @Override
    public Gender getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    @Override
    public String toString() {
        return "Store Manager Name : " + this.personName + "\nGender : " + this.gender + "\nManager Phone Number : " + this.phoneNum + "\nManager Mail Id : " + this.mailId;
    }
}
