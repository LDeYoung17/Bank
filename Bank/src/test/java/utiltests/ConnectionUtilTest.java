package utiltests;

import dev.deyoung.utils.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionUtilTest {

    @Test
    void generate_connection(){

        Connection conn = ConnectionUtil.createConnection();
        Assertions.assertNotNull(conn);
    }


}
