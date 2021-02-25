package dev.deyoung.daos;

import dev.deyoung.entities.Account;
import dev.deyoung.entities.Client;

import java.util.Set;

public interface AccountDAO {

    //Create
    Account createAccount(Account account, Client client);

    //Read
    Set<Account> getAccounts();
    Account getAccountById(int id);
    Account getAccountByAccountNumber(int accountNumber);


    //Update
    Account updateAccount(Account account);


    //Delete
    boolean deleteAccountByAccountId(int id);
}
