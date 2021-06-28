package edu.nchu.cloudhis;

import edu.nchu.cloudhis.filter.JwtTokenFilter;
import edu.nchu.cloudhis.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class AuthGatewayApplication {


    @Value("${jwt.secret:heheehklfdsjfkldsjfkslfjkdslfjdsf}")
    private String secret;
    @Value("${jwt.expire:600000}")
    private Long expire;

    /**
     * 初始化jwttoken的盐和超时时间
     */
    @Bean
    @Lazy(value = false)
    public void initJWT() {
        JwtUtil.secret = secret;
        JwtUtil.expire = expire;
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthGatewayApplication.class, args);
    }

    /**
     * 注入用于验证是否登录的filter
     *
     * @return
     */
    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    /**
     * 配置路由规则
     * global-server公共服务: strip:/global
     * charge-server收费挂号服务: strip: /charge
     * doctor-server医生站服务： strip：/doctor
     * drug-server药房服务: strip: /drug
     * 单独开放登录注册路径： strip:/auth uri:/login /auth/login->global-server
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //路由登录或者注册请求，统一放行，放行时通过stripPrefix去除前缀auth
                // 本地登入: global-server，登陆注册模块
                .route("auth", r -> r.path("/auth/**").filters(f -> f.stripPrefix(1))
                        .uri("lb://global-server"))
                // 微信登入: global-server
                .route("wx-global", r -> r.path("/wx/global/**").filters(f -> f.stripPrefix(2))
                        .uri("lb://global-server"))
                // 微信登入: charge-server
                .route("wx-charge", r -> r.path("/wx/charge/**").filters(f -> f.stripPrefix(2))
                        .uri("lb://charge-server"))
                // 本地登入: global-server，需要token过滤.filter(jwtTokenFilter())
                .route("global", r -> r.path("/global/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://global-server"))
                // 本地登入: charge-server，需要token过滤
                .route("charge", r -> r.path("/charge/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://charge-server"))
                // 本地登入: doctor-server，需要token过滤
                .route("doctor", r -> r.path("/doctor/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://doctor-server"))
                // 本地登入: drug-server，需要token过滤
                .route("drug", r -> r.path("/drug/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://drug-server"))
                .build();
    }
}
