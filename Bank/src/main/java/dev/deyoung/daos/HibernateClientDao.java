package dev.deyoung.daos;

import dev.deyoung.entities.Client;
import dev.deyoung.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class HibernateClientDao implements ClientDAO {

    SessionFactory sf = HibernateUtil.createSF();


    @Override
    public Client createClient(Client client) {

        Session sesh = sf.openSession();
        sesh.getTransaction().begin();
        sesh.save(client);
        sesh.getTransaction().commit();
        sesh.close();
        return client;
    }

    @Override
    public Set<Client> getClients() {
        return null;
    }

    @Override
    public Client getClientById(int id) {
        Session sesh = sf.openSession();
        Client client = sesh.get(Client.class,id);
        sesh.close();
        return client;
    }

    @Override
    public Client getClientBySSN(int id) {
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        Session sesh = sf.openSession();
        sesh.getTransaction().begin();
        sesh.update(client);
        sesh.getTransaction().commit();
        sesh.close();
        return client;
    }

    @Override
    public boolean deleteClientByClientId(int id) {
        Session sesh = sf.openSession();
        sesh.getTransaction().begin();
        sesh.delete(getClientById(id));
        sesh.getTransaction().commit();
        sesh.close();
        return true;
    }



}
