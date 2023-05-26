package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    public static double minBalance = 0.0;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, minBalance);

        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount > maxWithdrawalLimit)throw new Exception("Maximum Withdraw Limit Exceed");
        else if(super.getBalance()>amount) throw new Exception("Insufficient Balance");

        super.setBalance(super.getBalance() - amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interestForOneYear = super.getBalance() * rate / 100;
        return years * interestForOneYear;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double balance = super.getBalance();
        double ci = Math.pow(balance*(1+(rate/times)), times*years);
        return ci;
    }

}
