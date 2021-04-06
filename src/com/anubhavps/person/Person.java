package com.anubhavps.person;

public class Person {
    String personName;
    Gender gender;
    String phoneNum;
    String mailId;

    public Person(String personName, Gender gender, String phoneNum, String mailId) {
        this.personName = personName;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.mailId = mailId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "personName='" + personName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", mailId='" + mailId + '\'' +
                '}';
    }

}
