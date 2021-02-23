package dev.deyoung.services;

import dev.deyoung.entities.Client;

import java.util.Set;

public interface ClientService {

    Client newClient (Client client);

    Set<Client> getClients();
    Set<Client> getClientByName(String name);
    Client getClientById(int id);
    Client getClientBySocial(int SSN);

    //Set<Client> getClientBySocial(int SSN);




    Client updateClient(Client client);

    boolean deleteClientByIdOnly(int clientId);

}
