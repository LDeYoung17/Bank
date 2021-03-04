package utiltests;

import dev.deyoung.utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class HibernateUtilTest {


    @Test
    void get_SF(){
        SessionFactory sf = HibernateUtil.createSF();
        System.out.println(sf);
    }


}
