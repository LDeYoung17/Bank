package dev.deyoung.daos;

import dev.deyoung.entities.Client;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClientDaoLocal implements ClientDAO {

    private static Map<Integer,Client> clientTable = new HashMap<Integer,Client>();
    private static Map<Integer,Client> clientSocialTable = new HashMap<>();

    private static int idMaker = 0;

    @Override
    public Client createClient(Client client) {

        client.setClientId(++idMaker);
        Integer SSN = client.getSSN();
//        String ssnString = SSN.toString();
//        String updateSSN = ssnString.replace("-", "");
        client.setSSN(SSN);
        clientTable.put(client.getClientId(),client);
        clientSocialTable.put(client.getSSN(), client);
        //Client updatedClient = client.getClientId();


        return client;

    }

    @Override
    public Set<Client> getClients() {
        Set<Client> allClients = new HashSet<Client>(clientTable.values());
        return allClients;
    }

//    public Set<Client> getClientsBySocial() {
//        Set<Client> allClientsBySocial = new HashSet<Client>(clientSocialTable.values());
//        return allClientsBySocial;
//    }

    @Override
    public Client getClientById(int id) {

        return clientTable.get(id);

    }

    @Override
    public Client getClientBySSN(int ssn) {

        return clientSocialTable.get(ssn);    }

//    @Override
//    public Client getClientBySSN(String ssn) {
//
//        return clientSocialTable.get(ssn);
//    }


    @Override
    public Client updateClient(Client client) {

        return clientTable.put(client.getClientId(), client);

    }


    @Override
    public boolean deleteClientByClientId(int id) {
        Client client = clientTable.remove(id);

        if (client == null){

            return false;
        }
        else {
            return true;
        }
    }
}
