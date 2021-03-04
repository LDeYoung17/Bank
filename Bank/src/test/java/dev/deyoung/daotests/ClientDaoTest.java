package dev.deyoung.daotests;

import dev.deyoung.daos.ClientDAO;
import dev.deyoung.daos.HibernateClientDao;
import dev.deyoung.entities.Client;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ClientDaoTest {

    private static ClientDAO clientDao = new HibernateClientDao();
    private static Client testClient = null;

    //Create test

    @Test
    @Order(1)
    void create_client_test(){

        Client JohnSmith = new Client("John Smith",0, 0000000000);
        clientDao.createClient(JohnSmith);
        System.out.println(JohnSmith);
        Assertions.assertEquals(JohnSmith.getClientName(), "John Smith");
        testClient = JohnSmith;

    }

    @Test
    @Order(2)
    void get_client_by_id(){

        int clientID = testClient.getClientId();
        Client client = clientDao.getClientById(clientID);
        //Assertions.assertEquals(testClient.getClientName(), "John Smith");
        Assertions.assertEquals(testClient.getClientName(), client.getClientName());

        System.out.println(testClient.getClientName() + "'s ID number is " + testClient.getClientId());


    }

    @Test
    @Order(3)
    void get_client_by_ssn(){


        int clientSSN = testClient.getSSN();
        Client client = clientDao.getClientBySSN(clientSSN);
        //System.out.println(client);
        //Assertions.assertEquals(testClient.getClientName(), "John Smith");
        Assertions.assertEquals(testClient.getClientName(), client.getClientName());

        System.out.println(client.getClientName() + "'s SSN number is " + client.getSSN());


    }

//    @Test
//    @Order(4)
//    void update_client_ssn(){
//
//        Client client = clientDao.getClientById(testClient.getClientId());
//        client.setSSN(1111111111);
//
//        clientDao.updateClient(client);
//        Client updatedClient = clientDao.getClientById(client.getClientId());
//        Assertions.assertEquals(updatedClient.getSSN(), client.getSSN());
//        System.out.println("Client ID " + testClient.getClientId() + "'s SSN has been updated to " + testClient.getSSN());
//
//
//    }
//
//    @Test
//    @Order(5)
//    void update_client_name(){
//
//        Client client = clientDao.getClientById(testClient.getClientId());
//
//        client.setClientName("Rose Tyler");
//        clientDao.updateClient(client);
//        Client updatedClient = clientDao.getClientById( client.getClientId());
//
//
//        Assertions.assertEquals(updatedClient.getClientName(), client.getClientName());
//
//        System.out.println("Client ID " + testClient.getClientId() + "'s name has been updated to " + testClient.getClientName());
//
//    }


    @Test
    @Order(7)
    void delete_client(){

        int clientId = testClient.getClientId();
        boolean deleted = clientDao.deleteClientByClientId(clientId);

        Assertions.assertTrue(deleted);




    }





}
