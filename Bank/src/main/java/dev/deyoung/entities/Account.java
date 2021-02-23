package dev.deyoung.entities;

public class Account {

    //JavaBean!



    private String accountName;
    private int accountId;
    private int accountNumber;
    private int clientId;



    private double credit;
    private double debit;
    private double accountBalance;
    private boolean active;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

   public Account(){

    }

    public Account(String accountName, int accountId, int accountNumber, int clientId, double credit, double debit, double accountBalance,  boolean active) {
        this.accountName = accountName;
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.clientId = clientId;
        this.credit = credit;
        this.debit = debit;
        this.accountBalance = accountBalance;
        this.active = active;
    }
    public String getAccountName() {return this.accountName = accountName;
    }
    public int getAccountNumber() {return accountNumber;}

    public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}

    public int getClientId() {return clientId;}

    public void setClientId(int clientId) {this.clientId = clientId;}

    public double getCredit() { return credit;}

    public void setCredit(double credit) {this.credit = credit;}

    public double getDebit() {return debit;}

    public void setDebit(double debit) {this.debit = debit;}

    public double getAccountBalance() {return accountBalance;}

    public void setAccountBalance(double accountBalance) {this.accountBalance = accountBalance;}

    public boolean isActive() {return active;}

    public void setActive(boolean active) {this.active = active;}

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", clientId=" + clientId +
                ", credit=" + credit +
                ", debit=" + debit +
                ", accountBalance=" + accountBalance +
                ", active=" + active +

                '}';
    }
}
