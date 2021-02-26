package dev.deyoung.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

//this creates a JWT!!
public class JWTUtils {
    private static final String secret = "Secrets don't make friends, but friends make secrets!";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    //put in the parameters that you want to be in the body of your JWT

    public static String generate(String role, String employeeName) {

        String token = JWT.create()
                .withClaim("role", role)
                .withClaim("empName", employeeName)
                .sign(algorithm); //this will generate a signature based off of those claims
        return token;
    }

    public static DecodedJWT isValidJWT(String token){
        try {
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            jwt.getClaim("role");
            return jwt;
        }catch(JWTVerificationException e){ //if the exceptin was throw that means the user tampered with the data in JWT!
            e.printStackTrace();
            return null;
        }
    }
}
