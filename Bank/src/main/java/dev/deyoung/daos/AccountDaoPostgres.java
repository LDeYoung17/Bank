package dev.deyoung.daos;

import dev.deyoung.entities.Account;
import dev.deyoung.entities.Client;
import dev.deyoung.utils.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccountDaoPostgres implements AccountDAO{

    private Logger logger = Logger.getLogger(AccountDaoPostgres.class.getName());

    @Override
    public Account createAccount(Account account, Client client) {

        try (Connection conn = ConnectionUtil.createConnection()) {


            String sql = "insert into AccountDaoPostgres (accountName, accountNumber, clientID, credit, debit, accountBalance) values (?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, account.getAccountName());
            ps.setInt(2, account.getAccountNumber());
            ps.setInt(3,client.getClientId());
            ps.setDouble(4, account.getCredit());
            ps.setDouble(5, account.getDebit());
            ps.setDouble(6, account.getAccountBalance());
            //ps.setBoolean(7, account.isActive());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("accountId");
            account.setAccountId(key);

            return account;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Unable to create account!",sqlException);
            return null;
        }

    }

    @Override
    public Set<Account> getAccounts() {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from AccountDaoPostgres";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Set<Account> allAccounts = new HashSet<Account>();
            while (resultSet.next()){
                Account account = new Account();
                account.setAccountId(resultSet.getInt("accountId"));
                account.setAccountNumber(resultSet.getInt("accountNumber"));
                account.setAccountName(resultSet.getString("accountName"));
                account.setClientId(resultSet.getInt("clientId"));
                account.setCredit(resultSet.getDouble("credit"));
                account.setDebit(resultSet.getDouble("debit"));
                account.setAccountBalance(resultSet.getDouble("accountBalance"));
                //account.setActive(resultSet.getBoolean("active"));

                allAccounts.add(account);

            }
            return allAccounts;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Unable to grab accounts!",sqlException);
            return null;
        }
    }

    @Override
    public Account getAccountById(int id) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from AccountDaoPostgres where accountId = ?";
            Account account = new Account();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account.setAccountId(resultSet.getInt("accountId"));
                account.setAccountName(resultSet.getString("accountName"));
                account.setAccountNumber(resultSet.getInt("accountNumber"));
                account.setClientId(resultSet.getInt("clientId"));
                account.setCredit(resultSet.getDouble("credit"));
                account.setDebit(resultSet.getDouble("debit"));
                account.setAccountBalance(resultSet.getDouble("accountBalance"));
                //account.setActive(resultSet.getBoolean("active"));
            }

            return account;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Could not find that account!",sqlException);
            return null;
        }
    }

    @Override
    public Account getAccountByAccountNumber(int accountNumber) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from AccountDaoPostgres where accountNumber = ?";
            Account account = new Account();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account.setAccountId(resultSet.getInt("accountId"));
                account.setAccountName(resultSet.getString("accountName"));
                account.setAccountNumber(resultSet.getInt("accountNumber"));
                account.setClientId(resultSet.getInt("clientId"));
                account.setCredit(resultSet.getDouble("credit"));
                account.setDebit(resultSet.getDouble("debit"));
                account.setAccountBalance(resultSet.getDouble("accountBalance"));
                //account.setActive(resultSet.getBoolean("active"));
            }

            return account;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Could not find that account!",sqlException);
            return null;
        }
    }

    @Override
    public Account updateAccount(Account account) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "update AccountDaoPostgres set accountName = ?, accountNumber = ?, clientId = ?, credit = ?, debit = ?, accountBalance = ? where accountId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, account.getAccountName());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.setInt(3, account.getClientId());
            preparedStatement.setDouble(4, account.getCredit());
            preparedStatement.setDouble(5, account.getDebit());
            preparedStatement.setDouble(6, account.getAccountBalance());
            //preparedStatement.setBoolean(7, account.isActive());
            preparedStatement.setInt(7, account.getAccountId());
            preparedStatement.executeUpdate();
            return account;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Account not updated! Please check and try again",sqlException);
            return null;
        }
    }

    @Override
    public boolean deleteAccountByAccountId(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "delete from AccountDaoPostgres where accountId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Unable to delete Account with id " + id,sqlException);
            return false;
        }

    }
}
