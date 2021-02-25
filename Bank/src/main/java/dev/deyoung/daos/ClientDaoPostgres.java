package dev.deyoung.daos;

import dev.deyoung.entities.Client;
import dev.deyoung.utils.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClientDaoPostgres implements ClientDAO{


    private Logger logger = Logger.getLogger(ClientDaoPostgres.class.getName());

    @Override
    public Client createClient(Client client) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "insert into ClientDaoPostgres (clientName,SSN) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getClientName());
            ps.setInt(2, client.getSSN());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("clientId");
            client.setClientId(key);
            return client;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Unable to create Client!",sqlException);
            return null;
        }

    }

    @Override
    public Set<Client> getClients() {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from ClientDaoPostgres";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Set<Client> allClients = new HashSet<Client>();
            while (resultSet.next()){
                Client client = new Client();
                client.setClientId(resultSet.getInt("clientId"));
                client.setClientName(resultSet.getString("clientName"));
                client.setSSN(resultSet.getInt("SSN"));
                allClients.add(client);

            }
            return allClients;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Could not get clients!",sqlException);
            return null;
        }
    }

    @Override
    public Client getClientById(int id) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from ClientDaoPostgres where clientId = ?";
            Client client = new Client();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            client.setClientId(resultSet.getInt("clientId"));
            client.setClientName(resultSet.getString("clientName"));
            client.setSSN(resultSet.getInt("SSN"));

            return client;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Could not find that client!",sqlException);
            return null;
        }

    }

    @Override
    public Client getClientBySSN(int ssn) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from ClientDaoPostgres where SSN = ?";
            Client client = new Client();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ssn);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            client.setClientId(resultSet.getInt("clientId"));
            client.setClientName(resultSet.getString("clientName"));
            client.setSSN(resultSet.getInt("SSN"));

            return client;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Could not find that client!",sqlException);
            return null;
        }

    }



    @Override
    public Client updateClient(Client client) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "update ClientDaoPostgres set clientName =?, SSN = ? where clientId = ?";
            //Client client = new Client();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, client.getClientName());
            preparedStatement.setInt(1, client.getSSN());
            preparedStatement.executeUpdate();
            return client;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Unable to create client! Clients cannot be updated once implemented.",sqlException);
            return null;
        }
    }


    @Override
    public boolean deleteClientByClientId(int id) {

        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "delete from clientDaoPostgres where clientId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Unable to delete client with id " + id,sqlException);
            return false;
        }

    }
}
