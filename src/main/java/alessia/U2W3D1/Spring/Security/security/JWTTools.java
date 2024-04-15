package alessia.U2W3D1.Spring.Security.security;

import alessia.U2W3D1.Spring.Security.entities.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTTools {

    public  String createToken(Employee employee){
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .subject(String.valueOf(employee.getId()))
                .signWith(Keys.hmacShaKeyFor("srVPLvgAvrro7K2GxzNXxQWMQ1SKxnxw".getBytes()))
                .compact();

    }
    public void verifyToken(String token){}
}
