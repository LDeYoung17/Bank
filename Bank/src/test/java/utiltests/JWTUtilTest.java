package utiltests;

import dev.deyoung.utils.JWTUtils;
import org.junit.jupiter.api.Test;

public class JWTUtilTest {

    @Test
    void creates_jwt(){
        String jwt = JWTUtils.generate("employee", "Jack Harkness");
        System.out.println(jwt);
    }


}
