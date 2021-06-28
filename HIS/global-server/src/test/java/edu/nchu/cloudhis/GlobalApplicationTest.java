package edu.nchu.cloudhis;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class GlobalApplicationTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test(){
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);

        boolean rs = passwordEncoder.matches("12345",encode);
        System.out.println(rs);
    }
}
