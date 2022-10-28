package com.tdt.platformcloud.gateway.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.AgeRoutePredicateConfig> {

    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateConfig.class);
    }

    // 用于从配置文件中获取参数值赋值到配置类中的属性上
    @Override
    public List<String> shortcutFieldOrder() {
        // 这里的顺序要跟配置文件中的参数顺序一致
        return Arrays.asList("minAge", "maxAge");
    }

    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateConfig config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String age = serverWebExchange.getRequest().getQueryParams().getFirst("age");
                if (StringUtils.hasText(age)) {
                    int targetAge = Integer.parseInt(age);
                    return targetAge >= config.getMinAge() && targetAge <= config.getMaxAge();
                }

                return false;
            }
        };
    }

    /**
     * 用于接收配置文件中的参数
     */
    public static class AgeRoutePredicateConfig {
        private int minAge;
        private int maxAge;

        public int getMinAge() {
            return minAge;
        }

        public void setMinAge(int minAge) {
            this.minAge = minAge;
        }

        public int getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(int maxAge) {
            this.maxAge = maxAge;
        }
    }
}
