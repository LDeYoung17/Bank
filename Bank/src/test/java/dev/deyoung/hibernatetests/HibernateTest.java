package dev.deyoung.hibernatetests;

import dev.deyoung.entities.Client;
import dev.deyoung.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class HibernateTest {

    @Test
    void create_client(){
        SessionFactory sf = HibernateUtil.createSF();
        Session session = sf.openSession();
        session.getTransaction().begin();
        Client client = new Client("John Smith", 0, 1234567890);
        session.save(client);
        session.getTransaction().commit();



    }
}
