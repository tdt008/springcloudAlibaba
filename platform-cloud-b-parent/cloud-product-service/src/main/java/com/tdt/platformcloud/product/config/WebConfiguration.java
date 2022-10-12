package com.tdt.platformcloud.product.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * web相关bean组件配置
 *
 * @version 1.0
 */
//@Configuration
public class WebConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapperImpl();
    }


    public class ObjectMapperImpl extends ObjectMapper {
        /**
         * 统一的日期时间格式
         */
        public static final String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
        /**
         * 统一的日期格式
         */
        public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
        /**
         * 统一的时间格式
         */
        public static final String TIME_FORMAT_PATTERN = "HH:mm:ss";
        public ObjectMapperImpl() {
            // 设置在序列化时字段为NULL也进行序列化
            setSerializationInclusion(JsonInclude.Include.ALWAYS);
            // 设置反序列化时忽略JSON字符串中存在而Java对象实际没有的属性
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            //setTimeZone(TimeZone.getTimeZone(CoreConstant.DEFAULT_TIME_ZONE));

            // 设置日期格式化
            setDateFormat(new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN));

            // Java8 日期相关
            JavaTimeModule javaTimeModule = new JavaTimeModule();
            javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_PATTERN)));
            javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN)));
            javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(TIME_FORMAT_PATTERN)));
            javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_PATTERN)));
            javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN)));
            javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(TIME_FORMAT_PATTERN)));
            registerModule(javaTimeModule);
        }
    }
}