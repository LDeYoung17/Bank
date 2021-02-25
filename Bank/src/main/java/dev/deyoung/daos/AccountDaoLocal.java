package dev.deyoung.daos;

import dev.deyoung.entities.Account;
import dev.deyoung.entities.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccountDaoLocal implements AccountDAO {

    private static Map<Integer, Account> accountTable = new HashMap<Integer,Account>();
    private static int idMaker = 0;
    private static int accountIdMaker = 0;

    @Override
    public Account createAccount(Account account, Client client) {
        account.setAccountId(++idMaker);
        account.setAccountNumber(++accountIdMaker);
        accountTable.put(account.getAccountId(),account);
        return account;
    }

    @Override
    public Set<Account> getAccounts() {
        Set<Account> allAccounts = new HashSet<Account>(accountTable.values());
        return allAccounts;
    }

    @Override
    public Account getAccountById(int id) {
        return accountTable.get(id);
    }

    @Override
    public Account getAccountByAccountNumber(int accountNumber) {
        Set<Account> allAccounts = new HashSet<Account>(accountTable.values());
        Map<Integer, Account> accountByNumberTable = new HashMap<Integer, Account>();;
        for (Account account : allAccounts) {
            accountNumber = account.getAccountNumber();
            accountByNumberTable.put(accountNumber, account);

        }
        Account account1 = accountByNumberTable.get(accountNumber);

        return account1;


    }

    @Override
    public Account updateAccount(Account account) {
        return accountTable.put(account.getAccountId(), account);
    }

    @Override
    public boolean deleteAccountByAccountId(int id) {
        Account account = accountTable.remove(id);

        if (account == null){

            return false;
        }
        else {
            return true;
        }    }
}
