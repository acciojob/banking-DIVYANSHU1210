package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public static Double minBalance = 5000.0;
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, minBalance);
        if(balance < minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n = tradeLicenseId.length();

        for(int i=0; i<n-1; i++){
            if(tradeLicenseId.charAt(i) != tradeLicenseId.charAt(i+1)){
                if(i == n-2) return ;
            }
            else break;
        }
        int freq[] = new int[128];
        int maxfreq = Integer.MIN_VALUE;
        int maxd = -1;
        for(int i=0; i<n; i++){
            freq[tradeLicenseId.charAt(i)]++;
            if(freq[tradeLicenseId.charAt(i)] > maxfreq){
                maxfreq = freq[tradeLicenseId.charAt(i)];
                maxd = i;
            }
            maxfreq = Math.max(maxfreq, freq[tradeLicenseId.charAt(i)]);
        }

        if(n%2==0){
            if(maxfreq>(n/2)) throw new Exception("Valid License can not be generated");
        }
        else{
            if(maxfreq>(n+1)/2) throw new Exception("Valid License can not be generated");
        }

//        char [] nl = new char[n];
//        int ele = n;
//        int i = 0;
//        while(ele > 0){
//            while(freq[maxd]>0){
//                nl[i] = (char) maxd;
//                ele--;
//                freq[maxd]--;
//                i = (i + 2);
//            }
//            for(int t=0; t<128; t++) {
//                while (freq[t] > 0) {
//                    nl[i] = (char) t;
//                    ele--;
//                    freq[t]--;
//                    i = (i + 2)%n;
//                }
//            }
//        }
//        tradeLicenseId = nl.toString();
    }

}
