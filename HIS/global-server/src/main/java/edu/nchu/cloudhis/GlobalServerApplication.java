package edu.nchu.cloudhis;

import edu.nchu.cloudhis.utils.JwtUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient //允许其他服务来访问该服务
@MapperScan("edu.nchu.cloudhis.dao") //mybatis扫描dao的路径
@EnableCaching //启动spring的缓存框架
public class GlobalServerApplication {


    @Value("${jwt.secret:heheehklfdsjfkldsjfkslfjkdslfjdsf}")
    private String secret;
    @Value("${jwt.expire:600000}")
    private Long expire;

    /**
     * 用不登录和注册时对密码进行加密和解密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(GlobalServerApplication.class, args);
    }

    /**
     * 初始化jwttoken的盐和超时时间
     */
    @Bean
    @Lazy(value=false)
    public void initJWT(){
        JwtUtil.secret = secret;
        JwtUtil.expire = expire;
    }
}
