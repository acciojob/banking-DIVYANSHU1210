package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;
    public static Double minbalance = 0.0;


    public StudentAccount(String name, double balance, String  institutionName) {
        super(name, balance, minbalance);

        this.institutionName = institutionName;
    }


}
