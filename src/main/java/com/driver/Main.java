package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        CurrentAccount ca = new CurrentAccount("Ramesh",20000, "11694684646");
        System.out.println(ca.getTradeLicenseId());
    }
}