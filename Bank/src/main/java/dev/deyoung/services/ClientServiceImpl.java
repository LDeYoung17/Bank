package dev.deyoung.services;

import dev.deyoung.daos.ClientDaoLocal;
import dev.deyoung.entities.Client;
import dev.deyoung.daos.ClientDAO;

import java.util.HashSet;
import java.util.Set;

public class ClientServiceImpl implements ClientService{

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDao) {this.clientDAO = clientDao;}

    @Override
    public Client newClient(Client client) {


        this.clientDAO.createClient(client);
        return client;

    }

    @Override
    public Set<Client> getClients() {
        return this.clientDAO.getClients();
    }

    @Override
    public Set<Client> getClientByName(String name) {
        Set<Client> allClients = this.clientDAO.getClients();
        Set<Client> clientByName = new HashSet<Client>();

        for(Client client : allClients) {
            if (client.getClientName().contains(name)) {
                clientByName.add(client);
            }

        }
            return clientByName;

    }

    @Override
    public Client getClientById(int id) {
        return this.clientDAO.getClientById(id);
    }

    @Override
    public Client getClientBySocial(int SSN) {
        return this.clientDAO.getClientBySSN(SSN);

    }

//    @Override
//    public Client client getClientBySocial(int SSN) {
////        Set<Client> allClients = this.clientDAO.getClients();
////        Set<Client> clientBySSN = new HashSet<Client>();
////
////        for(Client client : allClients){
////            if(client.getSSN() == SSN{
////                clientBySSN.add(client);
////            }
////        }
////
////        return clientBySSN;
//
//        return this.clientDAO.getClientBySSN(SSN);
//    }

//    @Override
//    public Client removeDashes(Client client, int id) {
//        Client updatedClient = this.clientDAO.getClientById(id);
//        String SSN = updatedClient.getSSN();
//        String updateSSN = SSN.replace("-", "");
//        updatedClient.setSSN(updateSSN);
//        client = this.clientDAO.updateClient(updatedClient);
//
//
//
//        return client;
//
//    }

    @Override
    public Client updateClient(Client client) {

        //intentionally left blank. Clients should not be updated after they are implemented
        return null;
    }

    @Override
    public boolean deleteClientByIdOnly(int clientId) {
        return this.clientDAO.deleteClientByClientId(clientId);
    }
}
