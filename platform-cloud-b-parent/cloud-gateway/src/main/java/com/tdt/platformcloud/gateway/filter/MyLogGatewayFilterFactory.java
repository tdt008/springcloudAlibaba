package com.tdt.platformcloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义过滤器
 */
@Component
public class MyLogGatewayFilterFactory extends AbstractGatewayFilterFactory<MyLogGatewayFilterFactory.MyLogConfig> {


    public MyLogGatewayFilterFactory() {
        super(MyLogConfig.class);
    }

    /**
     * 读取配置文件中的参数 赋值到 配置类中
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("showLog");
    }

    @Override
    public GatewayFilter apply(MyLogConfig config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (config.showLog) {
                    System.out.println("请求路径：" + exchange.getRequest().getPath());
                }
                return chain.filter(exchange);
            }
        };
    }

    /**
     * 配置类接收配置的参数
     */
    public static class MyLogConfig {
        private boolean showLog;

        public boolean isShowLog() {
            return showLog;
        }

        public void setShowLog(boolean showLog) {
            this.showLog = showLog;
        }
    }
}
