package dev.deyoung.services;

import dev.deyoung.daos.AccountDAO;
import dev.deyoung.daos.ClientDAO;
import dev.deyoung.daos.ClientDaoLocal;
import dev.deyoung.entities.Account;
import java.util.HashSet;
import java.util.Set;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDao;
    private static int accountNumberMaker = 0;
    private ClientDAO clientDao = new ClientDaoLocal();
    private ClientService clientService;


    public AccountServiceImpl(AccountDAO accountDao) {this.accountDao = accountDao;}

    //create method
    @Override
    public Account newAccount(Account account) {
        this.accountDao.createAccount(account);
        return account;
    }

    //get methods
    @Override
    public Set<Account> getAllAccounts() {
        return this.accountDao.getAccounts();
    }

    @Override
    public Account getAccountById(int id) {
        return this.accountDao.getAccountById(id);    }

    @Override
    public Set<Account> getAccountByName(String name) {
        Set<Account> allAccounts = this.accountDao.getAccounts();
        Set<Account> accountByName = new HashSet<Account>();

        for(Account account : allAccounts) {
            if (account.getAccountName().contains(name)) {
                accountByName.add(account);
            }

        }
        return accountByName;
    }

    @Override
    public Account getAccountByAccountNumber(int accountNumber) {
        return this.accountDao.getAccountByAccountNumber(accountNumber);

    }

    @Override
    public Set<Account> getAccountByClientId(int clientId) {
        Set<Account> allAccounts = this.accountDao.getAccounts();
        Set<Account> accountByClientId = new HashSet<Account>();

        for(Account account : allAccounts) {
            if (account.getClientId() == clientId) {
                accountByClientId.add(account);
            }

        }
        return accountByClientId;
    }

    //update/set methods
    @Override
    public Account updateAccountName(Account account, String name) {
        Account currentAccount = this.accountDao.getAccountById(account.getAccountId());

        currentAccount.setAccountName(name);

        account = currentAccount;
        this.accountDao.updateAccount(account);

        return account;
    }

    @Override
    public Account updateAccountId(Account account, int accountId) {
        //intentionally left blank. Account id should not be updated after being set.
        return null;
    }

    @Override
    public Account updateAccountNumber(Account account) {
        //intentionally left blank. Account number should not be updated after being set.
        return null;
    }

    @Override
    public Account updateClientId(Account account) {

        //intentionally left blank. Account's client id should not be updated after being set.
        return null;
    }

    @Override
    public Account updateAccountBalance(Account account, double accountBalance) {
        //intentionally left blank. Accounts should only be updated by debits/credits in the changeAccountBalance method
        return null;
    }

    @Override
    public Account changeAccountBalance(Account account, double credit, double debit) {
        Account currentAccount = this.accountDao.getAccountById(account.getAccountId());
        double accountBalance = 0;
        double currentBalance = currentAccount.getAccountBalance();

        if(credit != 0){
            accountBalance = currentBalance + credit;
        }

        else if(debit != 0){
            accountBalance = currentBalance - debit;
        }
        else accountBalance = currentBalance;

        currentAccount.setAccountBalance(accountBalance);

        account = currentAccount;
        this.accountDao.updateAccount(account);

        return account;
    }

    @Override
    public Account updateAccountActive(Account account) {
        Account currentAccount = this.accountDao.getAccountById(account.getAccountId());
        if(currentAccount.isActive() == false && account.isActive() == true){
            account.setActive(false);
        }
        else if(currentAccount.isActive() == true && account.isActive() == false){
            account.setActive(true);
        }

        account = currentAccount;
        this.accountDao.updateAccount(account);

        return account;
    }

    //delete method
    @Override
    public boolean deleteAccountByIdOnly(int accountId) {
        return this.accountDao.deleteAccountByAccountId(accountId);
    }
}
