package dev.deyoung.services;

import dev.deyoung.entities.Account;
import dev.deyoung.entities.Client;

import java.util.Set;

public interface AccountService {

    //Create
    Account newAccount (Account account, Client client);

    //Read
    Set<Account> getAllAccounts();
    Account getAccountById(int id);
    Set<Account> getAccountByName(String name);
    Account getAccountByAccountNumber(int accountNumber);
    Set<Account> getAccountByClientId(int clientId);
    double getAccountBalance(int id, double accountBalance);


    //Update
     Account updateAccountName(Account account, String name);
     Account changeAccountBalance(Account account, double credit, double debit);
     //Account updateAccountActive(Account account, boolean isActive);



    //Delete
    boolean deleteAccountByIdOnly(int accountId);


}
