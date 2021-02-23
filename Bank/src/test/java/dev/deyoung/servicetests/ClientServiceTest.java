package dev.deyoung.servicetests;

import dev.deyoung.daos.ClientDaoLocal;
import dev.deyoung.entities.Client;
import dev.deyoung.services.ClientService;
import dev.deyoung.services.ClientServiceImpl;
import org.junit.jupiter.api.*;
import java.util.HashSet;
import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ClientServiceTest {

    private static Client testClient = null;
    private static ClientService clientservice = new ClientServiceImpl(new ClientDaoLocal());

    @Test
    @Order(1)

    void create_client_in_service(){

        Client client = new Client("John Smith", 0, 1111111111);
        clientservice.newClient(client);

        System.out.println(client);

        Assertions.assertNotEquals(0, client.getClientId());
        testClient = client;

    }

    @Test
    @Order(2)

    void get_all_clients_in_service(){

        Set <Client> clientSet = new HashSet<Client>(clientservice.getClients());
        Set <Client> testClientSet = new HashSet<Client>();
        testClientSet.add(testClient);

        Assertions.assertEquals(clientSet, testClientSet);

    }

    @Test
    @Order(3)

    void get_client_by_id(){
        Client client = testClient;
        Client clientIdTime = clientservice.getClientById(client.getClientId());

        Assertions.assertEquals(clientIdTime, testClient);

    }

    @Test
    @Order(4)

    void get_client_by_ssn(){
        Client client = testClient;
        Client clientSsnTime = clientservice.getClientBySocial(client.getSSN());

        Assertions.assertEquals(clientSsnTime, testClient);

    }

    @Test
    @Order(5)

    void get_client_by_name(){

        Client client = testClient;
        Set<Client> clientByName = new HashSet<Client>(clientservice.getClientByName(client.getClientName()));

        Assertions.assertTrue(clientByName.contains(testClient));

    }



//    @Test
//    @Order(7)
//
//    void delete_client(){
//
//        Client client = testClient;
//        boolean deleted = clientservice.deleteClientByIdOnly(client.getClientId());
//
//
//        Assertions.assertTrue(deleted);
//    }
}
