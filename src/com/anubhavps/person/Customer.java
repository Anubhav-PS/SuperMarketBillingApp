package com.anubhavps.person;

public class Customer extends Person {


    public Customer(String personName, Gender gender, String phoneNum, String mailId) {
        super(personName, gender, phoneNum, mailId);
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
        return "Customer Name : " + this.personName + "\nGender : " + this.gender + "\n Customer Phone Number : " + this.phoneNum + "\n Customer Mail Id : " + this.mailId;
    }
}
