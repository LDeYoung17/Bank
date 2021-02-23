package dev.deyoung.services;

import dev.deyoung.entities.Account;
import java.util.Set;

public interface AccountService {

    //Create
    Account newAccount (Account account);

    //Read
    Set<Account> getAllAccounts();
    Account getAccountById(int id);
    Set<Account> getAccountByName(String name);
    Account getAccountByAccountNumber(int accountNumber);
    Set<Account> getAccountByClientId(int clientId);


    //Update
     Account updateAccountName(Account account, String name);
     Account updateAccountId(Account account, int accountId);
     Account updateAccountNumber(Account account);
     Account updateClientId(Account account);
     Account changeAccountBalance(Account account, double credit, double debit);
     Account updateAccountBalance(Account account, double accountBalance);
     Account updateAccountActive(Account account);



    //Delete
    boolean deleteAccountByIdOnly(int accountId);


}
