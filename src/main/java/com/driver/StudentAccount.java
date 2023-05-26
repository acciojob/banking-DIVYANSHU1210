package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;
    public static Double minbalance = 0.0;


    public StudentAccount(String name, double balance, String  institutionName) {
        super(name, balance, minbalance);

        this.institutionName = institutionName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public static Double getMinbalance() {
        return minbalance;
    }

    public static void setMinbalance(Double minbalance) {
        StudentAccount.minbalance = minbalance;
    }
}
