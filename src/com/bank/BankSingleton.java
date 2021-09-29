package com.bank;

import com.bank.model.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final public class BankSingleton {
    private static BankSingleton bankSingleton;
    private Map<String,Account> all_accounts = new HashMap();
    private Account loggedIn;

    private BankSingleton(){}

    public static BankSingleton get(){
        if (bankSingleton==null) {
            return new BankSingleton();
        }
        return bankSingleton;
    }

    public static void addAccount(Account account){
        get().all_accounts.put(account.getID(), account);
    }

    public static Account idPassCheck(List<String> values) {
        Account account = get().all_accounts.get(values.get(0));
        if (account != null && account.getPass().equals(values.get(1))){
            return account;
        }
        return null;
    }

    public static void setLoggedIn(Account loggedIn) {
        get().loggedIn = loggedIn;
    }

    public static Account getLoggedIn() {
        return get().loggedIn;
    }

    public static boolean withdraw(String string){
        double amount = Double.parseDouble(string);
        Account loggedIn = getLoggedIn();
        if(amount > loggedIn.getChecking()){
            System.out.println("Not enough Money");
            return false;
        }
        loggedIn.setChecking(loggedIn.getChecking()-amount);
        System.out.printf("%f[.2] Withdrawn, %f[.2] Remaining\n",amount, loggedIn.getChecking());
        return true;
    }

    public static void deposit(String string){
        double amount = Double.parseDouble(string);
        Account loggedIn = getLoggedIn();
        loggedIn.setChecking(loggedIn.getChecking()+amount);
        System.out.printf("%f[.2] Deposited, %f[.2] Remaining\n",amount, loggedIn.getChecking());
    }

    public static void deposit(String account_id, String str_amount) {
        double amount = Double.parseDouble(str_amount);
        Account rec = getAccountByID(account_id);
        rec.setChecking(rec.getChecking()+amount);
        System.out.printf("%f[.2] Deposited, %f[.2] Remaining\n",amount, rec.getChecking());
    }

    private static Account getAccountByID(String account_id) {
        return get().all_accounts.get(account_id);
    }
}
