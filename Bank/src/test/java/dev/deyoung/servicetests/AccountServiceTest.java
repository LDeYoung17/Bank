package dev.deyoung.servicetests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AccountServiceTest {

//    private static Account testAccount = null;
//    private static Account testAccount2 = null;
//    private static AccountService accountservice = new AccountServiceImpl(new AccountDaoPostgres());
//    private static ClientService clientService = new ClientServiceImpl(new ClientDaoPostgres());
//
//    @Test
//    @Order(1)
//
//    void create_account_in_service(){
//        Client client = new Client("John Smith",0 , 11111111);
//        Client client2 = new Client("John Smith",0 , 33333333);
//        Account account = new Account("JohnSmith",0, 0, 0,0.00,0.00,0.00);
//        Account account2 = new Account("JohnSmith checking",0, 0, 0,0.00,0.00,0.00);
//        accountservice.newAccount(account, client);
//        accountservice.newAccount(account2, client2);
//
//        System.out.println(account);
//        System.out.println(account.getAccountName());
//
//        Assertions.assertNotEquals(0, account.getAccountId());
//        Assertions.assertNotEquals(null, account.getAccountName());
//        testAccount = account;
//        testAccount2 = account2;
//
//    }
//
//    @Test
//    @Order(2)
//
//    void get_all_accounts_in_service(){
//
//        Set <Account> accountSet = new HashSet<Account>(accountservice.getAllAccounts());
//        Set <Account> testAccountSet = new HashSet<Account>();
//        testAccountSet.add(testAccount);
//        testAccountSet.add(testAccount2);
//
//        Assertions.assertEquals(accountSet, testAccountSet);
//
//    }
//
//    @Test
//    @Order(3)
//
//    void get_account_by_id(){
//        Account account = testAccount;
//        Account accountIdTime = accountservice.getAccountById(account.getAccountId());
//
//        Assertions.assertEquals(accountIdTime, testAccount);
//
//    }
//
//    @Test
//    @Order(4)
//
//    void get_account_by_account_number(){
//        Account account = testAccount;
//        Account accountByAccountNumber = accountservice.getAccountByAccountNumber(account.getAccountNumber());
//
//        Assertions.assertEquals(accountByAccountNumber, testAccount);
//
//
//    }
//
//    @Test
//    @Order(5)
//
//    void get_account_by_name(){
//
//        Account account = testAccount;
//        Set<Account> accountByName = new HashSet<Account>(accountservice.getAccountByName(account.getAccountName()));
//
//        Assertions.assertTrue(accountByName.contains(testAccount));
//
//    }
//
//    @Test
//    @Order(6)
//
//    void get_account_by_client_id(){
//
//        Account account = testAccount;
//        Set<Account> accountByClientId = new HashSet<Account>(accountservice.getAccountByClientId(account.getClientId()));
//
//        Assertions.assertTrue(accountByClientId.contains(testAccount));
//
//    }
//
//
//
//
//    @Test
//    @Order(7)
//
//    void update_account_balance(){
//
//        Account account = testAccount;
//        Account account2 = testAccount2;
//
//
//
//        Account updatedAccount = accountservice.changeAccountBalance(account, 100, 0);
//        Account updatedAccount2 = accountservice.changeAccountBalance(account2, 0, 200);
//
//
//
//        System.out.println(updatedAccount.getAccountBalance());
//        System.out.println(updatedAccount);
//        System.out.println(updatedAccount2);
//        System.out.println(updatedAccount2.getAccountBalance());
//
//        Assertions.assertNotEquals(0, updatedAccount.getAccountBalance());
//        Assertions.assertNotEquals(0, updatedAccount2.getAccountBalance());
//
//
//    }
////    @Test
////    @Order(8)
////    void set_account_active(){
////
////        Account account = testAccount;
////        Account account2 = testAccount2;
////
////        account2.setActive(false);
////        Account updatedAccount = accountservice.updateAccountActive(account);
////        Account updatedAccount2 = accountservice.updateAccountActive(account2);
////
////        Assertions.assertTrue(updatedAccount.isActive());
////        Assertions.assertFalse(updatedAccount2.isActive());
////
////
////
////    }
//
//    @Test
//    @Order(8)
//
//    void delete_account(){
//
//        Account account = testAccount;
//
//        boolean deleted2 = accountservice.deleteAccountByIdOnly(account.getAccountId());
//        System.out.println(account.getAccountId());
//
//        Assertions.assertTrue(deleted2);
//
//
//
//    }
}
