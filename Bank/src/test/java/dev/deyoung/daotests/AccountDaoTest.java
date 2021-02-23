package dev.deyoung.daotests;

import dev.deyoung.daos.AccountDAO;
import dev.deyoung.daos.AccountDaoLocal;
import dev.deyoung.entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AccountDaoTest {

        private static AccountDAO accountDAO = new AccountDaoLocal();
        private static Account testAccount = null;

        //Create test

        @Test
        @Order(1)
        void create_account_test(){

            Account JohnSmith = new Account("John Smith checking",0,0, 0, 0.00, 0.00, 0.00, true);
            accountDAO.createAccount(JohnSmith);
            System.out.println(JohnSmith);
            Assertions.assertEquals(JohnSmith.getAccountName(), "John Smith checking");
            testAccount = JohnSmith;

        }

        @Test
        @Order(2)
        void get_account_by_id(){

            int clientID = testAccount.getAccountId();
            Account account = accountDAO.getAccountById(clientID);
            Assertions.assertEquals(testAccount.getAccountBalance(), account.getAccountBalance());

            System.out.println(testAccount.getAccountName() + "'s ID number is " + testAccount.getAccountId());


        }

        @Test
        @Order(2)
        void get_account_by_account_number(){

            int accountNumber = testAccount.getAccountNumber();
            Account account = accountDAO.getAccountByAccountNumber(accountNumber);
            Assertions.assertEquals(testAccount.getAccountNumber(), account.getAccountNumber());

            System.out.println(account.getAccountName() + "'s Account number is " + account.getAccountNumber());


        }

        @Test
        @Order(3)
        void update_account_number(){

            Account account = accountDAO.getAccountById(testAccount.getAccountId());
            account.setAccountNumber(1111111);

            accountDAO.updateAccount(account);

            Assertions.assertEquals(testAccount.getAccountNumber(), account.getAccountNumber());
            System.out.println("Account ID " + testAccount.getAccountId() + "'s Account Number has been updated to " + testAccount.getAccountNumber());


        }

    @Test
    @Order(4)
    void update_account_balance(){

        Account account = accountDAO.getAccountById(testAccount.getAccountId());
        account.setAccountBalance(100.00);

        accountDAO.updateAccount(account);

        Assertions.assertEquals(testAccount.getAccountBalance(), account.getAccountBalance());
        System.out.println("Account ID " + testAccount.getAccountId() + "'s Account Number has been updated to " + testAccount.getAccountBalance());


    }


        @Test
        @Order(5)
        void update_account_name(){

            Account account = accountDAO.getAccountById(testAccount.getAccountId());

            account.setAccountName("Rose Tyler savings");
            accountDAO.updateAccount(account);

            Assertions.assertEquals(testAccount.getClientId(), account.getClientId());

            System.out.println("Account ID " + testAccount.getAccountId() + "'s name has been updated to " + testAccount.getAccountName());

        }


        @Test
        @Order(6)
        void delete_account(){

            int accountId = testAccount.getAccountId();
            boolean deleted = accountDAO.deleteAccountByAccountId(accountId);

            Assertions.assertTrue(deleted);

//            if (deleted){
//
//                System.out.println("The account was deleted");
//
//            }else{
//
//                System.out.println("Sorry, could not delete!");
//            }




        }







}
