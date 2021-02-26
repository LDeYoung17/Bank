package utiltests;

import com.auth0.jwt.interfaces.DecodedJWT;
import dev.deyoung.utils.JWTUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class JWTUtilTest {

    @Test
    @Order(1)
    void creates_jwt(){
        String jwt = JWTUtils.generate("employee", "Jack Harkness");
        System.out.println(jwt);
    }

    @Test
    @Order(2)
    void decode_jwt(){

        DecodedJWT jwt = JWTUtils.isValidJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiZW1wbG95ZWUiLCJlbXBOYW1lIjoiSmFjayBIYXJrbmVzcyJ9.UMWSTpFKxF2eZRRxRAlWlnGYkGKI6kMBNKxT_OzKE-E");
        String role = jwt.getClaim("role").asString();
        System.out.println(role);

    }


}