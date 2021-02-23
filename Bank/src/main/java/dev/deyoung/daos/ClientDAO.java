package dev.deyoung.daos;


import dev.deyoung.entities.Client;
import java.util.Set;

public interface ClientDAO {

    //Create
    Client createClient(Client client);

    //Read
    Set<Client> getClients();
    Client getClientById(int id);
    Client getClientBySSN(int id);

    //Update
    Client updateClient(Client client);


    //Delete
    boolean deleteClientByClientId(int id);

}
