package dev.deyoung.daotests;

import dev.deyoung.daos.AccountDAO;
import dev.deyoung.daos.AccountDaoPostgres;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AccountDaoTest {
        private static AccountDAO accountDAO = new AccountDaoPostgres();
//        private static Account testAccount = null;
//
//        @Mock AccountDAO accountDao = new AccountDaoLocal();
//
//        //Create test
//
//        @Test
//        @Order(1)
//
//        void create_account_test(){
//            Client JohnSmith = new Client("John Smith",0 , 11111111);
//            Account JohnSmithAccount = new Account("John Smith checking",0,0, 0, 0.00, 0.00, 0.00);
//            accountDao.createAccount(JohnSmithAccount, JohnSmith);
//            System.out.println(JohnSmith);
//            Assertions.assertEquals(JohnSmithAccount.getAccountName(), "John Smith checking");
//            testAccount = JohnSmithAccount;
//
//        }
//
//        @Test
//        @Order(2)
//        void get_account_by_id(){
//
//            int clientID = testAccount.getAccountId();
//            Account account = accountDao.getAccountById(clientID);
//            Assertions.assertEquals(testAccount.getAccountBalance(), account.getAccountBalance());
//
//            System.out.println(testAccount.getAccountName() + "'s ID number is " + testAccount.getAccountId());
//
//
//        }
//
//        @Test
//        @Order(2)
//        void get_account_by_account_number(){
//
//            int accountNumber = testAccount.getAccountNumber();
//            Account account = accountDao.getAccountByAccountNumber(accountNumber);
//            Assertions.assertEquals(testAccount.getAccountNumber(), account.getAccountNumber());
//
//            System.out.println(account.getAccountName() + "'s Account number is " + account.getAccountNumber());
//
//
//        }
//
//        @Test
//        @Order(3)
//        void update_account_number(){
//
//            Account account = accountDao.getAccountById(testAccount.getAccountId());
//            account.setAccountNumber(1111111);
//
//            accountDao.updateAccount(account);
//
//            Assertions.assertEquals(testAccount.getAccountNumber(), account.getAccountNumber());
//            System.out.println("Account ID " + testAccount.getAccountId() + "'s Account Number has been updated to " + testAccount.getAccountNumber());
//
//
//        }
//
//    @Test
//    @Order(4)
//    void update_account_balance(){
//
//        Account account = accountDao.getAccountById(testAccount.getAccountId());
//        account.setAccountBalance(100.00);
//
//        accountDao.updateAccount(account);
//
//        Assertions.assertEquals(testAccount.getAccountBalance(), account.getAccountBalance());
//        System.out.println("Account ID " + testAccount.getAccountId() + "'s Account Number has been updated to " + testAccount.getAccountBalance());
//
//
//    }
//
//
//        @Test
//        @Order(5)
//        void update_account_name(){
//
//            Account account = accountDao.getAccountById(testAccount.getAccountId());
//
//            account.setAccountName("Rose Tyler savings");
//            accountDao.updateAccount(account);
//
//            Assertions.assertEquals(testAccount.getClientId(), account.getClientId());
//
//            System.out.println("Account ID " + testAccount.getAccountId() + "'s name has been updated to " + testAccount.getAccountName());
//
//        }


//        @Test
//        @Order(6)
//        void delete_account(){
//
//            int accountId = testAccount.getAccountId();
//            boolean deleted = accountDao.deleteAccountByAccountId(accountId);
//
//            Assertions.assertTrue(deleted);
//
//
//        }







}
