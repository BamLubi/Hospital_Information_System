package edu.nchu.cloudhis.filter;


import com.nimbusds.jose.JOSEException;
import edu.nchu.cloudhis.model.UserInfo;
import edu.nchu.cloudhis.utils.JwtException;
import edu.nchu.cloudhis.utils.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.text.ParseException;

/**
 * JwtTokenFilter用于拦截登录后的一些请求，判断请求头中是否有合法的access-token，如果有
 * 就放行，并且在请求头中带着username和uid等用户信息，并且在响应回来时，再次拦截，在响应头中
 * 更新新的access-token
 */
public class JwtTokenFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //1.获取token
        String token = exchange.getRequest().getHeaders().getFirst("access-token");
        try {
            UserInfo userInfo = JwtUtil.validToken(token);

            return chain.filter(exchange.mutate()
                    .request(exchange.getRequest().mutate()
                            .header("username", userInfo.getUsername())
                            .header("uid", userInfo.getId()).build())
                    .build()).then(Mono.fromRunnable(() -> {
                        try {
                            String newToken = JwtUtil.genToken(userInfo.getId(), userInfo.getUsername());
                            exchange.getResponse().getHeaders().set("access-token",newToken);
                        } catch (JOSEException e) {
                            e.printStackTrace();
                        }
                    }
            ));
        } catch (ParseException | JOSEException | JwtException e) {
            e.printStackTrace();
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
