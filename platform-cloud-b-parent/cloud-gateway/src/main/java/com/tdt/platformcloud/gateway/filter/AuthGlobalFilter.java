package com.tdt.platformcloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (StringUtils.hasText(token)) {
            // TODO 处理鉴权逻辑
            System.out.println("auth: 鉴权成功");
            return chain.filter(exchange);
        } else {
            System.out.println("auth: token丢失！！");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }

    /**
     * 数值越小越先执行
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
