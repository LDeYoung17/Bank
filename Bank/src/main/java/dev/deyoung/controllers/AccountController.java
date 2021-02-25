package dev.deyoung.controllers;

import com.google.gson.Gson;
import dev.deyoung.daos.AccountDaoPostgres;
import dev.deyoung.daos.ClientDaoPostgres;
import dev.deyoung.entities.Account;
import dev.deyoung.entities.Client;
import dev.deyoung.services.AccountService;
import dev.deyoung.services.AccountServiceImpl;
import dev.deyoung.services.ClientService;
import dev.deyoung.services.ClientServiceImpl;
import io.javalin.http.Handler;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AccountController {

    private AccountService accountService = new AccountServiceImpl(new AccountDaoPostgres());
    private ClientService clientService = new ClientServiceImpl(new ClientDaoPostgres());

    private static boolean updateBalanceOnly1(Account account, double updatedBalance){
        account.setAccountBalance(updatedBalance);
        return true;
    }

    private static boolean updateAccountNumberAfter(Account account, int accountNumber){
        account.setAccountBalance(accountNumber);
        return true;
    }

    private static boolean updateClientIdAfter(Account account, int clientId){
        account.setAccountBalance(clientId);
        return true;
    }

    private static boolean updateAccountIdAfter(Account account, int accountId){
        account.setAccountBalance(accountId);
        return true;
    }



    //Creating accounts
    public Handler createAccountHandler = (ctx) ->{

        int id = Integer.parseInt(ctx.pathParam("id"));
//        Client client = this.clientService.getClientById(id);
//        if(client != null) {
//            String body = ctx.body();
//            Gson gson = new Gson();
//            Account account = gson.fromJson(body, Account.class);
//
//            Account account1 = this.accountService.newAccount(account, client);
//            account1.setClientId(id);
//            String json = gson.toJson(account1);
//            ctx.result(json);
//            ctx.status(201);
//        }else{
//            ctx.result("Sorry! That client does not exist!");
//            ctx.status(404);
//        }

        String body = ctx.body();
        Gson gson = new Gson();
        Account account = gson.fromJson(body, Account.class);
        Client client2 = this.clientService.getClientById(id);

        if(client2 == null){
            ctx.result("Could not create account! Please check that client ID exists.");
            ctx.status(404);
        }else {
            this.accountService.newAccount(account, client2);
            String json = gson.toJson(account);
            account.setClientId(id);
            ctx.result(json);
            ctx.status(201);
        }

    };

    //Getting all accounts
    public Handler getAllAccountsHandler = (ctx) ->{
        String amountSearch = ctx.queryParam("amountLessThan=?&amountGreaterThan?","NONE");// second value is default value

        if (amountSearch.equals("NONE")) {
            Set<Account> allAccounts = this.accountService.getAllAccounts();
            Gson gson = new Gson();
            String accountsJSON = gson.toJson(allAccounts);
            ctx.result(accountsJSON);
            ctx.status(200);
        }
//        }else{
//            //Set<Account> accounts = this.accountService.get();
//            Gson gson = new Gson();
//            String accountbyAmountJSON = gson.toJson(accounts);
//            ctx.result(accountbyAmountJSON);
//            ctx.status(200);
//        }


    };

    //Getting accounts by Account ID
//    public Handler AccountByIdHandler = (ctx) ->{
//        int id = Integer.parseInt(ctx.pathParam("id"));
//        Account account = this.accountService.getAccountById(id);
//        if(account == null){
//            ctx.result("Account not found");
//            ctx.status(404);
//        }else{
//            Gson gson = new Gson();
//            String accountJSON = gson.toJson(account);
//            ctx.result(accountJSON);
//            ctx.status(200);
//        }
//
//    };

    //Getting accounts by account number
    public Handler AccountByNumberHandler = (ctx) ->{
        int accountNumber = Integer.parseInt(ctx.pathParam("accountNumber"));
        Account account = this.accountService.getAccountByAccountNumber(accountNumber);
        if(account == null){
            ctx.result("Account not found");
            ctx.status(404);
        }else{
            Gson gson = new Gson();
            String accountJSON = gson.toJson(account);
            ctx.result(accountJSON);
            ctx.status(200);
        }

    };

    //Getting accounts by Client ID
    public Handler AccountByClientIdHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        Set<Account> accountByClientId = new HashSet<>(this.accountService.getAccountByClientId(id));
            if (accountByClientId.isEmpty()) {
                ctx.result("Account not found");
                ctx.status(404);
            } else {
                Gson gson = new Gson();
                String accountJSON = gson.toJson(accountByClientId);
                ctx.result(accountJSON);
                ctx.status(200);

            }


    };

    //Getting accounts by Account ID per Client ID
    public Handler AccountByAccountandClientIdHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        int id2 = Integer.parseInt(ctx.pathParam("id2"));
        Set<Account> accountByClientId = new HashSet<>(this.accountService.getAccountByClientId(id));
        Set<Account> clientAccountsById = new HashSet<>();
            if (accountByClientId.isEmpty()) {
                ctx.result("Account not found");
                ctx.status(404);
            } else {
                for(Account account: accountByClientId){
                    if(account.getAccountId() == id2){
                        clientAccountsById.add(account);
                        Gson gson = new Gson();
                        String accountJSON = gson.toJson(clientAccountsById);
                        ctx.result(accountJSON);
                        ctx.status(200);
                    }
                }
            }
    };

    //Update Account.
    public Handler updateAccountHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        int id2 = Integer.parseInt(ctx.pathParam("id2"));

        String body = ctx.body();
        Gson gson2 = new Gson();
        Account account = gson2.fromJson(body, Account.class);
        double updatedBalance = account.getAccountBalance();
        double credit = account.getCredit();
        double debit = account.getDebit();
        String name = account.getAccountName();
        int accountNumber = account.getAccountNumber();
        int clientId = account.getClientId();
        int accountId = account.getAccountId();
        //boolean isActive = account.isActive();
        Set<Account> accountByClientId = new HashSet<>(this.accountService.getAccountByClientId(id));
        Set<Account> clientAccountsById = new HashSet<>();
        Set<Account> Inactive = new HashSet<Account>();


        if (accountByClientId.isEmpty()) {
            ctx.result("Account not found");
            ctx.status(404);
        } else {
            for(Account account1: accountByClientId){
                if(account1.getAccountId() == id2){
                    clientAccountsById.add(account);
                }
            }
        }

        for(Account account2 : clientAccountsById) {
            //account2 = accountService.getAccountById(id2);

            //updating account name
            this.accountService.updateAccountName(account2, name);

            //updating account id. This cannot be done after it is set!
            if (updateAccountIdAfter(account2, accountId) == true) {
                ctx.result("Sorry! Account ID cannot be updated once set. If a new account ID is needed, please close the account and create a new one.");
                ctx.status(403);
            }

            //updating account number This cannot be done after it is set!
            if (updateAccountNumberAfter(account2, accountNumber) == true) {
                ctx.result("Sorry! Account number cannot be updated once set. If a new account number is needed, please close the account and create a new one.");
                ctx.status(403);
            }

            //updating client ID. This cannot be done after it is set!
            if (updateClientIdAfter(account2, clientId) == true) {
                ctx.result("Sorry! Client ID cannot be updated once set. If the account's owner needs to be changed, please close the account and create a new one for the correct client.");
                ctx.status(403);
            }

            //updating account balance. Should only be done by entering credit/debit variables!
            if (updateBalanceOnly1(account2, updatedBalance) == true) {
                ctx.result("Sorry! Account balance can only be updated by debit or credit!");
                ctx.status(403);
            } else {
                this.accountService.changeAccountBalance(account2, credit, debit);
            }

            //update if account is active
//            this.accountService.updateAccountActive(account2, isActive);
//            Inactive.add(account2);

        }

        Gson gson = new Gson();
        String accountJSON = gson.toJson(Inactive);
        ctx.result(accountJSON);
        ctx.status(201);


    };

    //delete account
    public Handler deleteAccountHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        int id2 = Integer.parseInt(ctx.pathParam("id2"));
        Set<Account> accountByClientId = new HashSet<>(this.accountService.getAccountByClientId(id));
        Set<Account> clientAccountsById = new HashSet<>();

        if (accountByClientId.isEmpty()) {
            ctx.result("Account not found");
            ctx.status(404);
        } else {
            for(Account account1: accountByClientId){
                if(account1.getAccountId() == id2){
                    clientAccountsById.add(account1);
                }
            }
        }

        for(Account account2 : clientAccountsById) {
            boolean deleted = this.accountService.deleteAccountByIdOnly(id2);
               ctx.result("The account was deleted");
               ctx.status(200);
//            if(account2.isActive() == true){
//                ctx.result("Please deactivate the account before deleting it!");
//                ctx.status(403);
//            }else if(account2.isActive() == false){
//                boolean deleted = this.accountService.deleteAccountByIdOnly(id2);
//                ctx.result("The account was deleted");
//                ctx.status(200);
//            }

        }
    };
}
